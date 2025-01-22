package com.iastech.use.service.payload;


import java.util.ArrayList;
import java.util.List;

import com.iastech.use.service.entities.Rating;

import lombok.Data;

@Data
public class UserDto {
	private String userId;
	private String userName;
	private String email;
	private String about;
	private List<Rating> ratings=new ArrayList<>();
}
