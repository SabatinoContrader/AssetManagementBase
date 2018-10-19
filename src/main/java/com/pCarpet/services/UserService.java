package com.pCarpet.services;

import com.pCarpet.converter.UserConverter;
import com.pCarpet.dao.UserRepository;
import com.pCarpet.dto.UserDTO;
import com.pCarpet.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService {

    private UserRepository userRepository;
    //private UserAssetDAO userAssetDAO;
    
    
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    
    public UserRepository getUserRepository() {
    	return this.userRepository;
    }
    
    public boolean login (String username, String password) {
    	
    	return this.userRepository.login(username, password);
    }

    public List<UserDTO> getAllUsers () {
        List<User> listU = this.userRepository.getAllUsers();
        
        List<UserDTO> listDTO=new ArrayList<>();
        
        for(User u: listU) {
        	listDTO.add(UserConverter.covertToDTO(u));
        }
        
        return listDTO;
        
    }
    
    public UserDTO getLoggedUser (String username, String password) {
    	
    	User u = this.userRepository.getLoggedUser(username, password);
    	
    	UserDTO uDTO = UserConverter.covertToDTO(u);
    	
        return uDTO;
    }
    
    public UserDTO getUser (int id) {
    	
    	
        User u = this.userRepository.getUser(id);
        
        return UserConverter.covertToDTO(u);
    }
    /*
    public List<User> getAllClienti () {
        return this.userDAO.getAllClienti();
    }
    
    public List<User> getAllClientiAss(){
    	return this.userDAO.getAllClientiAss();
    }
    */

    public boolean insertUser (UserDTO userDTO) {
    	User user = UserConverter.converToEntity(userDTO);
        return this.userRepository.insertUser(user);
    }
    
    public boolean deleteUser(int idUser) {
    	return this.userRepository.deleteUser(idUser);
    }
    
    /*
    public List<User> getAllUsersN(){
    	return this.userAssetDAO.getAllUsersN();
    }
    */
    
    public boolean updateUser(HttpServletRequest request) {
    	return this.userRepository.updateUser(request);
    }
}
