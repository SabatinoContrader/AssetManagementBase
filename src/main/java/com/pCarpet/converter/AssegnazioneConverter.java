package com.pCarpet.converter;

import com.pCarpet.dto.AssegnazioneDTO;
import com.pCarpet.model.Assegnazione;
import com.pCarpet.model.Badge;
import com.pCarpet.model.User;

public class AssegnazioneConverter {

	
	public static Assegnazione converToEntity(AssegnazioneDTO aDTO) {

		Assegnazione a=new Assegnazione();
		a.setIduser(aDTO.getIduser());
		a.setIdbadge(aDTO.getIdbadge());
		a.setNome(aDTO.getNome());
		a.setCognome(aDTO.getCognome());
		a.setDataassegnazione(aDTO.getDataassegnazione());
		
		
		return a;
	}
	

	
	public static AssegnazioneDTO convertToDTO(Assegnazione a) {
		
		AssegnazioneDTO aDTO=new AssegnazioneDTO();
		
		aDTO.setIduser(a.getIduser());
		aDTO.setIdbadge(a.getIdbadge());
		aDTO.setNome(a.getNome());
		aDTO.setCognome(a.getCognome());
		aDTO.setDataassegnazione(a.getDataassegnazione());
		
		
		return aDTO;
		
	}
	
	
//	public static AssegnazioneDTO convertToDTO(Assegnazione a, User u, Badge b) {
//		
//		AssegnazioneDTO aDTO=new AssegnazioneDTO();
//		
//		aDTO.setIduser(a.getIdUtente());
//		aDTO.setIdbadge(a.getIdBadge());
//		aDTO.setNome(a.getNome());
//		aDTO.setCognome(a.getCognome());
//		aDTO.setDataassegnazione(a.getDataassegnazione());
//		
//		aDTO.setIdUser(u.getIduser());
//		aDTO.setUsername(u.getUsername());
//		aDTO.setRagioneSociale(u.getRagioneSociale());
//		aDTO.setPartitaiva(u.getPartitaiva());
//		aDTO.setFlag(u.getFlag());
//		
//		aDTO.setIdBadge(b.getIdBadge());
//		aDTO.setDescrizione(b.getDescrizione());
//		aDTO.setTipologia(b.getTipologia());
//		
//		return aDTO;
//		
//	}
	
	
	
	
}
