package com.iastech.use.service.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Hotel {
	private String id;
	private String name;
	private String location;
	private String about;
}
