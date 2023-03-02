package br.com.bemlonge.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.model.Passeio;

public class PasseioDTO implements Serializable{
	
	static final Logger logger = LogManager.getLogger(PasseioDTO.class.getName());

	private static final long serialVersionUID = -6787276145368110174L;
	
	private Integer id;
	private String localPartida;
	private String destino;
	private BigDecimal preco;
	private Integer numVagas;
	private String situacao;
	private Integer idGuia;
	private String nomeGuia;

	public String getNomeGuia() {
		return nomeGuia;
	}

	public void setNomeGuia(String nomeGuia) {
		this.nomeGuia = nomeGuia;
	}

	public PasseioDTO() {

	}
	
	public PasseioDTO(int id, String localPartida, String destino, 
			BigDecimal preco, Integer numVagas, String situacao, Integer idGuia) {
		this.id = id;
		this.localPartida = localPartida;
		this.destino = destino;
		this.preco = preco;
		this.numVagas = numVagas;
		this.situacao = situacao;
		this.idGuia = idGuia;
		this.nomeGuia = getNomeGuia();
	}
	
	public PasseioDTO(Object p){
		Passeio passeio = (Passeio) p;
		this.id = passeio.getId();
		this.localPartida = passeio.getLocalPartida();
		this.destino = passeio.getDestino();
		this.preco = passeio.getPreco();
		this.numVagas = passeio.getNumVagas();
		this.situacao = passeio.getSituacao();
		this.idGuia = passeio.getIdGuia();
		this.nomeGuia = passeio.getNomeGuia();
	}

	public PasseioDTO(Integer id, String localPartida, String destino,BigDecimal preco, Integer numVagas, String situacao, Integer idGuia, String nomeGuia) {
		this.id = id;
		this.localPartida = localPartida;
		this.destino = destino;
		this.preco = preco;
		this.numVagas = numVagas;
		this.situacao = situacao;
		this.idGuia = idGuia;
		this.nomeGuia = nomeGuia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocalPartida() {
		return localPartida;
	}

	public void setLocalPartida(String localPartida) {
		this.localPartida = localPartida;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getNumVagas() {
		return numVagas;
	}

	public void setNumVagas(Integer numVagas) {
		this.numVagas = numVagas;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Integer getIdGuia() {
		return idGuia;
	}

	public void setIdGuia(Integer idGuia) {
		this.idGuia = idGuia;
	}

	public Passeio converterParaModel() {
		return new Passeio(this.id, this.localPartida, this.destino,
				this.preco, this.numVagas, this.situacao, this.idGuia,this.nomeGuia);
	}
	
	@Override
	public String toString() {
		return getDestino();
	}

}
