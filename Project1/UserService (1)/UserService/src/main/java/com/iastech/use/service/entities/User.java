package com.iastech.use.service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="micro_users")
public class User {
	@Id
	@Column(name="ID")
	private String userId;
	@Column(name="NAME")
	private String userName;
	@Column(name="EMAIL")
	private String email;
	@Column(name="ABOUT")
	private String about;
	
}
