package com.pCarpet.dao;

import com.pCarpet.model.User;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long>
{		
	
	
		User findByUsernameAndPassword(String username,String password);
	
		User save(User user);	
		boolean existsByUsername(String username);

		
		@Modifying
		@Query("SELECT u FROM User u WHERE u.iduser=?1")
	    List<User> findId(int id);
		
		
		@Modifying
		@Query("DELETE FROM User WHERE iduser=?1")
		void deleteId(int id);
		
		
		@Modifying
		@Query("UPDATE User set nome = ?2 where iduser=?1")
		void updateNome(int id, String nuovoCampo);
		
		@Modifying
		@Query("UPDATE User set cognome = ?2 where iduser=?1")
		void updateCognome(int id, String nuovoCampo);
		
		@Modifying
		@Query("UPDATE User set username = ?2 where iduser=?1")
		void updateUsername(int id, String nuovoCampo);
		
		@Modifying
		@Query("UPDATE User set password = ?2 where iduser=?1")
		void updatePassword(int id, String nuovoCampo);
		
		@Modifying
		@Query("UPDATE User set telefono = ?2 where iduser=?1")
		void updateTelefono(int id, String nuovoCampo);
		
		@Modifying
		@Query("UPDATE User set mail = ?2 where iduser=?1")
		void updateMail(int id, String nuovoCampo);
		
		@Modifying
		@Query("UPDATE User set partitaiva = ?2 where iduser=?1")
		void updatePartitaIva(int id, String nuovoCampo);
		
		@Modifying
		@Query("UPDATE User set ruolo = ?2 where iduser=?1")
		void updateRuolo(int id, String nuovoCampo);


}
