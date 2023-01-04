package br.com.ju.userapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ju.userapi.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
