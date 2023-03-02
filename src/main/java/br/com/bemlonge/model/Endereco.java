package br.com.bemlonge.model;

import java.io.Serializable;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dto.EnderecoDTO;

public class Endereco implements Serializable{
	
	static final Logger logger = LogManager.getLogger(Endereco.class.getName());

	private static final long serialVersionUID = -5489696639583887921L;
	
	private int id;
	private String logradouro;
	private String bairro;
	private String cep;
	private String uf;

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
	
	public EnderecoDTO converterParaDTO() {
		EnderecoDTO enderecoDto = new EnderecoDTO();
		enderecoDto.setId(this.id);
		enderecoDto.setLogradouro(this.logradouro);
		enderecoDto.setBairro(this.bairro);
		enderecoDto.setCep(this.cep);
		enderecoDto.setUf(this.uf);
		return enderecoDto;
	}	
}
