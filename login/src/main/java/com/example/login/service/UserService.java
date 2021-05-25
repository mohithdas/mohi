package com.example.login.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.login.dto.UserDTO;
import com.example.login.models.UserEntity;
@Service
public interface UserService {

	public void save(UserDTO user);
	List<UserEntity> findAllUsers();
	boolean isUserExist(UserDTO user);
}
