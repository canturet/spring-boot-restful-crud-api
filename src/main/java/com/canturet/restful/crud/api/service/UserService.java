package com.canturet.restful.crud.api.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.canturet.restful.crud.api.entity.User;
import com.canturet.restful.crud.api.exception.ResourceNotFoundException;
import com.canturet.restful.crud.api.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id : " + id));
	}

	public String deleteUser(Long id) {
		User existingUser = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id : " + id));
		userRepository.deleteById(id);
		return "User deleted : " + id;
	}

	public User updateUser(User user) {
		User existingUser = userRepository.findById(user.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id : " + user.getId()));
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		return userRepository.save(existingUser);
	}

}
