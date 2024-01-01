package org.dnyanyog.service;

import java.util.Optional;

import org.dnyanyog.dto.User;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagementservice {
	
	@Autowired
	UsersRepository userRepo;
	
	public UserResponse addUpdateUser(UserRequest request)
	{
		UserResponse response=new UserResponse();
		
		Users usersTable=new Users();
		
		usersTable.setAge(request.getAge());
		usersTable.setEmail(request.getEmail());
		usersTable.setPassword(request.getPassword());
		usersTable.setUsername(request.getUsername());
		
		usersTable=userRepo.save(usersTable);
		
		response.setMessage("User added successfully");
		response.setStatus("Success");
		response.setUserId(usersTable.getUserId());
		
		return response;
	}
	
	public User getSingleUser(Long userId) {
		
		User userResponse = new User();
		
		Optional<Users> receivedData = userRepo.findById(userId);
		
		if(receivedData.isEmpty()) {
			userResponse.setStatus("Fail");
			userResponse.setMessage("User not found ");
		}else {
			Users user = receivedData.get();
			userResponse.setStatus("Success");
			userResponse.setMessage("User Found");
		    userResponse.setEmail(user.getEmail());
		    userResponse.setUsername(user.getUsername());
		    userResponse.setPassword(user.getPassword());
		    userResponse.setUserId(user.getUserId());
		    userResponse.setAge(user.getAge());
		}
		return userResponse;
		
	}

}
