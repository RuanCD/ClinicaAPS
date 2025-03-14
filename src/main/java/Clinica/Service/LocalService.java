package Clinica.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Clinica.Entities.Local;
import Clinica.Local.CadastrarLocalDTO;
import Clinica.Local.DadosListagemCadastroDTO;
import Clinica.Local.DadosListagemLocalDTO;
import Clinica.Repository.LocalRepository;

@Service
public class LocalService {
	
	@Autowired
	LocalRepository localRepository;
	
	public DadosListagemCadastroDTO cadastrarLocal(CadastrarLocalDTO localDTO) {
	    Local local = new Local(localDTO);
	    DadosListagemCadastroDTO listagem = new DadosListagemCadastroDTO(local);
	    try {
	        if (localDTO.foto1() != null && !localDTO.foto1().isEmpty()) {
	            local.setFoto1(localDTO.foto1().getBytes());
	            String foto1 = Base64.getEncoder().encodeToString(local.getFoto1());
	            listagem.setFoto1(foto1);
	        }
	        if (localDTO.foto2() != null && !localDTO.foto2().isEmpty()) {
	            local.setFoto2(localDTO.foto2().getBytes());
	            String foto2 = Base64.getEncoder().encodeToString(local.getFoto1());
	            listagem.setFoto2(foto2);
	        }
	        if (localDTO.foto3() != null && !localDTO.foto3().isEmpty()) {
	            local.setFoto3(localDTO.foto3().getBytes());
	            String foto3 = Base64.getEncoder().encodeToString(local.getFoto1());
	            listagem.setFoto3(foto3);
	        }
	        localRepository.save(local);
	        
	        
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    

	    return listagem;
	    
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
