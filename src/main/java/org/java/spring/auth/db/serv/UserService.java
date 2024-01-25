package org.java.spring.auth.db.serv;

import java.util.List;

import org.java.spring.auth.db.pojo.User;
import org.java.spring.auth.db.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		
		return userRepository.findAll();
	}
	public User findById(int id) {
		
		return userRepository.findById(id).get();
	}
	public void save(User user) {
		
		userRepository.save(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		
		if (user == null) throw new UsernameNotFoundException("Username not found");
		
		return user;
	}
}