package com.uv.dbcds.meetup.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Reservation {
	
	@NotNull
	@Size(min=1, max=50)
	private String name;
	
	@NotNull
	@Email(message="{mi.mensaje}")
	private String email;
	
	@NotNull
	@Min(18)
	@Max(65)
	private int age;
	
	public Reservation() {
		this.email = "sample@doamin.com";
	}
	
	public Reservation(String name, String email, int age) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
