package br.com.ju.userapi.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ju.userapi.domain.User;
import br.com.ju.userapi.repositories.UserRepository;
import br.com.ju.userapi.services.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImplement implements UserService{
	
	private final UserRepository repository;

	@Override
	public User findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

}
