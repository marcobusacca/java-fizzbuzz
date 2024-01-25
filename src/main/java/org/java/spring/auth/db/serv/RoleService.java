package org.java.spring.auth.db.serv;

import java.util.List;

import org.java.spring.auth.db.pojo.Role;
import org.java.spring.auth.db.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> findAll() {
		
		return roleRepository.findAll();
	}
	public Role findById(int id) {
		
		return roleRepository.findById(id).get();
	}
	public void save(Role role) {
		
		roleRepository.save(role);
	}
}