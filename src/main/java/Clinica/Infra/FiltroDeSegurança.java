package Clinica.Infra;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import Clinica.Repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FiltroDeSegurança extends OncePerRequestFilter {

	@Autowired
	private TokenService tokenjwt;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		

		var token = recuperarToken(request);
		
		if (token != null) {

		var verificar = tokenjwt.verificarToken(token);
		var usuario = usuarioRepository.findByemail(verificar);
		
		UsernamePasswordAuthenticationToken authenticated = new UsernamePasswordAuthenticationToken(usuario,null,usuario.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(authenticated);
		}


		filterChain.doFilter(request, response);
	}

	public String recuperarToken(HttpServletRequest request) {
		String recover = request.getHeader("Authorization");

		if (recover != null) {
			return recover.substring(7);
		}
         
		return null;
		
	}

	

}
