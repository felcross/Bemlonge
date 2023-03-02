package br.com.bemlonge.enums;

public enum MesesEnum {
	JAN(0, "Jan", "Janeiro"),
	FEV(1, "Fev", "Fevereiro"),
	MAR(2, "Mar", "Março"),
	ABR(3, "Abr", "Abril"),
	MAI(4, "Mai", "Maio"),
	JUN(5, "Jun", "Junho"),
	JUL(6, "Jul", "Julho"),
	AGO(7, "Ago", "Agosto"),
	SET(8, "Set", "Setembro"),
	OUT(9, "Out", "Outubro"),
	NOV(10, "Nov", "Novembro"),
	DEZ(11, "Dez", "Dezembro");
	
	/*
	* Construtor da enum
	*/
	private MesesEnum(int codigoMes, String mesAbreviado, String nomeMesCompleto){
		this.codigoMes = codigoMes;
		this.mesAbreviado = mesAbreviado;
		this.nomeMesCompleto = nomeMesCompleto;
	}
	
	/*Campos*/
	private int codigoMes;
	private String mesAbreviado;
	private String nomeMesCompleto;
	
	public int getCodigoMes(){
		return this.codigoMes;
	}
	
	public String getMesAbreviado(){
		return this.mesAbreviado;
	}
	
	public String getNomeMesCompleto(){
		return this.nomeMesCompleto;
	}
}