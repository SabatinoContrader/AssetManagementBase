package com.pCarpet.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pCarpet.converter.MovimentoConverter;
import com.pCarpet.converter.PrenotazioneConverter;
import com.pCarpet.dao.PrenotazioneRepository;
import com.pCarpet.dao.UserRepository;
import com.pCarpet.dto.AssetDTO;
import com.pCarpet.dto.MovimentoDTO;
import com.pCarpet.dto.PrenotazioneDTO;
import com.pCarpet.dto.UserDTO;
import com.pCarpet.model.Movimento;
import com.pCarpet.model.Prenotazione;
import com.pCarpet.model.User;

@Service
public class PrenotazioneService {

	private PrenotazioneRepository prenotazioneRepository;
	private UserService userService;
	private AssetService assetService;
	
	@Autowired
	public PrenotazioneService(PrenotazioneRepository prenotazioneRepository, UserService userService, AssetService assetService) {
		this.prenotazioneRepository = prenotazioneRepository;
		this.userService = userService;
		this.assetService = assetService;
	}

  
	
    public List<PrenotazioneDTO> getAllPrenotazioni () {
    	
        List<Prenotazione> listP = this.prenotazioneRepository.getAllPrenotazioni();
        
        List<PrenotazioneDTO> listDTO=new ArrayList<>();
        
        for(Prenotazione p: listP) {
        	listDTO.add(PrenotazioneConverter.covertToDTO(p));
        }
        
        return listDTO;
        
    }
    
    
    public List<UserDTO> getAllUsers(){
    	List<UserDTO> listU = this.userService.getAllUsers();
    	return listU;
    }
    
    public List<AssetDTO> getAllAssets(){
    	List<AssetDTO> listA = this.assetService.getAllAssets();
    	return listA;
    }
    
    
    public PrenotazioneDTO getPrenotazione (int iduser, int idasset, String orainizio) {
    	
        Prenotazione p = this.prenotazioneRepository.getPrenotazione(iduser, idasset, orainizio);
        
        return PrenotazioneConverter.covertToDTO(p);
        
    }
    

    public boolean insertPrenotazione(PrenotazioneDTO pDTO) {
    	Prenotazione p = PrenotazioneConverter.converToEntity(pDTO);
        return this.prenotazioneRepository.insertPrenotazione(p);
    }
    
    public boolean deleteUser(int iduser, int idasset, String orainizio) {
    	return this.prenotazioneRepository.deletePrenotazione(iduser, idasset, orainizio);
    }
   
    
    public boolean updatePrenotazione(HttpServletRequest request) {
    	return this.prenotazioneRepository.updatePrenotazione(request);
    }
    
    public List<MovimentoDTO> getAllUtilizzo(){
    	
    	List<Movimento> mList = this.prenotazioneRepository.getAllUtilizzo();
    	
    	List<MovimentoDTO> mDTOList = new ArrayList<>();
    	
    	for(Movimento m: mList) {
    		mDTOList.add(MovimentoConverter.convertToDTO(m));
    	}
    	
    	return mDTOList;
    }
	
}
