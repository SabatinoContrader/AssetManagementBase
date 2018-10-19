package com.pCarpet.converter;

import com.pCarpet.dto.MovimentoDTO;
import com.pCarpet.model.Movimento;

public class MovimentoConverter {

	
	
	public static MovimentoDTO convertToDTO(Movimento m) {
		
		MovimentoDTO mDTO=new MovimentoDTO();
		mDTO.setIdbadge(m.getIdbadge());
		mDTO.setIdbadgereader(m.getIdbadgereader());
		mDTO.setOrainizio(m.getOrainizio());
		mDTO.setOrafine(m.getOrafine());
		
		return mDTO;
		
	}
	
}
