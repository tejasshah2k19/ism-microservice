package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Department;
import com.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepo;

	public void addDepartment(Department department) {
		log.info("DepartmentService :: addDepartment()");
		departmentRepo.save(department);
	}

	public Department getDepartmentById(Integer departmentId) {
		log.info("DepartmentService :: getDepartmentById()");
		return departmentRepo.findById(departmentId).get();
	}

}
