package Clinica.Usuarios;

import Clinica.Entities.Usuario;

public record AlterarDadosDTO(
		String login,
		String telefone
)

{

	
	public AlterarDadosDTO(Usuario usuario) {
		this(usuario.getLogin(), usuario.getTelefone());
	}
	
}
