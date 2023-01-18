package br.com.ju.userapi.services.implement;

import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.ju.userapi.domain.User;
import br.com.ju.userapi.repositories.UserRepository;
import br.com.ju.userapi.services.UserService;
import br.com.ju.userapi.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImplement implements UserService{
	
	private final Environment env;
	
	private final UserRepository repository;

	@Override
	public User findById(Long id) {
		log.info("USER_SERVICE ::: Get request on " + env.getProperty("local.server.port") + "port");
		return repository.findById(id).orElseThrow(() -> 
		new ObjectNotFoundException("Object not found!!"));
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

}
