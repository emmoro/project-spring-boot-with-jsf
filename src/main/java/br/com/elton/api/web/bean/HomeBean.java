package br.com.elton.api.web.bean;

import java.io.IOException;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

import br.com.elton.api.entity.Reminder;
import br.com.elton.api.service.ReminderService;

@Component("homeBean")
@Scope("request")
public class HomeBean {

	private List<Reminder> listReminder;

	private Reminder reminder = new Reminder();

	@Autowired
	private ReminderService reminderService;
	
	private String atualiza = null;
	
	@SuppressWarnings("rawtypes")
	private DataModel reminders;
	
	public void initPage() throws IOException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) auth.getPrincipal();
		String usuario = user.getUsername();
		if (usuario.equals("teste")) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("./pages/home/home.xhtml");
		} else {
			FacesContext.getCurrentInstance().getExternalContext().redirect("../pages/client/clientRegister.xhtml");
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initReminder(ComponentSystemEvent event) {
		listReminder = reminderService.findReminder();
		reminders = new ListDataModel(listReminder);
	}
	
	public String viewReminder() {
		reminder = (Reminder) reminders.getRowData();
		return "viewReminder.xhtml";
	}
	
	public void logout() throws IOException {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, null, auth);
		}

	    FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
	}

	public String getAtualiza() {
		return atualiza;
	}

	public void setAtualiza(String atualiza) {
		this.atualiza = atualiza;
	}

	@SuppressWarnings("rawtypes")
	public DataModel getReminders() {
		return reminders;
	}
	@SuppressWarnings("rawtypes")
	public void setReminders(DataModel reminders) {
		this.reminders = reminders;
	}
	public Reminder getReminder() {
		return reminder;
	}
	public void setReminder(Reminder reminder) {
		this.reminder = reminder;
	}

	public List<Reminder> getListReminder() {
		return listReminder;
	}

	public void setListReminder(List<Reminder> listReminder) {
		this.listReminder = listReminder;
	}

}
