package com.pCarpet.services;

import com.pCarpet.converter.BadgeConverter;
import com.pCarpet.converter.MovimentoConverter;
import com.pCarpet.dao.AssegnaRepository;
import com.pCarpet.dao.AssetRepository;
import com.pCarpet.dao.BadgeReaderRepository;
import com.pCarpet.dao.BadgeRepository;
import com.pCarpet.dao.MovimentoRepository;
import com.pCarpet.dao.UserRepository;
import com.pCarpet.dto.BadgeDTO;
import com.pCarpet.dto.ExportDTO;
import com.pCarpet.dto.MovimentoDTO;
import com.pCarpet.model.Assegnazione;
import com.pCarpet.model.Asset;
import com.pCarpet.model.Badge;
import com.pCarpet.model.BadgeReader;
import com.pCarpet.model.Movimento;
import com.pCarpet.model.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimentoService {

   private BadgeRepository badgeRepository;
   private MovimentoRepository movimentoRepository;
   private AssegnaRepository assegnazioneRepository;
   private UserRepository userRepository;
   private AssetRepository assetRepository;
   private BadgeReaderRepository badgeReaderRepository;
   
   	
   @Autowired
   public MovimentoService(BadgeRepository badgeRepository, MovimentoRepository movimentoRepository, AssegnaRepository assegnazioneRepository, UserRepository userRepository, AssetRepository assetRepository,BadgeReaderRepository badgeReaderRepository) {
	   this.badgeRepository=badgeRepository;
	   this.movimentoRepository=movimentoRepository;
	   this.assegnazioneRepository=assegnazioneRepository;
	   this.userRepository=userRepository;
	   this.assetRepository=assetRepository;
	   this.badgeReaderRepository= badgeReaderRepository;
   }
	
	
   public List<BadgeDTO> getAllBadges () {
    	
    	List<Badge> bList=(List<Badge>)this.badgeRepository.findAll();
    	
    	List<BadgeDTO> bDTO=new ArrayList<>();

    	for(Badge b: bList) {
    		bDTO.add(BadgeConverter.convertToDTO(b));
    	}
    	
        return bDTO;
    }
    
    public List<MovimentoDTO> getAllMovimenti () {
    	
    	List<Movimento> bList=(List<Movimento>)this.movimentoRepository.findAll();
    	
    	List<Assegnazione> aList = (List<Assegnazione>)this.assegnazioneRepository.findAll();
    	
    	List<Movimento> listUserMov = new LinkedList<>();
    	
    	for(Movimento m: bList) {
    		for(Assegnazione a: aList) {
    			
    			if(m.getIdbadge()==a.getIdbadge() && a.getFlag()==1) {
    				listUserMov.add(m);
    			}
    			
    		}
    	}
    		
    	
    	List<MovimentoDTO> mDTO=new ArrayList<>();

    	for(Movimento m: listUserMov) {
    		mDTO.add(MovimentoConverter.convertToDTO(m));
    	}
    	
        return mDTO;
    	
    }
    
    public List<MovimentoDTO> getAllUserMovimenti (String iduser) {
    	
    	
    	List<Movimento> bList=(List<Movimento>)this.movimentoRepository.findAll();
    	
    	
    	
    	List<MovimentoDTO> mDTO=new ArrayList<>();

    	for(Movimento m: bList) {
    		mDTO.add(MovimentoConverter.convertToDTO(m));
    	}
    	
        return mDTO;
    }
    
    
    public List<String> getAllExportMovimenti() {
    	
    	List<Movimento> lMov=new LinkedList<>();
    	List<User> lUser=new LinkedList<>();
    	
    	List<Asset> lAsset=new LinkedList<>();
    	
    	List<Long> lLong=new LinkedList<>();
    	List<Long> uLong=new LinkedList<>();
    	
    	lMov=(List<Movimento>)this.movimentoRepository.findAll();
    	
    	
    	
    	List<String> l=new LinkedList<>();
    	
    	for(int i=0; i<lMov.size(); i++) {
    		
    		List<Assegnazione> listA=(List<Assegnazione>)this.assegnazioneRepository.findAllByIdbadge(lMov.get(i).getIdbadge());
    		
    		for(Assegnazione a: listA) {
    			User u=this.userRepository.findById(a.getIduser()).get();
    			BadgeReader br=this.badgeReaderRepository.findById(lMov.get(i).getIdbadgereader()).get();
        		Asset asset=this.assetRepository.findById(br.getIdAsset()).get();
        		
        		if(a.getFlag()==1)
        			l.add(String.valueOf(u.getIduser()));
        		else
        			l.add(String.valueOf(u.getIduser()+" (Deleted)"));
        		
        		l.add(u.getRagioneSociale());
        		l.add(a.getNome());
        		l.add(a.getCognome());
        		
        		
        		l.add(String.valueOf(asset.getIdasset()));
        		l.add(asset.getTipo());
        		l.add(String.valueOf(asset.getPrezzo()));
        		l.add(asset.getDescrizione());
        		
        		l.add(lMov.get(i).getOrainizio());
        		l.add(lMov.get(i).getOrafine());
    		}
    		
    		
    		
    		
    		
    		
    	}
    	
    	
    	
    	return l;
    }
    
    public List getExportMovimento(String iduser1) {
    	
    	List<Movimento> lMov=new LinkedList<>();
    	List<User> lUser=new LinkedList<>();
    	
    	List<Asset> lAsset=new LinkedList<>();
    	
    	List<Long> lLong=new LinkedList<>();
    	List<Long> uLong=new LinkedList<>();
    	
    	lMov=(List<Movimento>)this.movimentoRepository.findAll();
    	
    	
    	
    	List<String> l=new LinkedList<>();
    	
    	for(int i=0; i<lMov.size(); i++) {
    		
    		List<Assegnazione> listA=(List<Assegnazione>)this.assegnazioneRepository.findAllByIdbadge(lMov.get(i).getIdbadge());
    		
    		for(Assegnazione a: listA) {
    			User u=this.userRepository.findById(a.getIduser()).get();
    			
    			if(String.valueOf(u.getIduser()).equals(iduser1)) {
    				
    			
    			
    			BadgeReader br=this.badgeReaderRepository.findById(lMov.get(i).getIdbadgereader()).get();
        		Asset asset=this.assetRepository.findById(br.getIdAsset()).get();
        		
        		if(a.getFlag()==1 || u.getFlag()==1)
        			l.add(String.valueOf(u.getIduser()));
        		else
        			l.add(String.valueOf(u.getIduser()+" (Deleted)"));
        		
        		l.add(u.getRagioneSociale());
        		l.add(a.getNome());
        		l.add(a.getCognome());
        		
        		
        		l.add(String.valueOf(asset.getIdasset()));
        		l.add(asset.getTipo());
        		l.add(String.valueOf(asset.getPrezzo()));
        		l.add(asset.getDescrizione());
        		
        		l.add(lMov.get(i).getOrainizio());
        		l.add(lMov.get(i).getOrafine());
        		
    			}
        		
    		}
    		
    		
    		
    		
    		
    		
    	}
    	
    	
    	
    	return l;
    
    	
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
