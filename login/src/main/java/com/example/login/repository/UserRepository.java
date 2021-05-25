package com.example.login.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.login.dto.UserDTO;
import com.example.login.models.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	public void save(UserDTO user);
	public List<UserEntity> findAllUsers();
boolean isUserExist(UserEntity user);
public UserEntity findById(long id);
}
