package br.com.ju.userapi.services;

import java.util.List;

import br.com.ju.userapi.domain.User;

public interface UserService {
	
	User findById(Long id);
	List<User> findAll();

}
