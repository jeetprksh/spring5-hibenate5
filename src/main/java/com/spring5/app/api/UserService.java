package com.spring5.app.api;

import com.spring5.app.pojo.ServerResponse;

public interface UserService {
	
	public ServerResponse getUser(Long userId);

}
