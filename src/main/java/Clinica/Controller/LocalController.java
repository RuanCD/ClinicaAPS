package Clinica.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Clinica.Local.CadastrarLocalDTO;
import Clinica.Local.DadosListagemCadastroDTO;
import Clinica.Local.DadosListagemLocalDTO;
import Clinica.Service.LocalService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/local")
public class LocalController {
	
	@Autowired
	LocalService localService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<DadosListagemCadastroDTO> cadastrarLocal(@ModelAttribute CadastrarLocalDTO cadastrarLocal) {
		System.out.println(cadastrarLocal.enderecoLocal());
		DadosListagemCadastroDTO dados = localService.cadastrarLocal(cadastrarLocal);
		return new ResponseEntity<>(dados, HttpStatus.CREATED);
	}
	
	
	@GetMapping
	@Transactional
	public ResponseEntity<List<DadosListagemLocalDTO>> listarLocais() {
		return ResponseEntity.ok(localService.listarTodosLocais());
	}

}
