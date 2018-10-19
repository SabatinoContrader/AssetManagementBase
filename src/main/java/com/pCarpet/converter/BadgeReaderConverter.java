package com.pCarpet.converter;

import com.pCarpet.dto.BadgeReaderDTO;
import com.pCarpet.model.Asset;
import com.pCarpet.model.BadgeReader;

public class BadgeReaderConverter {

	public static BadgeReader converToEntity(BadgeReaderDTO badgeReaderDTO) {

		BadgeReader br=new BadgeReader();
		br.setIdAsset(badgeReaderDTO.getIdAsset());
		br.setIdBadgeReader(badgeReaderDTO.getIdBadgeReader());
		br.setDescrizione(badgeReaderDTO.getDescrizione());
		br.setTipologia(badgeReaderDTO.getTipologia());
		
		
		return br;
	}
	
	
	public static BadgeReaderDTO convertToDTO(BadgeReader br) {
		
		BadgeReaderDTO brDTO=new BadgeReaderDTO();
		brDTO.setIdAsset(br.getIdAsset());
		brDTO.setIdBadgeReader(br.getIdBadgeReader());
		brDTO.setDescrizione(br.getDescrizione());
		brDTO.setTipologia(br.getTipologia());
		
		return brDTO;
		
	}
	
	
	public static BadgeReaderDTO convertToDTO(BadgeReader br, Asset a) {
		
		BadgeReaderDTO brDTO=new BadgeReaderDTO();
		
		brDTO.setIdAsset(br.getIdAsset());
		brDTO.setIdBadgeReader(br.getIdBadgeReader());
		brDTO.setDescrizione(br.getDescrizione());
		brDTO.setTipologia(br.getTipologia());
		
		brDTO.setIdAsset2(a.getIdAsset());
		brDTO.setDescrizione2(a.getDescrizione());
		brDTO.setTipo2(a.getTipo());
		brDTO.setPrezzo2(a.getPrezzo());
		
		return brDTO;
		
	}
	
}
