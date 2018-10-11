package com.pCarpet.controller;

import com.pCarpet.dto.ManagementExtensionStopDTO;
import com.pCarpet.model.User;
import com.pCarpet.services.UserService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/Asset")
public class AssetController {

	private UserService userService;

	@Autowired
	public AssetController(UserService userService) {
		this.userService = userService;
	}
	

	
	@RequestMapping(value = "/assetDirectory", method = RequestMethod.GET)
	public String AsseBad(HttpServletRequest request) {
		String scelta= request.getParameter("scelta");
		if (scelta.equals("insert"))
			return "insertAsset";
		else if (scelta.equals("update"))
			return "updateAsset";
		else if (scelta.equals("indietro"))
			return "homeAssBadRead";
		else
			return "";
	}
	
	

}