package br.com.ju.userapi.resources.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ju.userapi.domain.User;
import br.com.ju.userapi.resources.UserResource;
import br.com.ju.userapi.services.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/users")
public class UserResourceImplement implements UserResource{

	private final UserService service;
	
	@Override
	public ResponseEntity<User> findById(Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@Override
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

}
