package br.com.elton.api.web.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.elton.api.entity.Client;
import br.com.elton.api.enun.Status;
import br.com.elton.api.service.ClientService;

@Component("clientBean")
@Scope("request")
public class ClientBean {
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	/** Variaveis   */
	
	private Client client = new Client();
	
	private Client clientFilter = new Client();
	
	private List<Client> listClient=  new ArrayList<Client>();
	
	private Client clientSelected;
	
	@Autowired
	private ClientService clientService;
	
	private String formattedDate;
	
	/** Metodos   */
	
	public void init() {
		
		listClient = new ArrayList<Client>();

	}
	
	public void clean() {
		client = new Client();
		formattedDate = null;
	}
	
	public String back() {
		return "searchClient.xhtml";
	}
	
	public void saveClient() {
		
		if (validateClient()) {
			
			client.setBirthDate(LocalDate.parse(formattedDate,formatter));
			client.setDataCreation(LocalDateTime.now());
			client.setStatus(Status.ACTIVE.getId());
			clientService.saveClient(client);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro", "Salvo com Sucesso."));
	
			client = new Client();
			formattedDate = null;
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Cadastro", "Preencha os campos obrigat�rios *."));
		}
	}
	
	public void findClient() {
		listClient = clientService.findClient(clientFilter);
	}
	
	public String view() {

		if (clientSelected != null) {
			client = clientSelected;
		}

		return "viewClient.xhtml";
	}
	
	public String change() {

		if (clientSelected != null) {
			client = clientSelected;
		}

		return "clientRegister.xhtml";
	}
	
	public void viewCancel(ActionEvent event) {
		
		if (clientSelected != null) {
			client = clientSelected;
		}

	}
	
	public String viewCancel() {
		
		if (clientSelected != null) {
			client = clientSelected;
		}

		return "cancelClient.xhtml";
		
	}
	
	public void cancel() {
		
		if (validateCancel()) {
		
		client.setStatus(0);
		clientService.saveClient(client);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancelamento",
				"Cadastro do Aluno foi Cancelado com Sucesso."));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Cadastro", "Preencha os campos obrigat�rios *."));
		}
		
	}
	
	private boolean validateClient() {
		
		boolean validate = true;
		
		if (client.getName().isEmpty()) {
			validate = false;
		}
		
		return validate;
	}
	
	private boolean validateCancel() {
		
		boolean validate = true;
		
		if (client.getReasonCancellation().isEmpty()) {
			validate = false;
		}
		
		return validate;
	}

	/** Getters e Setters   */
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getListClient() {
		return listClient;
	}

	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}

	public Client getClientFilter() {
		return clientFilter;
	}

	public void setClientFilter(Client clientFilter) {
		this.clientFilter = clientFilter;
	}

	public String getFormattedDate() {
		return formattedDate;
	}

	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
	}
	
}
