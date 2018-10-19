package com.pCarpet.dao;

import com.pCarpet.model.Badge;
import com.pCarpet.model.User;
import com.pCarpet.utils.ConnectionSingleton;
import com.pCarpet.utils.GestoreEccezioni;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
	
	String param="";
	
	private final String QUERY_ALL = "select * from user";
    private final String QUERY_INSERT = "insert into user (iduser, username, password, ragioneSociale, telefono, mail, partitaiva, ruolo, nomeAbb) values (?,?,?,?,?,?,?,?,?)";
    private final String QUERY_DELETE = "delete from user where iduser=?";
    private final String QUERY_CLIENTI = "select * from user where ruolo='cliente'";
    private final String QUERY_CLIENTIASS= "select distinct u.iduser,username,ragioneSociale,partitaiva from user as u join userasset as us on u.iduser=us.iduser where ruolo='cliente'";
    //private final String QUERY_UPDATE = "update user set "+param+"=? where idutente=?";
    private final String QUERY_LOGIN = "select * from user where username = ? and password = ?";
    
    @Autowired
    public UserRepository() {

    }
    
    public boolean login (String username, String password) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
            statement.setString(1, username);
            statement.setString(2, password);
            return statement.executeQuery().next();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }

    public User getLoggedUser (String username, String password) {
        User user = null;
        Connection connection = ConnectionSingleton.getInstance();
        try {
        	PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeQuery().next();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	int idutente = resultSet.getInt("iduser");
            	username = resultSet.getString("username");
            	password = resultSet.getString("password");
            	String ragioneSociale = resultSet.getString("ragioneSociale");
            	String telefono = resultSet.getString("telefono");
            	String mail = resultSet.getString("mail");
            	String partitaiva = resultSet.getString("partitaiva");
            	String ruolo = resultSet.getString("ruolo");
            	String nomeAbb = resultSet.getString("nomeAbb");
            	int flag = resultSet.getInt("flag");
            	user=new User(idutente, username, password,ragioneSociale,telefono,mail,partitaiva,ruolo,nomeAbb,flag);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getAllClienti () {
        List<User> listUsers = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_CLIENTI);
           while (resultSet.next()) {
        	   int idutente = resultSet.getInt("iduser");
        	   String username = resultSet.getString("username");
        	   String password = resultSet.getString("password");
        	   String ragioneSociale = resultSet.getString("ragioneSociale");
        	   String telefono = resultSet.getString("telefono");
        	   String mail = resultSet.getString("mail");
        	   String partitaiva = resultSet.getString("partitaiva");
        	   String ruolo = resultSet.getString("ruolo");
        	   String nomeAbb = resultSet.getString("nomeAbb");
        	   int flag = resultSet.getInt("flag");
        	   listUsers.add(new User(idutente, username, password,ragioneSociale,telefono,mail,partitaiva,ruolo,nomeAbb,flag));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listUsers;
    }
    
    public List<User> getAllClientiAss () {
        List<User> listUsers = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_CLIENTIASS);
           while (resultSet.next()) {
        	   int idutente = resultSet.getInt("iduser");
        	   String username = resultSet.getString("username");
        	   String ragioneSociale = resultSet.getString("ragioneSociale");
        	   String partitaiva = resultSet.getString("partitaiva");
        	   int flag = resultSet.getInt("flag");
        	   listUsers.add(new User(idutente, username,ragioneSociale,partitaiva,flag));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listUsers;
    }
    
    public List<User> getAllUsers () {
        List<User> listUsers = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
        	   int idutente = resultSet.getInt("iduser");
        	   String username = resultSet.getString("username");
        	   String password = resultSet.getString("password");
        	   String ragioneSociale = resultSet.getString("ragioneSociale");
        	   String telefono = resultSet.getString("telefono");
        	   String mail = resultSet.getString("mail");
        	   String partitaiva = resultSet.getString("partitaiva");
        	   String ruolo = resultSet.getString("ruolo");
        	   String nomeAbb = resultSet.getString("nomeAbb");
        	   int flag = resultSet.getInt("flag");
        	   listUsers.add(new User(idutente, username, password,ragioneSociale,telefono,mail,partitaiva,ruolo,nomeAbb,flag));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listUsers;
    }
    
    public User getUser (int id) {
        User user = null;
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("select * from user where iduser="+id);
           while (resultSet.next()) {
        	   int idutente = resultSet.getInt("iduser");
        	   String username = resultSet.getString("username");
        	   String password = resultSet.getString("password");
        	   String ragioneSociale = resultSet.getString("ragioneSociale");
        	   String telefono = resultSet.getString("telefono");
        	   String mail = resultSet.getString("mail");
        	   String partitaiva = resultSet.getString("partitaiva");
        	   String ruolo = resultSet.getString("ruolo");
        	   String nomeAbb = resultSet.getString("nomeAbb");
        	   int flag = resultSet.getInt("flag");
        	   user=new User(idutente, username, password,ragioneSociale,telefono,mail,partitaiva,ruolo,nomeAbb,flag);
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean insertUser(User user) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, user.getIduser());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getRagioneSociale());
            preparedStatement.setString(5, user.getTelefono());
            preparedStatement.setString(6, user.getMail());
            preparedStatement.setString(7, user.getPartitaiva());
            preparedStatement.setString(8, user.getRuolo());
            preparedStatement.setString(9, user.getNomeAbb());
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    
    public boolean deleteUser(int idUser) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, idUser);
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
        	if(e instanceof SQLIntegrityConstraintViolationException) {
        		System.out.println("Impossibile eliminare utente in quanto associato ad un asset");
        		return false;
        	}
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    
    public boolean updateUser(HttpServletRequest request) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
        	param=(String)request.getParameter("campo");
          	 int id=Integer.parseInt(request.getParameter("id"));
        	PreparedStatement preparedStatement = connection.prepareStatement("update user set "+param+"=? where iduser=?");
            preparedStatement.setString(1, request.getParameter("nuovoCampo"));
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            return true;
            
        }
            
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
            }
    }
    
}
