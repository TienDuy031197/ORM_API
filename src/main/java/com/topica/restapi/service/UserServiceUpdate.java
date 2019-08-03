package com.topica.restapi.service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topica.restapi.model.Classroom;
import com.topica.restapi.model.User;

@Repository
public class UserServiceUpdate {
	@Autowired
	private EntityManager entityManager;

	@Transactional
	public void updateUser(Integer id, String name) {
		Query query = entityManager.createQuery("UPDATE User as c SET c.name = :name where c.id = :id");
		query.setParameter("name", name);
		query.setParameter("id", id);
		query.executeUpdate();
	}

	public User getUserId(Integer id) {
		Query query = entityManager.createQuery("From User as u where u.id = :id");
		query.setParameter("id", id);
		return (User) query.getResultList().get(0);
	}
}
