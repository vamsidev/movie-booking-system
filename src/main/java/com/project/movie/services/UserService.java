package com.project.movie.services;

import java.util.Optional;

import com.project.movie.convertor.UserConvertor;
import com.project.movie.exceptions.UserExist;
import com.project.movie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movie.entities.User;
import com.project.movie.request.UserRequest;

@Service
public class UserService {

	@Autowired
    UserRepository userRepository;


	public String addUser(UserRequest userRequest) {
		Optional<User> users = userRepository.findByEmailId(userRequest.getEmailId());
		
		if (users.isPresent()) {
			throw new UserExist();
		}

		User user = UserConvertor.userDtoToUser(userRequest,  "pass");

		userRepository.save(user);
		return "User Saved Successfully";
	}

}
