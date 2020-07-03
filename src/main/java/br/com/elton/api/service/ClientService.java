package br.com.elton.api.service;

import java.util.List;

import br.com.elton.api.entity.Client;

public interface ClientService {

	/**
	 * Save client
	 * @param client
	 */
	public abstract void saveClient(Client client);
	
	/**
	 * Find all client
	 * @return List<Client>
	 */
	public abstract List<Client> findClient(Client clientFilter);
	
	/**
	 * Count all client
	 * @return Integer
	 */
	public abstract Integer countActiveClient();
	
}
