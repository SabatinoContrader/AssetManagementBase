package main.service;

import main.dao.AssetDAO;
import main.dao.UserDAO;
import main.dao.UserassetDAO;
import main.model.Asset;
import main.model.User;
import main.model.Userasset;

import java.util.List;

public class UserassetService {

    private UserassetDAO UserassetDAO;
	private Object userDAO;
	private Object assetDAO;

    public UserassetService() {
        this.UserassetDAO = new UserassetDAO();
    }
    public List<User> getAllUsers () {
        return ((UserDAO) this.userDAO).getAllUsers();
    }
    public List<Userasset> getAllUserassets () {
        return this.UserassetDAO.getAllUserassets();
    }
    public List<Asset> getAllUserassetsN () {
        return (((AssetDAO) this.assetDAO).getAllAssetsN());
    }

    public boolean insertUserasset (Userasset userasset) {
        return this.UserassetDAO.insertUserasset(userasset);
    }
}


