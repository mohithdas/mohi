package com.example.login.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login.dto.UserDTO;
import com.example.login.models.UserEntity;
import com.example.login.repository.UserRepository;
import com.example.login.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository urepo;
	
	public UserServiceImpl() {
		super();
	}

	public UserServiceImpl(UserRepository urepo) {
		super();
		this.urepo = urepo;
	}

	public void save(UserDTO user) {
		UserEntity u = new UserEntity();
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		u.setUsername(user.getUsername());
		urepo.save(u);
	}

	public List<UserEntity> findAllUsers() {
		// TODO Auto-generated method stub
		return (List<UserEntity>) urepo.findAll();
	}

//	public Optional<UserEntity> findById(long id) {
//		return urepo.findById((int) id);
//	}

	public boolean isUserExist(UserDTO user) {
		return false;
	}

	public UserEntity findById(long id) {
		return urepo.findById(id);
	}

//	@Override
//	public UserEntity save(UserDTO user) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
}
