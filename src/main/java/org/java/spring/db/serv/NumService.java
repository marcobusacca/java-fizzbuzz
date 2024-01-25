package org.java.spring.db.serv;

import java.util.List;

import org.java.spring.db.pojo.Num;
import org.java.spring.db.repo.NumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumService {

	@Autowired
	private NumRepository numRepository;
	
	public List<Num> findAll(){
		return numRepository.findAll();
	}
	public Num findById(int id) {
		return numRepository.findById(id).get();
	}
	public void save(Num num) {
		numRepository.save(num);
	}
	public void delete(Num num) {
		
		numRepository.delete(num);
	}
}
