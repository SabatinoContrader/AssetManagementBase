package com.virtualpairprogrammers.services;

import java.util.List;

import com.virtualpairprogrammers.servlets.Request;
import com.virtualpairprogrammers.dao.AssetDAO;
import com.virtualpairprogrammers.dao.BadgeReaderDAO;
import com.virtualpairprogrammers.domain.Asset;
import com.virtualpairprogrammers.domain.BadgeReader;

public class BadgeReaderService {

	private BadgeReaderDAO badgeReaderDAO;

    public BadgeReaderService() {
        this.badgeReaderDAO = new BadgeReaderDAO();
    }

    public List<BadgeReader> getAllBadgeReaders () {
        return this.badgeReaderDAO.getAllBadgeReaders();
    }
    
    public List<BadgeReader> getAllBadgeReadersIdAsset (int idAsset) {
        return this.badgeReaderDAO.getAllBadgeReadersIdAsset(idAsset);
    }

    public boolean insertBadgeReader (BadgeReader badgeReader) {
        return this.badgeReaderDAO.insertBadgeReader(badgeReader);
    }
    public boolean deleteBadgeReadear (int idBadgeReader) {
    	return this.badgeReaderDAO.deleteBadgeReadear(idBadgeReader);
    }
    
    public boolean updateBadgeReader(Request request) {
    	return this.badgeReaderDAO.updateBadgeReader(request);
    }
	
}
