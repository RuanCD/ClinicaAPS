package Clinica.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Clinica.Entities.Local;
import Clinica.Repository.LocalRepository;
import Local.CadastrarLocalDTO;

@Service
public class LocalService {
	
	@Autowired
	LocalRepository localRepository;
	
	public CadastrarLocalDTO cadastrarLocal(CadastrarLocalDTO localDTO) {
		Local local = new Local(localDTO);
		try {
			local.setFoto1(localDTO.foto1().getBytes());
			local.setFoto2(localDTO.foto2().getBytes());
			local.setFoto3(localDTO.foto3().getBytes());
			localRepository.save(local);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new CadastrarLocalDTO(local);
		
	}

}
