package com.pCarpet.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pCarpet.dto.AbbonamentoDTO;
import com.pCarpet.dto.UserDTO;
import com.pCarpet.model.Abbonamento;
import com.pCarpet.model.User;
import com.pCarpet.services.AbbonamentoService;
import com.pCarpet.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/HomeUser")
public class HomeUserController {
	
	private UserService userService;
	private boolean isLogged = false;
	private AbbonamentoService abbonamentoService;

	@Autowired
	public HomeUserController(UserService userService,AbbonamentoService abbonamentoService) {
		this.userService = userService;
		this.abbonamentoService=abbonamentoService;
	}

	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@CrossOrigin
	public List<UserDTO> deleteControl(HttpServletRequest request, Model model ) {
		int id=Integer.parseInt(request.getParameter("id"));
		this.userService.deleteUser(id);
		List<UserDTO> users = userService.getAllUsers();
		return users;
	}
	
	
	@RequestMapping(value = "/getById", method = RequestMethod.GET)
	@CrossOrigin
	public UserDTO getByIdControl(HttpServletRequest request, Model model ) {
		int id=Integer.parseInt(request.getParameter("id"));
		UserDTO u = this.userService.getUser(id);
		return u;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	@CrossOrigin
	public List<UserDTO> modifyControl(HttpServletRequest request, Model model ) {
		long iduser=Integer.parseInt(request.getParameter("iduser"));
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String ragioneSociale=request.getParameter("ragioneSociale");
		String telefono=request.getParameter("telefono");
		String mail=request.getParameter("mail");
		String partitaiva=request.getParameter("partitaIva");
		String ruolo=request.getParameter("ruolo");
		long idAbb=Integer.parseInt(request.getParameter("idAbb"));
		AbbonamentoDTO abb=abbonamentoService.findById(idAbb);
		UserDTO uDTO = new UserDTO(iduser,username,password,ragioneSociale,telefono,mail,partitaiva,ruolo,abb);
		this.userService.insertUser(uDTO);
		List<UserDTO> users = this.userService.getAllUsers();
		return users;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public List<UserDTO> insertControl(HttpServletRequest request, Model model ) {
		System.out.println("TEST");
		long iduser=0;
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String ragioneSociale=request.getParameter("ragioneSociale");
		String telefono=request.getParameter("telefono");
		String mail=request.getParameter("mail");
		String partitaiva=request.getParameter("partitaIva");
		String ruolo=request.getParameter("ruolo");
		long idAbb=Integer.parseInt(request.getParameter("idAbb"));
		AbbonamentoDTO abb=abbonamentoService.findById(idAbb);
		UserDTO uDTO = new UserDTO(iduser,username,password,ragioneSociale,telefono,mail,partitaiva,ruolo,abb);
		this.userService.insertUser(uDTO);
		List<UserDTO> users = this.userService.getAllUsers();
		return users;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@CrossOrigin
	public UserDTO loginControl(HttpServletRequest request, Model model ) {
		List<UserDTO> users = userService.getAllUsers();
		String username=request.getParameter("username");
		String password = request.getParameter("password");
	
		for(UserDTO u: users) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
				return u;
			}
		}
		
		
		return null;
		
		
		/*
		model.addAttribute("users", users);
				
		String choice=request.getParameter("choice");
		if(choice != null) {
			switch(choice) {
		
				case "managementUsers":
				
					return "managementUser";
				
				case "insert":
//					users = userService.getAllUsers();
//					model.addAttribute("users", users);
					return "insertUser";
					
				case "update":
					model.addAttribute("user",userService.getUser(Integer.parseInt(request.getParameter("id"))));
//					users = userService.getAllUsers();
//					model.addAttribute("users", users);
					return "updateUser";
				case "delete":
					
					userService.deleteUser(Integer.parseInt((request.getParameter("id"))));
					users = userService.getAllUsers();
					model.addAttribute("users", users);
					return "managementUser";
				case "indietro":
					return "homeCustomers";
				case "indietroManagementUser":
					return "managementUser";
			}
		}
		
		return "managementUser";
		*/
	}
	
	@RequestMapping(value = "/showUsers", method = RequestMethod.GET)
	@CrossOrigin
	public List<UserDTO> userControl() {
		List<UserDTO> users = userService.getAllUsers();
		return users;
	}
	
	
	
	@RequestMapping(value = "/showUsers", method = RequestMethod.POST)
	@CrossOrigin
	public List<UserDTO> loginControlPost(HttpServletRequest request, Model model ) {
		List<UserDTO> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return users;
		/*
		String choice=request.getParameter("choice");
	
		if(choice != null) {
			switch(choice) {
				case "insert":
					String username=request.getParameter("username");
					String password=request.getParameter("password");
					String ragioneSociale=request.getParameter("ragioneSociale");
					String telefono=request.getParameter("telefono");
					String mail=request.getParameter("mail");
					String partitaiva=request.getParameter("partitaiva");
					String ruolo=request.getParameter("ruolo");
					long idAbb=Integer.parseInt(request.getParameter("nomeAbb"));
					AbbonamentoDTO abb=abbonamentoService.findById(idAbb);
					
					UserDTO u=new UserDTO(0,username,password,ragioneSociale,telefono,mail,partitaiva,ruolo,abb);
					
					userService.insertUser(u);
					users = userService.getAllUsers();
					model.addAttribute("users", users);
					return "managementUser";
				case "update":
					long idm=Integer.parseInt(request.getParameter("id"));
					String usernamem=request.getParameter("username");
					String passwordm=request.getParameter("password");
					String ragioneSocialem=request.getParameter("ragioneSociale");
					String telefonom=request.getParameter("telefono");
					String mailm=request.getParameter("mail");
					String partitaivam=request.getParameter("partitaiva");
					String ruolom=request.getParameter("ruolo");
					idAbb=Integer.parseInt(request.getParameter("nomeAbb"));
					abb=abbonamentoService.findById(idAbb);
					UserDTO um=new UserDTO(idm,usernamem,passwordm,ragioneSocialem,telefonom,mailm,partitaivam,ruolom,abb);
					
					userService.insertUser(um);
					users = userService.getAllUsers();
					model.addAttribute("users", users);
					return "managementUser";
			}
			
		}
	
		return "managementUser";
		*/
	}
}