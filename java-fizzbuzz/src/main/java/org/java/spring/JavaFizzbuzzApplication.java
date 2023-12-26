package org.java.spring;

import org.java.spring.auth.conf.AuthConf;
import org.java.spring.auth.db.pojo.Role;
import org.java.spring.auth.db.pojo.User;
import org.java.spring.auth.db.serv.RoleService;
import org.java.spring.auth.db.serv.UserService;
import org.java.spring.db.pojo.Number;
import org.java.spring.db.serv.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaFizzbuzzApplication implements CommandLineRunner {

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private NumberService numberService;
	private static final int MAX_LENGTH = 100;
	
	public static void main(String[] args) {
		SpringApplication.run(JavaFizzbuzzApplication.class, args);
	}

	public void run(String... args) throws Exception {
		
		Role r1 = new Role("ADMIN");
		roleService.save(r1);
		
		String pws1 = AuthConf.passwordEncoder().encode("password-1");
		User u1 = new User("utente-1", pws1, r1);
		userService.save(u1);
		
		for (int i = 1; i <= MAX_LENGTH; i++) {
			
			org.java.spring.db.pojo.Number n = new Number();
			
			if(i % 3 == 0 && i % 5 == 0) {
				
				n.setFizzbuzz(true);
				
			} else if (i % 3 == 0) {
				
				n.setFizz(true);
				
			} else if (i % 5 == 0) {
				
				n.setBuzz(true);
			}
			
			numberService.save(n);
		}
	}
}
