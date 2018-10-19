package com.pCarpet.services;

import com.pCarpet.converter.BadgeConverter;
import com.pCarpet.dao.BadgeRepository;
import com.pCarpet.dto.BadgeDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pCarpet.model.Badge;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

@Service
public class BadgeService {
	
	 private BadgeRepository badgeRepository;
	 	
	 @Autowired
	    public BadgeService(BadgeRepository br) {
	        this.badgeRepository = br;
	    }

	 	public BadgeRepository getBadgeRepository() {
	 		return this.badgeRepository;
	 	}
	 
	    public List<BadgeDTO> getAllBadges () {
	    	
	    	List<Badge> listBadges = this.badgeRepository.getAllBadges();
	    	
	    	List<BadgeDTO> listBDTO=new ArrayList<>();
	    	
	    	for(Badge b: listBadges) {
	    		listBDTO.add(BadgeConverter.convertToDTO(b));
	    	}
	    	
	        return listBDTO;
	    }
	    
	    public BadgeDTO getBadge (int id) {
	    	
	    	Badge b=this.badgeRepository.getBadge(id);
	    	
	    	return BadgeConverter.convertToDTO(b);
	    }
	    
	    public List<BadgeDTO> getAllBadgesN () {
	        
	        List<Badge> bList=this.badgeRepository.getAllBadgesN();
	    	
	        List<BadgeDTO> listBDTO=new ArrayList<>();
	        
	        for(Badge b: bList) {
	        	listBDTO.add(BadgeConverter.convertToDTO(b));
	        }
	        
	    	return listBDTO;
	    }

	    public boolean insertBadge (BadgeDTO badgeDTO) {
	    	
	    	Badge badge=BadgeConverter.converToEntity(badgeDTO);
	    	
	        return this.badgeRepository.insertBadge(badge);
	    }
	    public boolean deleteBadge (int idBadge) {
	    	return this.badgeRepository.DeleteBadge(idBadge);
	    }
	    
	    public boolean updateBadge(HttpServletRequest request) {
	    	return this.badgeRepository.UpdateBadge(request);
	    }
	}




