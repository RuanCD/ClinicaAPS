package Clinica.Endereco;

import Clinica.Entities.EnderecoUsuario;

public record EnderecoDTO(
		Long id,
	    String cep,
	    String logradouro,
	    String bairro,
	    String complemento,
	    String numero,
	    String uf
	) 


{ 
	
 public EnderecoDTO(EnderecoUsuario endereco) {
	 this(endereco.getId(), endereco.getCep(), endereco.getLogradouro(), endereco.getBairro(), endereco.getComplemento(), endereco.getNumero(), endereco.getUf());
 }

}
