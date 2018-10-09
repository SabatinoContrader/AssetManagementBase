package com.pCarpet.dao;

import com.pCarpet.model.Report;
import com.pCarpet.model.User;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface ReportRepository extends CrudRepository<Report, Long>
{		
	Report findByUserUsername(String username);
	
	Report save(Report report);	
	
	List<Report> findAll();
	
	List<Report> findByUser(User user);
		

}
