package org.java.spring.db.serv;

import java.util.List;

import org.java.spring.db.repo.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumberService {

	@Autowired
	private NumberRepository numberRepository;
	
	public List<org.java.spring.db.pojo.Number> findAll() {
		
		return numberRepository.findAll();
	}
	public org.java.spring.db.pojo.Number findById(int id) {
		
		return numberRepository.findById(id).get();
	}
	public void save(org.java.spring.db.pojo.Number number) {
		
		numberRepository.save(number);
	}
	public void deleteAll() {
		
		numberRepository.deleteAll();
	}
}
