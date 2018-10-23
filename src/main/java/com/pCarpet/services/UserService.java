package com.pCarpet.services;

import com.pCarpet.converter.UserConverter;
import com.pCarpet.dao.UserRepository;
import com.pCarpet.dto.UserDTO;
import com.pCarpet.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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
    
    public String login (String username, String password) {
    	List<User> l=(List<User>) this.userRepository.findAll();
    	for(User u: l) {
    		if(username.equals(u.getUsername()) && password.equals(u.getPassword())) {
    			
    			return u.getRuolo();
    		}
    		
    	}
    	
    	return "";
    }

    public List<UserDTO> getAllUsers () {
    	
        List<User> listU = (List<User>)this.userRepository.findAll();
        
        List<User> ll=new LinkedList<User>();
       
        
        for(User u:listU) {
        	if(u.getFlag()==1) {
        		ll.add(u);
        	}
        }
        
        List<UserDTO> listDTO=new ArrayList<>();
        
        for(User u: ll) {
        	listDTO.add(UserConverter.covertToDTO(u));
        }
        
        return listDTO;
        
    
    }
    
//    public UserDTO getLoggedUser (String username, String password) {
//    	
//    	
//    	User u = this.userRepository.getLoggedUser(username, password);
//    	
//    	UserDTO uDTO = UserConverter.covertToDTO(u);
//    	
//        return uDTO;
//        
//    	
//    }
    
    public UserDTO getUser (int id) {
    	
    
        Optional<User> optionalU = this.userRepository.findById(Long.parseLong(id+""));
        User u=optionalU.get();
        
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
        return this.userRepository.save(user)!=null;
     
    }
    
    public void deleteUser(int idUser) {
    	User u = this.userRepository.findById(Long.valueOf(idUser)).get();
    	u.setFlag(0l);
    	this.userRepository.save(u);
    	
    	
    	
    	
    }
    
    /*
    public List<User> getAllUsersN(){
    	return this.userAssetDAO.getAllUsersN();
    }
    */
    
//    public boolean updateUser(HttpServletRequest request) {
//    	
//    	return this.userRepository.updateUser(request);
//    	
//    	
//    }
    
    public boolean updateUser(UserDTO userDTO) {
    	return this.userRepository.save(UserConverter.converToEntity(userDTO))!=null;
    }
}
