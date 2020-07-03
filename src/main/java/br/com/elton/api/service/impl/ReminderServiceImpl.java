package br.com.elton.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elton.api.entity.Reminder;
import br.com.elton.api.repository.ReminderRepository;
import br.com.elton.api.service.ReminderService;

@Service("reminderService")
public class ReminderServiceImpl implements ReminderService {

	@Autowired
	private ReminderRepository reminderRepository;
	
	@Override
	public List<Reminder> findReminder() {
		return reminderRepository.findAll();
	}

	@Override
	public void saveReminder(Reminder reminder) {
		reminderRepository.saveAndFlush(reminder);
	}

}
