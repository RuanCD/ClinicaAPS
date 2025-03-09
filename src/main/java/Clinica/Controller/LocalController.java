package Clinica.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Clinica.Service.LocalService;
import Local.CadastrarLocalDTO;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/local")
public class LocalController {
	
	@Autowired
	LocalService localService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<CadastrarLocalDTO> cadastrarLocal(@ModelAttribute CadastrarLocalDTO cadastrarLocal) {
		CadastrarLocalDTO local =  localService.cadastrarLocal(cadastrarLocal);
		return new ResponseEntity<>(local, HttpStatus.CREATED);
	}

}
