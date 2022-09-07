package com.vo;

import com.entity.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDepartment {

	User user;
	Department department;

}
