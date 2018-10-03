package com.virtualpairprogrammers.services;

import java.util.List;

import com.virtualpairprogrammers.dao.BadgeDAO;
import com.virtualpairprogrammers.dao.MovimentoDAO;
import com.virtualpairprogrammers.domain.Badge;
import com.virtualpairprogrammers.domain.Movimento;

public class MovimentoService {

    private MovimentoDAO movimentoDAO;
	private Object badgeDAO;
	private Object badgereaderDAO;

    public MovimentoService() {
        this.movimentoDAO = new MovimentoDAO();
    }
    public List<Badge> getAllBadges () {
        return ((BadgeDAO) this.badgeDAO).getAllBadges();
    }
    public List<Movimento> getAllMovimenti () {
        return this.movimentoDAO.getAllMovimenti();
    }
  /*  public List<BadgeReader> getAllBadgeReaders () {
        return (((BadgeReaderDAO) this.badgeReaderDAO).getBadgeReaders());
    }
*/
    public boolean insertMovimento (Movimento movimento) {
        return this.movimentoDAO.insertMovimento(movimento);
    }
    
    public boolean deleteMovimento (int idBadgeReader, int idBadge, String datainizio) {
        return this.movimentoDAO.deleteMovimento(idBadgeReader, idBadge, datainizio);
    }
}
