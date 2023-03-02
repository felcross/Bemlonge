package br.com.bemlonge.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dto.PasseioDTO;
import br.com.bemlonge.model.Passeio;

public class PasseioConverter {
	
	static final Logger logger = LogManager.getLogger(PasseioConverter.class.getName());
	
	public static List<PasseioDTO> converterParaDTO(List<Passeio> passeios){
		
		List<PasseioDTO> passeiosDto = new ArrayList<PasseioDTO>();
		for (Passeio p : passeios) {
			PasseioDTO passeio = new PasseioDTO(p);
			passeiosDto.add(passeio);
		}

		return passeiosDto;
	}
	
public static PasseioDTO filtrarDTO(Passeio passeio) {
		PasseioDTO passeioID = new PasseioDTO(passeio);
		return passeioID;
	}
	
	
}
