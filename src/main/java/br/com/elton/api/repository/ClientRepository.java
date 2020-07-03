package br.com.elton.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.elton.api.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
