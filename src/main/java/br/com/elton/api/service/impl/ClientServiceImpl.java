package br.com.elton.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elton.api.entity.Client;
import br.com.elton.api.repository.ClientRepository;
import br.com.elton.api.service.ClientService;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public void saveClient(Client client) {
		clientRepository.saveAndFlush(client);		
	}

	@Override
	public List<Client> findClient(Client clientFilter) {
		return clientRepository.findAll();
	}
	
	@Override
	public Integer countActiveClient() {
		return (int) clientRepository.count();
	}

}
