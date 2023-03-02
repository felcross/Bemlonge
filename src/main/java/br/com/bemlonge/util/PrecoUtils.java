package br.com.bemlonge.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class PrecoUtils {
	
	static final Logger logger = LogManager.getLogger(PrecoUtils.class.getName());
	
	public static String retornarPrecoPacote(String numero) {
		if(numero.equals("1")) {
			return "1000";
		} else if(numero.equals("2")) {
			return "2000";
		} else {
			return "1000";
		}
	}
	
	public static String retornarPrecoPasseio(String numero) {
		if(numero.equals("1")) {
			return "100";
		} else if(numero.equals("2")){
			return "200";
		} else if(numero.equals("3")) {
			return "300";
		} else if(numero.equals("4")) {
			return "500";
		}else {
			return "1000";
		}
		
	}

}
