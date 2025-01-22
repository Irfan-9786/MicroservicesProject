package com.iastech.use.service.services;

import java.util.List;

import com.iastech.use.service.entities.User;
import com.iastech.use.service.payload.UserDto;

public interface UserService {
User saveUser(User user);
List<UserDto> getAllUsers();
UserDto getUserById(String userId);
UserDto getUserByUserName(String userName);
}
