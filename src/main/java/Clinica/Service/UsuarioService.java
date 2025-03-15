package Clinica.Service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Clinica.Agendamento.DadosListagemAgendamento;
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
import Clinica.Usuarios.DadosCadastro;

@Service
public class UsuarioService {
	
	@Autowired
	AgendamentoRepository agendamentoRepository;
	
	@Autowired
	LocalRepository localRepository;
	
	@Autowired 
	private PasswordEncoder password;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	@Autowired
	EndereçoRepository endereçoRepository;
	
	public void cadastrarUsuario(DadosCadastro dados) {
		String codificado = password.encode(dados.senha());
        Usuario usuario = new Usuario(dados);
        usuario.setSenha(codificado);
        usuarioRepository.save(usuario);
	}
	

	public EnderecoDTO cadastrarEndereço(EnderecoDTO enderecoUser) {
		EnderecoUsuario endereco = new EnderecoUsuario(enderecoUser);
		endereco.setUsuario(getUsuario());
		endereçoRepository.save(endereco);
		return new EnderecoDTO(endereco);
	}
	
	
	public RealizarAgendamentoDTO agendamentoCliente(RealizarAgendamentoDTO agendamentoCliente) {
		Usuario usuario = getUsuario();
		Agendamento agendamento = new Agendamento(agendamentoCliente);
		Local local = localRepository.findByEnderecoLocal(agendamentoCliente.enderecoLocal());
		agendamento.setLocal(local);
		agendamento.setUsuario(usuario);
		agendamentoRepository.save(agendamento);
		return new RealizarAgendamentoDTO(agendamento, local);
	}
	
	
	
	public List<DadosListagemAgendamento> listarAgendamentos(){
		Usuario usuario = getUsuario();
		List<Agendamento> agendamentos = usuario.getAgendamentos();
		List<Agendamento> agendamentoFiltro = agendamentos.stream().filter(ag -> Boolean.TRUE.equals(ag.getStatus())).collect(Collectors.toList());;
		List<DadosListagemAgendamento> agendamentoCliente = agendamentoFiltro.stream().map(agendar -> new DadosListagemAgendamento(agendar.getDataAgendamento(), agendar.getHoraAgendamento(), agendar.getSituacaoAgendamento(), agendar.getMotivoAgendamento()) ).collect(Collectors.toList());
		return agendamentoCliente;
	}
	
	
	
	public void cancelarAgendamento(Long id) {
	 Agendamento agendamento = agendamentoRepository.getReferenceById(id);
	 Boolean status = agendamento.getStatus();
	 if(status == true) {
		 agendamento.setStatus(false);
	 }
	}
	

	
	public Usuario getUsuario() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails userDetails) {
            String email = userDetails.getUsername(); 
            Usuario usuario = (Usuario) usuarioRepository.findByemail(email);
                    
            return usuario;
        }
        return null;
    }
	
	public Long getUsuarioID() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails userDetails) {
            String login = userDetails.getUsername(); 
            Usuario usuario = (Usuario) usuarioRepository.findByemail(login);
                    
            return usuario.getId();
        }
        return null;
    }

}
