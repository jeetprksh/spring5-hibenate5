package com.spring5.app.dao;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring5.app.dto.UserDTO;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public UserDTO getUser(Long userId) {
		TypedQuery<UserDTO> typedQuery = sessionFactory.getCurrentSession().createQuery("from UserDTO where id=" + userId.toString());
		return typedQuery.getSingleResult();
	}

}
