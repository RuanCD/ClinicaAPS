package Clinica.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Clinica.Entities.Role;
import Clinica.Entities.Usuario;
import Clinica.Infra.TokenService;
import Clinica.Repository.RoleRepository;
import Clinica.Repository.UsuarioRepository;
import Clinica.Usuarios.DadosAutenticacaoDTO;
import Clinica.Usuarios.TokenDTO;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/auth")
public class UsuariosAutenticacaoController {
	
	@Autowired
	UsuarioRepository repository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokenService tokenservice;
	

	@PostMapping("/login")
	public ResponseEntity<TokenDTO> efetuarLogin(@RequestBody @Valid DadosAutenticacaoDTO dados){
		var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
		var autenticacao = manager.authenticate(token);
		String tokenDTO = tokenservice.criarToken((Usuario) autenticacao.getPrincipal());
		return ResponseEntity.ok(new TokenDTO(tokenDTO));
		
	}
	


}
	
	
	



