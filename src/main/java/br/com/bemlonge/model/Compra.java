package br.com.bemlonge.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Compra implements Serializable{
	
	static final Logger logger = LogManager.getLogger(Compra.class.getName());

	private static final long serialVersionUID = 838263413331192525L;
	
	private Integer id;
	private Integer idCliente;
	private Date dataCompra;
	
	public Compra(Integer id, Integer idCliente, Date dataCompra) {		
		this.id = id;
		this.idCliente = idCliente;
		this.dataCompra = dataCompra;
	}

	public Compra(Integer id, Integer id_cliente) {		
		this.id = id;
		this.idCliente = id_cliente;
		this.dataCompra = new Date();
	}

	public Compra(Integer id_cliente) {
		this.idCliente = id_cliente;
		this.dataCompra = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	
}
