package io.github.priscillacordeiro.usermanagerchallenge.service;

import io.github.priscillacordeiro.usermanagerchallenge.model.Phone;
import io.github.priscillacordeiro.usermanagerchallenge.repository.PhoneRepository;

public class PhoneService {

	private PhoneRepository phoneRepository = new PhoneRepository();
	
	public Phone create(Phone phone) {
		return phoneRepository.create(phone);
	}
	
	public Phone update(Phone phone) {
		return phoneRepository.update(phone);
	}
	
	public Phone getById(Long id) {
		return phoneRepository.getById(id);
	}
	
	public void delete(Long id) {
		phoneRepository.delete(id);
	}
}
