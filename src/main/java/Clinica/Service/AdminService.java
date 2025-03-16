package Clinica.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Clinica.Entities.Role;
import Clinica.Repository.RoleRepository;

@Service
public class AdminService {
	
	@Autowired
	RoleRepository roleRepository;

	
	
	public void criarRole(String nomeRole) {
		Role role = new Role();
		role.setRole(nomeRole);
		roleRepository.save(role);
	}
}
