package com.amar.blogappapis.services;

import java.util.List;

import com.amar.blogappapis.payloads.UserDto;

public interface UserService {
	
	UserDto createuser(UserDto user);
	UserDto updateuser(UserDto user, Integer userId);
	UserDto getuserById(Integer userId);
	List<UserDto> getAllusers();
	void deleteUser(Integer userId);
}
