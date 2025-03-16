package Clinica.Usuarios;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosCadastro(
	@NotNull
    String login,
    @NotNull
    @Size(min = 11, max = 11, message = "O CPF deve ter exatamente 11 dígitos.")
    String cpf,
    @NotNull
    String numeroUsuario,
    @NotNull
    String emailUsuario,
    @NotNull
    LocalDate dataNascimento,
    @NotNull
    String senha
    

)

{

	
}
   

