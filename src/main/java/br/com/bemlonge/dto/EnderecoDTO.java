package br.com.bemlonge.dto;

import java.io.Serializable;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.model.Endereco;

public class EnderecoDTO implements Serializable{
	
	static final Logger logger = LogManager.getLogger(EnderecoDTO.class.getName());
	
	private static final long serialVersionUID = 3408175756431143801L;
	
	private int id;
	private String logradouro;
	private String bairro;
	private String cep;
	private String uf;
	
	public EnderecoDTO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Endereco converterParaModel() {
		Endereco endereco = new Endereco();
		endereco.setId(this.id);
		endereco.setLogradouro(this.logradouro);
		endereco.setBairro(this.bairro);
		endereco.setCep(this.cep);
		endereco.setUf(this.uf);
		return endereco;
	}
	
}
