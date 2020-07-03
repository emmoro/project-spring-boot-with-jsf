package br.com.elton.api.web.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.elton.api.entity.Reminder;
import br.com.elton.api.service.ReminderService;

@Component("reminderBean")
@Scope("request")
public class ReminderBean {
	
	private Reminder reminder = new Reminder();
	
	private Reminder reminderSelected;
	
	@Autowired
	private ReminderService reminderService;
	
	/** Metodos   */
	
	public void init() {

	}
	
	public void clean() {
		reminder = new Reminder();
	}
	
	public String back() {
		return "home.xhtml";
	}
	
	public void saveReminder() {
		
		if (validateReminder()) {
		
			reminderService.saveReminder(reminder);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
					"Cadastro", "Salvo com Sucesso."));
	
			reminder = new Reminder();
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, 
					"Cadastro", "Preencha os campos obrigatórios *."));
		}
	}
	
	public String view() {
		
		return null;
	}
	
	public String change() {
			
			return null;
		}
	
	public String viewCancel() {
		
		return null;
	}
	
	private boolean validateReminder() {
		
		boolean validate = true;
		
		if (reminder.getTitle().isEmpty()) {
			validate = false;
		}
		
//		if (lembrete.getDescricao().isEmpty()) {
//			validate = false;
//		}
		
		return validate;
	}

	/** Getters e Setters   */
	public Reminder getReminder() {
		return reminder;
	}

	public void setReminder(Reminder reminder) {
		this.reminder = reminder;
	}

	public Reminder getReminderSelected() {
		return reminderSelected;
	}

	public void setReminderSelected(Reminder reminderSelected) {
		this.reminderSelected = reminderSelected;
	}

}
