package Clinica.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Clinica.Entities.Local;
import Clinica.Local.CadastrarLocalDTO;
import Clinica.Local.DadosListagemLocalDTO;
import Clinica.Repository.LocalRepository;

@Service
public class LocalService {
	
	@Autowired
	LocalRepository localRepository;
	
	public DadosListagemLocalDTO cadastrarLocal(CadastrarLocalDTO localDTO) {
	    Local local = new Local(localDTO);
	    try {
	        if (localDTO.foto1() != null && !localDTO.foto1().isEmpty()) {
	            local.setFoto1(localDTO.foto1().getBytes());
	        }
	        if (localDTO.foto2() != null && !localDTO.foto2().isEmpty()) {
	            local.setFoto2(localDTO.foto2().getBytes());
	        }
	        if (localDTO.foto3() != null && !localDTO.foto3().isEmpty()) {
	            local.setFoto3(localDTO.foto3().getBytes());
	        }
	        localRepository.save(local);
	        
	       
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    String foto1 = Base64.getEncoder().encodeToString(local.getFoto1());
	    String foto2 = Base64.getEncoder().encodeToString(local.getFoto1());
	    String foto3 = Base64.getEncoder().encodeToString(local.getFoto1());
	    
	    
	    return new DadosListagemLocalDTO(local, foto1, foto2, foto3);
	    
	}
	
	public List<DadosListagemLocalDTO> listarTodosLocais(){
		List<Local> locais = localRepository.findAll();
		
		List<DadosListagemLocalDTO> locaisClinica = locais.stream()
			    .map(local -> new DadosListagemLocalDTO(
			        local, 
			        Base64.getEncoder().encodeToString(local.getFoto1()), 
			        Base64.getEncoder().encodeToString(local.getFoto2()), 
			        Base64.getEncoder().encodeToString(local.getFoto3())
			    ))
			    .collect(Collectors.toList());
		
		return locaisClinica;

	}
	
	


}
