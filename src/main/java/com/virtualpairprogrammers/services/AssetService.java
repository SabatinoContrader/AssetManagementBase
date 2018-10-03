package com.virtualpairprogrammers.services;

import com.virtualpairprogrammers.servlets.Request;
import com.virtualpairprogrammers.dao.AssetDAO;
import com.virtualpairprogrammers.domain.Asset;

import java.util.List;

public class AssetService {

    private AssetDAO assetDAO;

    public AssetService() {
        this.assetDAO = new AssetDAO();
    }

    public List<Asset> getAllAssets () {
        return this.assetDAO.getAllAssets();
    }
    public List<Asset> getAllAssetsN () {
        return this.assetDAO.getAllAssetsN();
    }

    public boolean insertAsset (Asset asset) {
        return this.assetDAO.insertAsset(asset);
    }
    public boolean deleteAsset (int idasset) {
    	return this.assetDAO.DeleteAsset(idasset);
    }
    
    public boolean updateAsset(Request request) {
    	return this.assetDAO.UpdateAsset(request);
    }
}
