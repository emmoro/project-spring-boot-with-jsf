package br.com.elton.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.elton.api.entity.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

	public UserRole findByRole(String role);
	
}
