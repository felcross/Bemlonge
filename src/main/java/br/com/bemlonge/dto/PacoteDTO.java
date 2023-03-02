package br.com.bemlonge.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.model.Pacote;

public class PacoteDTO implements Serializable{
	
	static final Logger logger = LogManager.getLogger(PacoteDTO.class.getName());

	private static final long serialVersionUID = -8235225035823393708L;
	
	private Integer id;
	private String descricao;
	private Date dataEmbarque;
	private Date dataDesembarque;
	private BigDecimal preco;
	private Integer vagas;

	public PacoteDTO(Pacote pacote) {
		this.id = pacote.getId();
		this.descricao = pacote.getDescricao();
		this.dataEmbarque = pacote.getDataEmbarque();
		this.dataDesembarque = pacote.getDataDesembarque();
		this.preco = pacote.getPreco();
		this.vagas = pacote.getVagas();
	}

	public PacoteDTO(Pacote pacote, Boolean semPreco) {
		this.id = pacote.getId();
		this.descricao = pacote.getDescricao();
		this.dataEmbarque = pacote.getDataEmbarque();
		this.dataDesembarque = pacote.getDataDesembarque();
	}

	public PacoteDTO() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataEmbarque() {
		return dataEmbarque;
	}

	public void setDataEmbarque(Date dataEmbarque) {
		this.dataEmbarque = dataEmbarque;
	}

	public Date getDataDesembarque() {
		return dataDesembarque;
	}

	public void setDataDesembarque(Date dataDesembarque) {
		this.dataDesembarque = dataDesembarque;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getVagas() {
		return vagas;
	}

	public void setVagas(Integer vagas) {
		this.vagas = vagas;
	}

	public Pacote converterParaPacote() {
		return new Pacote(this.id, this.descricao, this.dataEmbarque,
				this.dataDesembarque);
	}

	@Override
	public String toString() {
		return descricao;
	}
}
