package com.pCarpet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pCarpet.model.User;
import com.pCarpet.services.UserService;

@Controller
@RequestMapping("/HomeUser")
public class HomeUserController {
	
	private UserService userService;
	private boolean isLogged = false;

	@Autowired
	public HomeUserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/showUsers", method = RequestMethod.GET)
	public String loginControl(HttpServletRequest request, Model model ) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
				
		String choice=request.getParameter("choice");
		if(choice != null) {
			switch(choice) {
		
				case "managementUsers":
					return "managementUser";
				
				case "insert":
					users = userService.findAll();
					model.addAttribute("users", users);
					return "insertUser";
					
				case "update":
					model.addAttribute("user",userService.findId(Integer.parseInt(request.getParameter("id"))).get(0));
					users = userService.findAll();
					model.addAttribute("users", users);
					return "updateUser";
				case "delete":
					
					userService.deleteId(Integer.parseInt((request.getParameter("id"))));
					users = userService.findAll();
					model.addAttribute("users", users);
					return "managementUser";
			}
		}
		
		return "managementUser";
	}
	
	

	@RequestMapping(value = "/showUsers", method = RequestMethod.POST)
	public String loginControlPost(HttpServletRequest request, Model model ) {
		System.out.println("TEST1: "+request.getParameter("username"));
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
			
		String choice=request.getParameter("choice");
	
		if(choice != null) {
			switch(choice) {
				case "insert":
					String username=request.getParameter("username");
					String password=request.getParameter("password");
					String nome=request.getParameter("nome");
					String cognome=request.getParameter("cognome");
					String telefono=request.getParameter("telefono");
					String mail=request.getParameter("mail");
					String partitaiva=request.getParameter("partitaiva");
					String ruolo=request.getParameter("ruolo");
					User u=new User(0,username,password,nome,cognome,telefono,mail,partitaiva,ruolo);
					userService.insertUser(u);
					return "managementUser";
				case "update":
					String campo = request.getParameter("campo");
					String nuovoCampo=request.getParameter("nuovoCampo");
					
					
					System.out.println("TEST CAMPO:"+campo);
					System.out.println("TEST NUOVOCAMPO:"+nuovoCampo);
					int iduser=userService.findId(Integer.parseInt(request.getParameter("id"))).get(0).getIduser();
					System.out.println(iduser);
					if(campo.equals("nome"))
						userService.updateNome(iduser,nuovoCampo);
					else if(campo.equals("username"))
						userService.updateUsername(iduser,nuovoCampo);
					else if(campo.equals("password"))
						userService.updatePassword(iduser,nuovoCampo);
					else if(campo.equals("telefono"))
						userService.updateTelefono(iduser,nuovoCampo);
					else if(campo.equals("cognome"))
						userService.updateCognome(iduser,nuovoCampo);
					else if(campo.equals("mail"))
						userService.updateMail(iduser,nuovoCampo);
					else if(campo.equals("partitaiva"))
						userService.updatePartitaIva(iduser,nuovoCampo);
					else if(campo.equals("ruolo"))
						userService.updateRuolo(iduser,nuovoCampo);
					return "managementUser";
			}
		}
	
		return "managementUser";
	}
}
