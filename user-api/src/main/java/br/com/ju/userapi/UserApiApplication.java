package br.com.ju.userapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import br.com.ju.userapi.domain.User;
import br.com.ju.userapi.repositories.UserRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class UserApiApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.saveAll(List.of(
				new User(null, "Sarah", "sarah.gmail.com", "123", 30.0),
				new User(null, "Pedro", "pedro.gmail.com", "123", 20.0)
		));
	}

}
