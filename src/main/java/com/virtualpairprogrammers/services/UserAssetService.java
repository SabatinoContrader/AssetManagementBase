package com.virtualpairprogrammers.services;

import com.virtualpairprogrammers.dao.UserDAO;
import com.virtualpairprogrammers.dao.UserAssetDAO;
import com.virtualpairprogrammers.dao.AssetDAO;
import com.virtualpairprogrammers.domain.User;
import com.virtualpairprogrammers.domain.UserAsset;
import com.virtualpairprogrammers.domain.Asset;

import java.util.List;

public class UserAssetService {

    private UserAssetDAO userAssetDAO;
	private Object userDAO;
	private Object assetDAO;

    public UserAssetService() {
        this.userAssetDAO = new UserAssetDAO();
    }
    public List<User> getAllUsers () {
        return ((UserDAO) this.userDAO).getAllUsers();
    }
    public List<UserAsset> getAllUsersAssets () {
        return this.userAssetDAO.getAllUsersAssets();
    }
    public List<Asset> getAllUsersAssetsN () {
        return (((AssetDAO) this.assetDAO).getAllAssetsN());
    }

    public boolean insertUserAsset (UserAsset userAsset) {
        return this.userAssetDAO.insertUserAsset(userAsset);
    }
    public boolean deleteUserAsset (int idUser, int idAsset, String idData) {
        return this.userAssetDAO.deleteUserAsset(idUser, idAsset, idData);
    }
}
