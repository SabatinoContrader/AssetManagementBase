package com.pCarpet.controller;


import com.pCarpet.dto.BadgeDTO;
import com.pCarpet.dto.UserDTO;
import com.pCarpet.services.BadgeService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;






@RestController
@CrossOrigin
@RequestMapping("/Badge")
public class BadgeController {

	private BadgeService badgeService;
    private List<BadgeDTO> listBadges;
	private  BadgeDTO l;
	private List<BadgeDTO> x;
 

	
	@Autowired
	public BadgeController(BadgeService badgeService) {
		this.badgeService = badgeService;
	}
	
	
	@RequestMapping(value = "/showBadges", method = RequestMethod.GET)
	public List<BadgeDTO> getAllBadges(HttpServletRequest request, Model model ) {
		return this.badgeService.getAllBadges();
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public List<BadgeDTO> deleteControl(HttpServletRequest request, Model model ) {
		int id=Integer.parseInt(request.getParameter("id"));
		this.badgeService.deleteBadge(id);
		List<BadgeDTO> badges = badgeService.getAllBadges();
		return badges;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public List<BadgeDTO> modifyControl(HttpServletRequest request, Model model ) {
		long id=Integer.parseInt(request.getParameter("idbadge"));
		String tipologia=request.getParameter("tipologia");
		String descrizione=request.getParameter("descrizione");
		BadgeDTO badgeDTO = new BadgeDTO(id,descrizione,tipologia,1);
		this.badgeService.insertBadge(badgeDTO);
		List<BadgeDTO> badges = badgeService.getAllBadges();
		return badges;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public List<BadgeDTO> insertControl(HttpServletRequest request, Model model ) {
		long id=0;
		String tipologia=request.getParameter("tipologia");
		String descrizione=request.getParameter("descrizione");
		BadgeDTO badgeDTO = new BadgeDTO(id,descrizione,tipologia,1);
		this.badgeService.insertBadge(badgeDTO);
		List<BadgeDTO> badges = badgeService.getAllBadges();
		return badges;
	}
	
	
	@RequestMapping(value = "/HomeBadge", method = RequestMethod.GET)
	public String getBadges(HttpServletRequest request, Model model ) {
		/*
		List<BadgeDTO> badges = badgeService.getAllBadges();
		model.addAttribute("badges", badges);

		String scelta= request.getParameter("scelta");
		
		if(scelta != null) {
			switch(scelta) {
			case "badgemanagement":
				return "badgeManagement";
			case "insert":
				return "addBadge";
				
			case "update":
				return "modificaBadge";
			case "delete":
				
				badgeService.deleteBadge(Integer.parseInt((request.getParameter("id"))));
				badges = badgeService.getAllBadges();
				model.addAttribute("badges", badges);
				return "badgeManagement";
			case "indietro":
				return "homeCustomers";
			case "indietrobadgemanagement":
				return "badgeManagement";
		}
	}
	
	return "badgeManagement";
	*/
		return "";
}


	@RequestMapping(value = "/removeBadge", method = RequestMethod.GET)
	public String removeBadge(@RequestParam("id") int idbadge, Model model ) 
	{
		BadgeDTO badge = badgeService.getBadge(idbadge);
		return "badgeManagement";}
	
	@RequestMapping(value ="/modificaBadgeRedirect",method = RequestMethod.GET)
	public String modifiedredirectBadge(HttpServletRequest request, Model model )
	{
		int id=Integer.parseInt(request.getParameter("id"));
		l = badgeService.getBadge(id);
		request.setAttribute("id1", id);
		model.addAttribute("badge", l);
		return "modificaBadge";
	}
	
	@RequestMapping(value = "/addBadge", method = RequestMethod.POST)
	public String addedBadge(HttpServletRequest request, Model model ) {
		String descrizione = request.getParameter("descrizione");
		String tipologia = request.getParameter("tipologia");
		
		BadgeDTO badge = new BadgeDTO(0, descrizione, tipologia,1l);
		badge.setIdBadge(0);
		badge.setDescrizione(descrizione);
		badge.setTipologia(tipologia);
		badgeService.insertBadge(badge);
		List<BadgeDTO> badges = badgeService.getAllBadges();
		model.addAttribute("badges", badges);
		return "badgeManagement";
	}

@RequestMapping(value = "/modificaBadge", method = RequestMethod.POST)
public String modifiedBadge(HttpServletRequest request, Model model )
{
	long id=Integer.parseInt(request.getParameter("id"));
	String descrizione = request.getParameter("descrizione");
	String tipologia = request.getParameter("tipologia");
	BadgeDTO badge = new BadgeDTO(id, descrizione, tipologia,1l);
	badgeService.insertBadge(badge);
	List<BadgeDTO> badges = badgeService.getAllBadges();
	model.addAttribute("badges", badges);
	return "badgeManagement";
 }
}
