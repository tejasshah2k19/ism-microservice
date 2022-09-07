package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Department;
import com.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@PostMapping
	public ResponseEntity<?> addDepartment(@RequestBody Department department) {
		log.info("DepartmentController :: addDepartment()");
		departmentService.addDepartment(department);
		return ResponseEntity.ok(department);
	}

	@GetMapping("/{departmentId}")
	public Department findDepartmentById(@PathVariable("departmentId") Integer departmentId) {
		log.info("DepartmentController :: findDepartmentById()");
		Department department = departmentService.getDepartmentById(departmentId);

		return department;
	}
}
