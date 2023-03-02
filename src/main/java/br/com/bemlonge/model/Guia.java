package br.com.bemlonge.model;

import java.io.Serializable;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class Guia implements Serializable{
	
	static final Logger logger = LogManager.getLogger(Guia.class.getName());

	private static final long serialVersionUID = -2003884312852830472L;
	
	private Integer id;
	private String cpf;
	private String nome;

	public Guia(){
		
	}
	
	public Guia(Integer id, String cpf, String nome) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}
}
