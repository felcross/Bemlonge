package br.com.bemlonge.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dto.GuiaDTO;
import br.com.bemlonge.model.Guia;

public class GuiaConverter {
	
	static final Logger logger = LogManager.getLogger(GuiaConverter.class.getName());

	public static List<GuiaDTO> converterParaDTO(List<Guia> guias) {

		List<GuiaDTO> guiaDto = new ArrayList<GuiaDTO>();
		for (Guia g : guias) {
			GuiaDTO guia = new GuiaDTO(g);
			guiaDto.add(guia);
		}

		return guiaDto;
	}

}
