package Clinica.Infra;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import Clinica.Entities.Usuario;

@Service
public class TokenService {
	
	@Value("${api.security-keyToken}")
	private String chaveSecreta;
	
	public String criarToken(Usuario usuario) {
		try {
		    Algorithm algorithm = Algorithm.HMAC256(chaveSecreta);
		    return JWT.create()
		        .withIssuer("Clinica")
		        .withSubject(usuario.getEmail())
		        .withClaim("role", pesquisarRole(usuario))
		        .withExpiresAt(DataExpiracao())
		        .sign(algorithm);
		    
		} catch (JWTCreationException exception){
		   throw new RuntimeException("Erro ao gerar token", exception);
		}
	}	
	
	
	public String pesquisarRole(Usuario usuario) {
		try {
		if(usuario.getRole().getRole() != null) {
			return usuario.getRole().getRole();
		}
		else {
			return null;
		}
		
	}
		catch (Exception e) {
			return null;
		}
		
	}
	
	public String verificarToken(String token){
		try {
			Algorithm algorithm = Algorithm.HMAC256(chaveSecreta);
			return JWT.require(algorithm)
					.withIssuer("Clinica")
					.build()
					.verify(token)
					.getSubject();
					
		}
		catch (JWTVerificationException e) {
			throw new RuntimeException("Token invalido");
			
		}
		
	}	
	
	private Instant DataExpiracao() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
		
	}

}
