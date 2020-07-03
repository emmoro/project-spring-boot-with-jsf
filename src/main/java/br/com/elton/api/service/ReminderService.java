package br.com.elton.api.service;

import java.util.List;

import br.com.elton.api.entity.Reminder;

public interface ReminderService {
	
	/**
	 * Find Reminder
	 * @return List<Reminder>
	 */
	public abstract List<Reminder> findReminder();
	
	/**
	 * Save Reminder
	 * @param Reminder
	 */
	public abstract void saveReminder(Reminder reminder);

}
