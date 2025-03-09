package Clinica.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Clinica.Entities.EnderecoUsuario;

@Repository
public interface EndereçoRepository extends JpaRepository<EnderecoUsuario,Long> {

}
