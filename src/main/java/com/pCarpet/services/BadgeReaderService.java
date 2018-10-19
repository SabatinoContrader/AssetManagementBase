package com.pCarpet.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pCarpet.converter.BadgeReaderConverter;
import com.pCarpet.dao.BadgeReaderRepository;
import com.pCarpet.dto.BadgeReaderDTO;
import com.pCarpet.model.BadgeReader;
@Service
public class BadgeReaderService {

	private BadgeReaderRepository badgeReaderRepository;
	
	@Autowired
    public BadgeReaderService() {
        this.badgeReaderRepository = new BadgeReaderRepository();
    }

    public List<BadgeReaderDTO> getAllBadgeReaders () {
        
    	List<BadgeReader> listBadgeReader = this.badgeReaderRepository.getAllBadgeReaders();
        
    	List<BadgeReaderDTO> listDTO=new ArrayList<>();
    	
    	for(BadgeReader br: listBadgeReader) {
    		listDTO.add(BadgeReaderConverter.convertToDTO(br));
    	}
    	
    	return listDTO;
    	
    }
    
    public List<BadgeReaderDTO> getAllBadgeReadersIdAsset (int idAsset) {
        List<BadgeReader> brList=this.badgeReaderRepository.getAllBadgeReadersIdAsset(idAsset);
        
        List<BadgeReaderDTO> brDTOList=new ArrayList<>();
        
        for(BadgeReader br: brList) {
        	brDTOList.add(BadgeReaderConverter.convertToDTO(br));
        }
        
        return brDTOList;
        
    }
    
    public List<BadgeReaderDTO> getBadgeReader (int id) {
    	
    	List<BadgeReader> brList=this.badgeReaderRepository.getBadgeReader(id);
        
        List<BadgeReaderDTO> brDTOList=new ArrayList<>();
        
        for(BadgeReader br: brList) {
        	brDTOList.add(BadgeReaderConverter.convertToDTO(br));
        }
        
        return brDTOList;
    	
    }

    public boolean insertBadgeReader (BadgeReaderDTO badgeReaderDTO) {
    	
    	BadgeReader badgeReader=BadgeReaderConverter.converToEntity(badgeReaderDTO);
    	
        return this.badgeReaderRepository.insertBadgeReader(badgeReader);
        
    }
    
    public boolean deleteBadgeReadear (int idBadgeReader) {
    	return this.badgeReaderRepository.deleteBadgeReadear(idBadgeReader);
    }
    
    public boolean updateBadgeReader(HttpServletRequest request) {
    	return this.badgeReaderRepository.updateBadgeReader(request);
    }
	
}
