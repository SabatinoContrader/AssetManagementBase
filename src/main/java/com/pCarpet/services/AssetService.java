package com.pCarpet.services;



import com.pCarpet.converter.AssegnazioneConverter;
import com.pCarpet.converter.AssetConverter;
import com.pCarpet.converter.BadgeConverter;
import com.pCarpet.converter.BadgeReaderConverter;
import com.pCarpet.dao.AssetRepository;
import com.pCarpet.dao.BadgeReaderRepository;
import com.pCarpet.dto.AssegnazioneDTO;
import com.pCarpet.dto.AssetDTO;
import com.pCarpet.dto.BadgeDTO;
import com.pCarpet.dto.BadgeReaderDTO;
import com.pCarpet.model.Assegnazione;
import com.pCarpet.model.Asset;
import com.pCarpet.model.Badge;
import com.pCarpet.model.BadgeReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

	@Service
	public class AssetService {

    private AssetRepository assetRepository;
    private BadgeReaderService badgeReaderService;
    private BadgeReaderRepository badgeReaderRepository;
    
    //private UserAssetDAO userAssetDAO;
    
    @Autowired
    public AssetService(AssetRepository assetRepository, BadgeReaderService brs, BadgeReaderRepository brp) {
        this.assetRepository = assetRepository;
        this.badgeReaderService = brs;
        this.badgeReaderRepository = brp;
    }

    public List<AssetDTO> getAllAssets () {
    	
    	
    	List<Asset> aList=(List<Asset>)this.assetRepository.findAll();
    	
    	List<AssetDTO> aDTOlist=new ArrayList<>();
    	
    	for(Asset a: aList) {
    		aDTOlist.add(AssetConverter.convertToDTO(a));
    	}
    	
    	return aDTOlist;
    	
    }
    
    public List<AssetDTO> getAllAssetsN () {
    	
    	List<Asset> aList=(List<Asset>)this.assetRepository.findAll();
    	List<BadgeReader> bList=(List<BadgeReader>)this.badgeReaderRepository.findAll();
        
        
        
    	List<AssetDTO> listADTO = new ArrayList<>();
        List<BadgeReaderDTO> listBRDTO=new ArrayList<>();
        List<AssetDTO> llAS = new LinkedList<>();
        
         for(BadgeReader b: bList) {
        	listBRDTO.add(BadgeReaderConverter.convertToDTO(b));
         }
        for(Asset a: aList) {
        	listADTO.add(AssetConverter.convertToDTO(a));
        }
        llAS.addAll(listADTO);
        for(AssetDTO a:llAS) {
        	System.out.println("test"+a.getIdAsset());
        }
        
        
        for(AssetDTO aaDTO:listADTO) {
        	
        	for(BadgeReaderDTO brDTO: listBRDTO) {
        		System.out.println("TEST aaDTO:"+aaDTO.getIdAsset());
        		System.out.println("TEST brDTO:"+brDTO.getIdAsset());
        		if(aaDTO.getIdAsset()==brDTO.getIdAsset()) {
        			System.out.println("LONG:"+brDTO.getFlag());
        			if(brDTO.getFlag()==1l) {
        				System.out.println("ELIMINA");
        				llAS.remove(aaDTO);
        			}
        		}
        	}
        }
    	return llAS;
    	
    }
    public AssetDTO getAsset (long id) {
        Asset a = (Asset)this.assetRepository.findById(id).get();
        return AssetConverter.convertToDTO(a);
    }
    /*
    public List<User> getAllClienti () {
        return this.userDAO.getAllClienti();
    }
    
    public List<User> getAllClientiAss(){
    	return this.userDAO.getAllClientiAss();
    }
    */

    public void insertAsset (AssetDTO assetDTO) {
    	
    	Asset asset = AssetConverter.converToEntity(assetDTO);
    	
        this.assetRepository.save(asset);
        
    }
    
    public void deleteAsset(long id) {
    	List<BadgeReaderDTO> brList=this.badgeReaderService.getAllBadgeReaders();
    	List<BadgeReader> listBR = new LinkedList<>();
    	 for(BadgeReaderDTO b: brList) {
        	
			listBR.add(BadgeReaderConverter.converToEntity(b));
         }
    	 for(BadgeReader br: listBR) {
    		 if(br.getIdAsset()==id) {
    			 br.setIdAsset(1l);
    			 br.setFlag(0l);
    			 br.setDescrizione("non associato");
    			 br.setTipologia("non associato");
    			 badgeReaderRepository.save(br);
    		 }
    		 
    	 }
    	 this.assetRepository.deleteById(id);
    	
    }
    
    
    
    /*
    public List<User> getAllUsersN(){
    	return this.userAssetDAO.getAllUsersN();
    }
    */
    
//    public boolean updateAsset(HttpServletRequest request) {
//    	return this.assetRepository.updateAsset(request);
//    }
}