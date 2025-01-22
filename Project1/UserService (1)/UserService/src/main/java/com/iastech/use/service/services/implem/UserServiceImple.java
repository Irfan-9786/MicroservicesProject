package com.iastech.use.service.services.implem;

import java.util.Arrays;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.iastech.use.service.entities.Hotel;
import com.iastech.use.service.entities.Rating;
import com.iastech.use.service.entities.User;
import com.iastech.use.service.exceptions.ResourceNotFoundException;
import com.iastech.use.service.external.services.HotelService;
import com.iastech.use.service.external.services.RatingService;
import com.iastech.use.service.payload.UserDto;
import com.iastech.use.service.repositories.UserRepository;
import com.iastech.use.service.services.UserService;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HotelService hotelService;
	@Autowired
	private RatingService ratingService;

	@Override
	public User saveUser(User user) {

		String randomId = UUID.randomUUID().toString();
		user.setUserId(randomId);
		return userRepository.save(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		List<UserDto> userDtos = users.stream().map((user) -> this.modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());
		List<UserDto> getAllUsersDtos = userDtos.stream().map(userDto -> {

			List<Rating> ratings = ratingService.getRating(userDto.getUserId());
			List<Rating> ratingwithHoteList = ratings.stream().map(rating -> {
				Hotel hotel = hotelService.getHotel(rating.getHotelId());
				rating.setHotel(hotel);
				return rating;
			}).collect(Collectors.toList());
			userDto.setRatings(ratingwithHoteList);
			return userDto;

		}).collect(Collectors.toList());

		return getAllUsersDtos;
	}

	@Override
	public UserDto getUserById(String userId) {
		User user = userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User with " + userId + " does not exist in database...!!!"));
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		Rating[] ratingbyUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/userId/" + userId,
				Rating[].class);
		List<Rating> ratings = Arrays.stream(ratingbyUser).toList();
		List<Rating> ratingwithHoteList = ratings.stream().map(rating -> {
			 ResponseEntity<Hotel> hotel = restTemplate
			 .getForEntity("http://HOTEL-SERVICE/hotels/hotelId/" + rating.getHotelId(),
			 Hotel.class);
			 Hotel hotel2 = hotel.getBody();
			rating.setHotel(hotel2);
			return rating;
		}).collect(Collectors.toList());
		userDto.setRatings(ratingwithHoteList);
		return userDto;
	}

	@Override
	public UserDto getUserByUserName(String userName) {
		User user = userRepository.findByUserName(userName).orElseThrow(() -> new ResourceNotFoundException(
				"User with USERNAME = " + userName + ", not exist in database...!!! "));
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		Rating[] ratingbyUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/userId/"+userDto.getUserId() ,
				Rating[].class);
		List<Rating> ratings = Arrays.stream(ratingbyUser).toList();
		List<Rating> ratingwithHoteList = ratings.stream().map(rating -> {
			Hotel hotel2 = hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel2);
			return rating;
		}).collect(Collectors.toList());
		userDto.setRatings(ratingwithHoteList);
		return userDto;
	}

}
