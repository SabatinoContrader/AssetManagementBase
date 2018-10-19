package com.pCarpet.services;

import com.pCarpet.converter.BadgeConverter;
import com.pCarpet.converter.MovimentoConverter;
import com.pCarpet.dao.BadgeReaderRepository;
import com.pCarpet.dao.BadgeRepository;
//import main.dao.BadgereaderDAO;
import com.pCarpet.dao.MovimentoRepository;
import com.pCarpet.dto.BadgeDTO;
import com.pCarpet.dto.MovimentoDTO;
import com.pCarpet.model.Badge;
import com.pCarpet.model.Movimento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MovimentoService {

    private MovimentoRepository movimentoRepository;
	private BadgeRepository badgeRepository;
	private BadgeReaderRepository badgereaderRepository;
	
	@Autowired
    public MovimentoService(MovimentoRepository movimento) {
        this.movimentoRepository = movimento;
    }
	
    public List<BadgeDTO> getAllBadges () {
    	
    	List<Badge> bList=this.badgeRepository.getAllBadges();
    	
    	List<BadgeDTO> bDTO=new ArrayList<>();

    	for(Badge b: bList) {
    		bDTO.add(BadgeConverter.convertToDTO(b));
    	}
    	
        return bDTO;
    }
    
    public List<MovimentoDTO> getAllMovimenti () {
    	
    	List<Movimento> bList=this.movimentoRepository.getAllMovimenti();
    	
    	List<MovimentoDTO> mDTO=new ArrayList<>();

    	for(Movimento m: bList) {
    		mDTO.add(MovimentoConverter.convertToDTO(m));
    	}
    	
        return mDTO;
    	
    }
    
    public List<MovimentoDTO> getAllUserMovimenti (String iduser) {
    	
    	List<Movimento> bList=this.movimentoRepository.getAllMovimenti();
    	
    	List<MovimentoDTO> mDTO=new ArrayList<>();

    	for(Movimento m: bList) {
    		mDTO.add(MovimentoConverter.convertToDTO(m));
    	}
    	
        return mDTO;
    }
    
    
    public List getAllExportMovimenti() {
    	
    	return this.movimentoRepository.getAllExportMovimenti();
    	
    }
    
    public List getExportMovimento(String iduser1) {
    	
    	return this.movimentoRepository.getExportMovimento(iduser1);
    	
    }
    
  /*  public List<BadgeReader> getAllBadgeReaders () {
        return (((BadgeReaderDAO) this.badgeReaderDAO).getBadgeReaders());
    }
*/
    
    
    //LO FA UMBERTO
    
//    public boolean insertMovimento (Movimento movimento) {
//        return this.movimentoRepository.insertMovimento(movimento);
//    }
    
//    public boolean deleteMovimento (int idBadgeReader, int idBadge, String datainizio) {
//        return this.movimentoRepository.deleteMovimento(idBadgeReader, idBadge, datainizio);
//    }
}
