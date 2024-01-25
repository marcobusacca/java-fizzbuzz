package org.java.spring;

import java.util.List;

import org.java.spring.db.pojo.Num;
import org.java.spring.db.serv.NumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaFizzbuzzApplication implements CommandLineRunner {
	
	static final int NUM_COUNT = 100;
	
	@Autowired
	private NumService numService;

	public static void main(String[] args) {
		SpringApplication.run(JavaFizzbuzzApplication.class, args);
	}

	public void run(String... args) throws Exception {
		
		for (int i = 1; i <= NUM_COUNT; i++) {
			
			Num n = new Num();

			numService.save(n);
		}
		
		List<Num> nums = numService.findAll();
		
		for (Num num : nums) {
			
			int id = num.getId();
			
			if (id % 3 == 0 && id % 5 == 0) {
				
				num.setFizzbuzz(true);
				
			} else if (id % 3 == 0) {
				
				num.setFizz(true);
				
			} else if (id % 5 == 0) {
				
				num.setBuzz(true);
			}
			
			numService.save(num);
		}
	}
}
