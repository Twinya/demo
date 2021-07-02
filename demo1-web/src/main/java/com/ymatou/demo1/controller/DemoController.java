package com.ymatou.demo1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ymatou.demo1.facade.model.AddUserDTO;
import com.ymatou.demo1.facade.model.AddUserResult;

import io.swagger.annotations.ApiParam;

@RestController
public class DemoController {
	@PostMapping("/demo/addUser")
	public AddUserResult addUser(@ApiParam AddUserDTO addUserDto) {
		AddUserResult r = new AddUserResult();
	
		return r;
	}
}
