package com.virtualpairprogrammers.service;


import com.virtualpairprogrammers.dao.UserDAO;
//import com.virtualpairprogrammers.domain.User;
//import com.virtualpairprogrammers.dao.UserAssetDAO;
//import com.virtualpairprogrammers.servlets.Request;

import java.util.List;

public class UserService {

    private UserDAO userDAO;
//    private UserAssetDAO userAssetDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public boolean login (String username, String password ) {
        return this.userDAO.login(username, password );
    }

//    public List<User> getAllUsers () {
//        return this.userDAO.getAllUsers();
//    }
   /* public List<User> getAllClienti () {
        return this.userDAO.getAllClienti();
    }
    
    public List<User> getAllClientiAss(){
    	return this.userDAO.getAllClientiAss();
    }*/

//    public boolean insertUser (User user) {
//        return this.userDAO.insertUser(user);
//    }
//    
//    public boolean deleteUser(String username) {
//    	return this.userDAO.deleteUser(username);
//    }
//    
//    public List<User> getAllUsersN(){
//    	return this.userAssetDAO.getAllUsersN();
//    }
//    
//    public boolean updateUser(Request request) {
//    	return this.userDAO.udpateUser(request);
//    }
//
//    
//
//    public User getLoggedUser (){
//        return this.userDAO.getLoggedUser();
//    }
//
//    public void destroyUser(){
//        this.userDAO.destroyUser();
//    }
}


