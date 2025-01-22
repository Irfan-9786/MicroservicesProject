package com.iastech.hotel.service.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staffs")
public class StaffController {
//this restcontroller is just for understanding of API Gateway
	@GetMapping
	public List<String> getStaff(){
		
		return Arrays.asList("Irfan","Ajay","Amar","Satish"); 
	}
}
