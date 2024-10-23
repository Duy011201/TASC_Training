package com.starship.demo.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class UserEntity {
	@Id
	@NotBlank(message = "ID is mandatory")
	private String id;

	@Column(name = "name")
	@NotBlank(message = "Name is mandatory")
	@Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
	private String name;

	@Column(name = "age")
	@Min(value = 0, message = "Age must be a positive number")
	@Max(value = 150, message = "Age must be less than or equal to 150")
	private int age;

	public UserEntity(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public UserEntity() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" +
						"id='" + id + '\'' +
						", name='" + name + '\'' +
						", age=" + age +
						'}';
	}
}
