package com.pCarpet.services;



import com.pCarpet.converter.AssetConverter;
import com.pCarpet.dao.AssetRepository;
import com.pCarpet.dto.AssetDTO;
import com.pCarpet.model.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

	@Service
	public class AssetService {

    private AssetRepository assetRepository;
    //private UserAssetDAO userAssetDAO;
    
    @Autowired
    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public List<AssetDTO> getAllAssets () {
    	
    	
    	List<Asset> aList=this.assetRepository.getAllAssets();
    	
    	List<AssetDTO> aDTOlist=new ArrayList<>();
    	
    	for(Asset a: aList) {
    		aDTOlist.add(AssetConverter.convertToDTO(a));
    	}
    	
    	return aDTOlist;
    	
    }
    
    public List<AssetDTO> getAllAssetsN () {
    	
    	List<Asset> aList=this.assetRepository.getAllAssetsN();
    	
    	List<AssetDTO> aDTOlist=new ArrayList<>();
    	
    	for(Asset a: aList) {
    		aDTOlist.add(AssetConverter.convertToDTO(a));
    	}
    	
    	return aDTOlist;
    }
    
    public AssetDTO getAsset (int id) {
        Asset a = this.assetRepository.getAsset(id);
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

    public boolean insertAsset (AssetDTO assetDTO) {
    	
    	Asset asset = AssetConverter.converToEntity(assetDTO);
    	
        return this.assetRepository.insertAsset(asset);
        
    }
    
    public boolean deleteAsset(int idAsset) {
    	return this.assetRepository.deleteAsset(idAsset);
    }
    
    /*
    public List<User> getAllUsersN(){
    	return this.userAssetDAO.getAllUsersN();
    }
    */
    
    public boolean updateAsset(HttpServletRequest request) {
    	return this.assetRepository.updateAsset(request);
    }
}