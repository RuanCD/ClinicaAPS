package Clinica.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Clinica.Agendamento.RealizarAgendamentoDTO;
import Clinica.Endereco.EnderecoDTO;
import Clinica.Entities.Usuario;
import Clinica.Repository.UsuarioRepository;
import Clinica.Service.UsuarioService;
import Clinica.Usuarios.DadosCadastro;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/user")

public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired 
	private PasswordEncoder password;
	
	
	
	@PostMapping("/cadastro")
	@Transactional
	public ResponseEntity<String> cadastroUsuario(@RequestBody DadosCadastro dados) {
	    String codificado = password.encode(dados.senha());
	        Usuario usuario = new Usuario(dados);
	        usuario.setSenha(codificado);
	        usuarioRepository.save(usuario);
	        return ResponseEntity.ok().build();
}
	
	@PostMapping("/endereco")
	@Transactional
	public ResponseEntity<EnderecoDTO> cadastrarEndereco(@RequestBody EnderecoDTO endereco) {
		EnderecoDTO enderecoCliente =  usuarioService.cadastrarEndereço(endereco);
		
		return new ResponseEntity<>(enderecoCliente, HttpStatus.CREATED);
	}
	
	@PostMapping("/agendamento")
	@Transactional
	public ResponseEntity<RealizarAgendamentoDTO> cadastroAgendamento(@RequestBody RealizarAgendamentoDTO agendamentoCliente){
		RealizarAgendamentoDTO agendamentoDTO = usuarioService.agendamentoCliente(agendamentoCliente);
		return new ResponseEntity<>(agendamentoDTO, HttpStatus.CREATED);
	}
	
	
	

	
	
	

		
	
}
