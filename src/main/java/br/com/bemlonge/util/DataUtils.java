package br.com.bemlonge.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.enums.MesesEnum;


public class DataUtils {
	
	static final Logger logger = LogManager.getLogger(DataUtils.class.getName());
	
	public String formatarData(Date data) {
		SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
		String dataFormatada = formatador.format(data);
		return dataFormatada;
	}
	

	public static String formatarDataEHora(Date data) {
		SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String dataFormatada = formatador.format(data);
		return dataFormatada;
	}
	
	public Date converterParaData(String data) throws ParseException {
		SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
		Date dataConvertida = (Date) formatador.parse(data);
		java.sql.Date sqlDate = new java.sql.Date(dataConvertida.getTime());
		return sqlDate;
	}
	
	public MesesEnum converterParaMes(Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		MesesEnum mes = converterMesString(calendar.get(Calendar.MONTH));		
		return mes;
		
	}
	
	public MesesEnum converterMesString (int i){		
		MesesEnum mes = null;

		if (i==0){
			mes = MesesEnum.JAN;
		} else if (i==1){
			mes = MesesEnum.FEV;
		} else if (i==2){
			mes = MesesEnum.MAR;
		} else if (i==3){
			mes = MesesEnum.ABR;
		} else if (i==4){
			mes = MesesEnum.MAI;
		} else if (i==5){
			mes = MesesEnum.JUN;
		} else if (i==6){
			mes = MesesEnum.JUL;
		} else if (i==7){
			mes = MesesEnum.AGO;
		} else if (i==8){
			mes = MesesEnum.SET;
		} else if (i==9){
			mes = MesesEnum.OUT;
		} else if (i==10){
			mes = MesesEnum.NOV;
		} else if (i==11){
			mes = MesesEnum.DEZ;
		} 
		return mes;
	}
	
}
