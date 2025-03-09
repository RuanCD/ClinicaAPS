package Clinica.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import Clinica.Agendamento.RealizarAgendamentoDTO;
import Clinica.Endereco.EnderecoDTO;
import Clinica.Entities.Agendamento;
import Clinica.Entities.EnderecoUsuario;
import Clinica.Entities.Local;
import Clinica.Entities.Usuario;
import Clinica.Repository.AgendamentoRepository;
import Clinica.Repository.EndereçoRepository;
import Clinica.Repository.LocalRepository;
import Clinica.Repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	AgendamentoRepository agendamentoRepository;
	
	@Autowired
	LocalRepository localRepository;
	
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	@Autowired
	EndereçoRepository endereçoRepository;
	

	public EnderecoDTO cadastrarEndereço(EnderecoDTO enderecoUser) {
		EnderecoUsuario endereco = new EnderecoUsuario(enderecoUser);
		endereco.setUsuario(getUsuario());
		endereçoRepository.save(endereco);
		return new EnderecoDTO(endereco);
	}
	
	
	public RealizarAgendamentoDTO agendamentoCliente(RealizarAgendamentoDTO agendamentoCliente) {
		Agendamento agendamento = new Agendamento(agendamentoCliente);
		Local local = localRepository.findByEnderecoLocal(agendamentoCliente.enderecoLocal());
		agendamento.setLocal(local);
		agendamentoRepository.save(agendamento);
		return new RealizarAgendamentoDTO(agendamento, local);
		
	}
	

	
	public Usuario getUsuario() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails userDetails) {
            String login = userDetails.getUsername(); 
            Usuario usuario = (Usuario) usuarioRepository.findByLogin(login);
                    
            return usuario;
        }
        return null;
    }
	
	public Long getUsuarioID() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails userDetails) {
            String login = userDetails.getUsername(); 
            Usuario usuario = (Usuario) usuarioRepository.findByLogin(login);
                    
            return usuario.getId();
        }
        return null;
    }

}
