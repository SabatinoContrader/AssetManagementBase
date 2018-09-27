package main.service;

import main.dao.AssetDAO;
import main.model.Asset;

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
    public boolean DeleteAsset (int idasset) {
    	return this.assetDAO.DeleteAsset(idasset);
    }
}


