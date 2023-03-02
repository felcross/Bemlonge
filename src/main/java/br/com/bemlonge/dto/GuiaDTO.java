package br.com.bemlonge.dto;

import java.io.Serializable;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.model.Guia;

public class GuiaDTO implements Serializable{
	
	static final Logger logger = LogManager.getLogger(GuiaDTO.class.getName());

	private static final long serialVersionUID = -7085912884314374890L;
	
	private Integer id;
	private String cpf;
	private String nome;
	private Boolean resultado; 
	private Boolean validacaoCpf;

	public GuiaDTO() {	
	}
	
	public GuiaDTO(Object obj){
		Guia guia = (Guia) obj;
		this.id = guia.getId();
		this.cpf = guia.getCpf();
		this.nome = guia.getNome();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	public Guia converterParaGuia() {
		return new Guia(this.id, this.cpf,
				this.nome);
	}

	@Override
	public String toString() {
		return getNome();
	}

	public Boolean getResultado() {
		return resultado;
	}

	public void setResultado(Boolean resultado) {
		this.resultado = resultado;
	}

	public Boolean getValidacaoCpf() {
		return validacaoCpf;
	}

	public void setValidacaoCpf(Boolean validacaoCpf) {
		this.validacaoCpf = validacaoCpf;
	}
	
	
}