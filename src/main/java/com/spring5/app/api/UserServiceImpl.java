package com.spring5.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring5.app.dao.UserDao;
import com.spring5.app.dto.UserDTO;
import com.spring5.app.pojo.ServerResponse;
import com.spring5.app.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	@Transactional(readOnly = true)
	public ServerResponse getUser(Long userId) {
		ServerResponse response = new ServerResponse();
		
		UserDTO dto = userDao.getUser(userId);
		response.setUser(new User(dto.getFirstName() + " " + dto.getLastName(), 
					new Long(dto.getAge())));
		
		return response;
	}

}
