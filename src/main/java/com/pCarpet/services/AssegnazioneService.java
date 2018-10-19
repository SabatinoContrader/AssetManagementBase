package com.pCarpet.services;


import com.pCarpet.converter.AssegnazioneConverter;
import com.pCarpet.converter.BadgeConverter;
import com.pCarpet.dao.AssegnaRepository;
import com.pCarpet.dao.UserRepository;
import com.pCarpet.dto.AssegnazioneDTO;
import com.pCarpet.dto.BadgeDTO;
import com.pCarpet.dto.UserDTO;
import com.pCarpet.model.Assegnazione;
import com.pCarpet.model.Badge;
import com.pCarpet.model.User;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssegnazioneService {

	private UserRepository userRepository;
    //private UserAssetDAO userAssetDAO;
    private AssegnaRepository assegnaRepository;
    
    private UserService userService;
    
    private BadgeService badgeService;
    
    @Autowired
    public AssegnazioneService(AssegnaRepository ar, UserService us, BadgeService bs) {
        this.assegnaRepository = ar;
        this.userService = us;
        this.badgeService = bs;
    }

    
    public List<AssegnazioneDTO> getAllAssegnazioni () {
    	
        List<Assegnazione> lAss= this.assegnaRepository.getAllAssegnazioni();
        
        List<AssegnazioneDTO> lDTO=new ArrayList<>();
        
        for(Assegnazione a: lAss) {
        	lDTO.add(AssegnazioneConverter.convertToDTO(a));
        	
        }
        
        return lDTO;
        
    }
    
    
    public List<UserDTO> getAllUsers(){
    	List<UserDTO> lUser = this.userService.getAllUsers();
    	return lUser;
    }
    
    public List<BadgeDTO> getAllBadgesN(){
    	List<BadgeDTO> lBadge = this.badgeService.getAllBadgesN();
    	return lBadge;
    }
    
    
    
//    public List<User> getAllClienti () {
//        return this.userDAO.getAllClienti();
//    }
//    
//    public List<User> getAllClientiAss(){
//    	return this.userDAO.getAllClientiAss();
//    }
    
    public boolean assegnaBadge(AssegnazioneDTO assegnazioneDTO)
    {
    	Assegnazione assegnazione=AssegnazioneConverter.converToEntity(assegnazioneDTO);
    	return this.assegnaRepository.assegnaBadge(assegnazione);
    }
//    public boolean insertUser (User user) {
//        return this.userDAO.insertUser(user);
//    }
//    
    public boolean deleteAssegnazione(int iduser,int idbadge) {
    	return this.assegnaRepository.deleteAssegnazione(iduser, idbadge);
    }
//    
//    public List<User> getAllUsersN(){
//    	return this.userAssetDAO.getAllUsersN();
//    }
//    
//    public boolean updateUser(Request request) {
//    	return this.userDAO.udpateUser(request);
//    }
}


