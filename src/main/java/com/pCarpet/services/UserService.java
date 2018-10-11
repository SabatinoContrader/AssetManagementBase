package com.pCarpet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pCarpet.dao.UserRepository;
import com.pCarpet.model.User;

@Service
public class UserService {

	private UserRepository userRepository;
	private static User loggedUser;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Boolean login(String username, String password) {
		User user = userRepository.findByUsernameAndPassword(username, password);
		if (user == null) {
			return false;
		} else {
			if (user.getPassword().equals(password)) {
				loggedUser = user;
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean insertUser(User user) {
		if (existsByUsername(user.getUsername())) {
			return false;
		} else {
			this.userRepository.save(user);
			return true;
		}
	}

	public boolean existsByUsername(String username) {
		return this.userRepository.existsByUsername(username);
	}
	
	public List<User> findAll(){
		return (List<User>) this.userRepository.findAll();
	}
	
	public List<User> findId(int id) {
		return userRepository.findId(id);
	}
	
//	public void deleteById(long id) {
//		this.userRepository.deleteById((long)id);
//	}
	
	public void deleteId(int id) {
		this.userRepository.deleteId(id);
	}

	public User getLoggedUser() {
		return loggedUser;
	}

	public void destroyUser() {
		loggedUser = null;
	}

	public void updateNome(int iduser,String nuovoCampo) {
		this.userRepository.updateNome(iduser,nuovoCampo);
	}
	
	public void updateCognome(int iduser,String nuovoCampo) {
		this.userRepository.updateCognome(iduser,nuovoCampo);
	}
	
	public void updateUsername(int iduser,String nuovoCampo) {
		this.userRepository.updateUsername(iduser,nuovoCampo);
	}
	
	public void updatePassword(int iduser,String nuovoCampo) {
		this.userRepository.updatePassword(iduser,nuovoCampo);
	}
	
	public void updateTelefono(int iduser,String nuovoCampo) {
		this.userRepository.updateTelefono(iduser,nuovoCampo);
	}
	
	public void updateMail(int iduser,String nuovoCampo) {
		this.userRepository.updateMail(iduser,nuovoCampo);
	}
	
	public void updatePartitaIva(int iduser,String nuovoCampo) {
		this.userRepository.updatePartitaIva(iduser,nuovoCampo);
	}
	
	public void updateRuolo(int iduser,String nuovoCampo) {
		this.userRepository.updateRuolo(iduser,nuovoCampo);
	}
	
	
	
	
	
}
