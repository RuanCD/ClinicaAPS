package Clinica.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Clinica.Entities.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {
	
}
