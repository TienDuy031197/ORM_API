package com.topica.restapi.service;

import java.util.List;

import com.topica.restapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserService extends JpaRepository<User, Long> {

	List<User> findUserByRole(Integer role);

	List<User> deleteUserById(Integer id);
}
