package Clinica.Entities;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Clinica.Usuarios.DadosCadastro;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "usuario")
@Table(name = "usuarios")
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String login;
	@JsonIgnore
	private String senha;
	private String email;
	private String cpf;
	private String telefone;
	private LocalDate dataNascimento;
	@CreationTimestamp
	private LocalDate dataCadastro;
	

	public Usuario(DadosCadastro cadastro) {
		this.login = cadastro.login();
		this.senha = cadastro.senha();
		this.email = cadastro.emailUsuario();
		this.cpf = cadastro.cpf();
		this.telefone = cadastro.numeroUsuario();
		this.dataNascimento = cadastro.dataNascimento();
	}
	
	@OneToOne
	private EnderecoUsuario endereço;
	
	@OneToMany(mappedBy = "usuario")
	private List<Agendamento> agendamentos;
	
	@ManyToOne
	private Role role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    return List.of(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public void setSenha(String codificado) {
		this.senha = codificado;
	}
	
	
}
