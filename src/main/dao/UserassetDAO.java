package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Asset;
import main.model.Userasset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserassetDAO {

    private final String QUERY_INSUSERASS = "insert into userasset(iduser,idasset,orainizio,orafine) values (?,?,?,?) ";
    private final String QUERY_ALLUSERASS = "select * from userasset";

    
    public List<Userasset> getAllUserassets () {
        List<Userasset> userassets = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALLUSERASS);
           while (resultSet.next()) {
        	   int iduser = resultSet.getInt("iduser");
        	   int idasset = resultSet.getInt("idasset");
        	   String orainizio = resultSet.getString("orainizio");
               String orafine = resultSet.getString("orafine");
               userassets.add(new Userasset(iduser,idasset,orainizio,orafine));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return userassets;
    }
    
    public boolean insertUserasset(Userasset userasset) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSUSERASS);
            preparedStatement.setInt(1, userasset.getIduser());
            preparedStatement.setInt(2, userasset.getIdasset());
            preparedStatement.setString(3, userasset.getOrainizio());
            preparedStatement.setString(4, userasset.getOrafine());
            
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
}
