package com.spring5.app.dao;

import com.spring5.app.dto.UserDTO;

public interface UserDao {
	
	public UserDTO getUser(Long userId);

}
