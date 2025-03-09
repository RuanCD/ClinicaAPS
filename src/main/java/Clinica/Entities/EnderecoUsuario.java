package Clinica.Entities;

import Clinica.Endereco.EnderecoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="endereço")
@Table(name="endereço")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class EnderecoUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cep;
	private String logradouro;
	private String bairro;
	private String complemento;
	private String numero;
	private String uf;
	
	
	public EnderecoUsuario(EnderecoDTO endereco) {
	    this.cep = endereco.cep();  
	    this.logradouro = endereco.logradouro(); 
	    this.bairro = endereco.bairro();
	    this.complemento = endereco.complemento();
	    this.numero = endereco.numero();
	    this.uf = endereco.uf();
}
	
	@OneToOne
	@JoinColumn(name="cliente_id")
	private Usuario usuario;

}
