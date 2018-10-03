package com.virtualpairprogrammers.services;

import com.virtualpairprogrammers.servlets.Request;
import com.virtualpairprogrammers.dao.BadgeDAO;
import com.virtualpairprogrammers.domain.Badge;

import java.util.List;
public class BadgeService {
	 private BadgeDAO badgeDAO;

	    public BadgeService() {
	        this.badgeDAO = new BadgeDAO();
	    }

	    public List<Badge> getAllBadges () {
	        return this.badgeDAO.getAllBadges();
	    }

	    public boolean insertBadge (Badge badge) {
	        return this.badgeDAO.insertBadge(badge);
	    }
	    public boolean deleteBadge (int idBadge) {
	    	return this.badgeDAO.DeleteBadge(idBadge);
	    }
	    
	    public boolean updateBadge(Request request) {
	    	return this.badgeDAO.UpdateBadge(request);
	    }
	}
