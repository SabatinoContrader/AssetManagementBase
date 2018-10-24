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
import java.util.LinkedList;
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
    	
        List<Assegnazione> lAss= (List<Assegnazione>)this.assegnaRepository.findAll();
        
        List<Assegnazione> la=new LinkedList<Assegnazione>();
        for(Assegnazione a:lAss) {
        	if(a.getFlag()==1) {
        		la.add(a);
        	}
        }
        
        List<AssegnazioneDTO> lDTO=new ArrayList<>();
        
        for(Assegnazione a: la) {
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
    
    public void assegnaBadge(AssegnazioneDTO assegnazioneDTO)
    {	
    	Assegnazione assegnazione=AssegnazioneConverter.converToEntity(assegnazioneDTO);
    	//System.out.println("dim"+assegnazione.getBadge().size());
    	this.assegnaRepository.save(assegnazione);
    	
//    	for(Badge a:assegnazione.getBadge()) {
//    		System.out.println("aaaa"+a.getTipologia());
//    	}
    	
    }
//    public boolean insertUser (User user) {
//        return this.userDAO.insertUser(user);
//    }
//    
    public void deleteAssegnazione(int iduser,int idbadge) {
    	List<Assegnazione> listAss =(List<Assegnazione>) this.assegnaRepository.findAll();
    	Assegnazione b=new Assegnazione();
    	for(Assegnazione a:listAss) {
    		if(a.getIdbadge()==idbadge)
    		{
    			
    			b=a;
    			b.setFlag(0l);
    		}
    	}
    	
    	this.assegnaRepository.save(b);
    	
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


