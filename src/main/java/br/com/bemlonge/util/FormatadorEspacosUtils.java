package br.com.bemlonge.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class FormatadorEspacosUtils {
	
	static final Logger logger = LogManager.getLogger(FormatadorEspacosUtils.class.getName());
	
	public String removerCaracteres(String caracter) {
		String caracterFormatado = caracter.replaceAll("[\\D]","");
		return caracterFormatado;
	}
}
