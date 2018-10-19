package com.pCarpet.converter;

import com.pCarpet.dto.BadgeDTO;
import com.pCarpet.model.Badge;

public class BadgeConverter {

	public static Badge converToEntity(BadgeDTO badgeDTO) {

		Badge b=new Badge();
		b.setIdBadge(badgeDTO.getIdBadge());
		b.setTipologia(badgeDTO.getTipologia());
		b.setDescrizione(badgeDTO.getDescrizione());
		
		
		return b;
	}
	
	
	public static BadgeDTO convertToDTO(Badge b) {
		
		BadgeDTO bDTO=new BadgeDTO();
		bDTO.setIdBadge(b.getIdBadge());
		bDTO.setTipologia(b.getTipologia());
		bDTO.setDescrizione(b.getDescrizione());
		
		return bDTO;
		
	}
	
}
