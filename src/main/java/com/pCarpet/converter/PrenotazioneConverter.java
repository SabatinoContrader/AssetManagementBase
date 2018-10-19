package com.pCarpet.converter;

import com.pCarpet.dto.PrenotazioneDTO;
import com.pCarpet.model.Asset;
import com.pCarpet.model.Prenotazione;
import com.pCarpet.model.User;

public class PrenotazioneConverter{

	public static Prenotazione converToEntity(PrenotazioneDTO dto) {
		Prenotazione p=new Prenotazione();
		
		p.setOrainizio(dto.getOrainizio());
		p.setOrafine(dto.getOrafine());
		p.setIduser(dto.getIduser());
		p.setIdasset(dto.getIdasset());
		
		return p;
	}

	
	public static PrenotazioneDTO covertToDTO(Prenotazione entity) {
		
		PrenotazioneDTO prenDTO=new PrenotazioneDTO();
		
		prenDTO.setOrainizio(entity.getOrainizio());
		prenDTO.setOrafine(entity.getOrafine());
		prenDTO.setIdasset(entity.getIdasset());
		prenDTO.setIduser(entity.getIduser());
		
		return prenDTO;
		
	}
	
	
	//1 DTO e 3 Entity
	public static PrenotazioneDTO covertToDTO(Prenotazione pren,User user, Asset asset) {
		
		PrenotazioneDTO prenDTO=new PrenotazioneDTO();
		
		prenDTO.setOrainizio(pren.getOrainizio());
		prenDTO.setOrafine(pren.getOrafine());
		prenDTO.setIdasset(pren.getIdasset());
		prenDTO.setIduser(pren.getIduser());
		
//		prenDTO.setIdUser2(user.getIduser());
//		prenDTO.setUsername(user.getUsername());
//		prenDTO.setRagioneSociale(user.getRagioneSociale());
//		prenDTO.setPartitaiva(user.getPartitaiva());
//		prenDTO.setFlag(user.getFlag());
//		
//		prenDTO.setIdAsset2(asset.getIdAsset());
//		prenDTO.setDescrizione(asset.getDescrizione());
//		prenDTO.setTipo(asset.getTipo());
//		prenDTO.setPrezzo(asset.getPrezzo());
		
		
		return prenDTO;
		
	}

	
	
}
