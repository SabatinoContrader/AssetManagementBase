package com.pCarpet.dao;

import com.pCarpet.utils.ConnectionSingleton;
import com.pCarpet.utils.GestoreEccezioni;
import com.pCarpet.model.Assegnazione;
import com.pCarpet.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AssegnaRepository extends CrudRepository<Assegnazione, Long> {
	
}
