package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entity.User;
import com.repository.UserRepository;
import com.vo.Department;
import com.vo.UserDepartment;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	RestTemplate restTemplate;

	public void saveUser(User user) {
		log.info("UserService :: saveUser()");
		userRepo.save(user);
	}

	public UserDepartment findUserByUserId(Integer userId) {
	
 
		log.info("UserService :: findByUserId()");
		UserDepartment userDepartment = new UserDepartment();
		
		User user = userRepo.findById(userId).get();
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/"+user.getDepartmentId(), Department.class);

		userDepartment.setUser(user);
		userDepartment.setDepartment(department);
		
		
		return userDepartment;
	}

}
