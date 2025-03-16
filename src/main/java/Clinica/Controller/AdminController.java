package Clinica.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Clinica.Service.AdminService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;

	
	@PostMapping("/role")
	@Transactional
	public ResponseEntity<?> criarRole(@RequestParam String nomeRole) {
		adminService.criarRole(nomeRole);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
