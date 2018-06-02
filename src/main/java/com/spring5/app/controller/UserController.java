package com.spring5.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring5.app.api.UserService;
import com.spring5.app.pojo.ServerResponse;

@RestController()
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService service;

	@RequestMapping(value = "{userId}", method = RequestMethod.GET)
	public @ResponseBody ServerResponse getUser(@PathVariable("userId") Long userId) {
		return this.service.getUser(userId);
	}
}
