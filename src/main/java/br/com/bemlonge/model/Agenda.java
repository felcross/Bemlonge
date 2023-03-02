package br.com.bemlonge.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Agenda implements Serializable{
	
	static final Logger logger = LogManager.getLogger(Agenda.class.getName());
	
	private static final long serialVersionUID = -5428308336142923133L;
	
	private Integer id;
	private Integer idCompraPasseio;
	private Date data;
	
	public Agenda(){}
	
	public Agenda(Integer id, Integer idCompraPasseio, Date data) {
		this.id = id;
		this.setIdCompraPasseio(idCompraPasseio);
		this.data = data;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public Integer getIdCompraPasseio() {
		return idCompraPasseio;
	}

	public void setIdCompraPasseio(Integer idCompraPasseio) {
		this.idCompraPasseio = idCompraPasseio;
	}
}
