package main.service;

import main.dao.AssetDAO;
import main.model.Asset;

import java.util.List;

public class AssetService {

    private AssetDAO AssetDAO;

    public AssetService() {
        this.AssetDAO = new AssetDAO();
    }

    public List<Asset> getAllAssets () {
        return this.AssetDAO.getAllAssets();
    }

    public boolean insertAsset (Asset asset) {
        return this.AssetDAO.insertAsset(asset);
    }
    public boolean DeleteAsset (int idasset) {
    	return this.AssetDAO.DeleteAsset(idasset);
    }
}


