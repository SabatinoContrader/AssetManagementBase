package main.service;

import main.dao.UserassetDAO;
import main.model.Userasset;

import java.util.List;

public class UserassetService {

    private UserassetDAO UserassetDAO;

    public UserassetService() {
        this.UserassetDAO = new UserassetDAO();
    }

    public List<Userasset> getAllUserassets () {
        return this.UserassetDAO.getAllUserassets();
    }

    public boolean insertUserasset (Userasset userasset) {
        return this.UserassetDAO.insertUserasset(userasset);
    }
}


