package br.com.elton.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.elton.api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	 public User findByEmail(String email);
	 
	 public User findByUsername(String username);

}
