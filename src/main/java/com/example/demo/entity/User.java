package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_user2")
@Getter
@Setter
public class User {

	@Id
	private String username;
	private String password;
	private String name;
	private String role;
}
