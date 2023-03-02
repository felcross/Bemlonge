package br.com.bemlonge.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dto.DetalhesPacoteDTO;
import br.com.bemlonge.dto.PacoteDTO;

public class Pacote implements Serializable{
	
	static final Logger logger = LogManager.getLogger(Pacote.class.getName());

	private static final long serialVersionUID = 764500426443145431L;
	
	private Integer id;
	private String descricao;
	private Date dataEmbarque;
	private Date dataDesembarque;
	private Passeio passeio;
	private BigDecimal preco;
	private Integer vagas;
	private Integer vagasPreenchidas;

	public Pacote(String descricao, Date dataEmbarque, Date dataDesembarque) {
		this.descricao = descricao;
		this.dataEmbarque = dataEmbarque;
		this.dataDesembarque = dataDesembarque;
	}

	public Pacote(Integer id, String descricao, Date dataEmbarque,
			Date dataDesembarque) {
		this.id = id;
		this.descricao = descricao;
		this.dataEmbarque = dataEmbarque;
		this.dataDesembarque = dataDesembarque;
	}

	public Pacote() {

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

	public Passeio getPasseio() {
		return passeio;
	}

	public void setPasseio(Passeio passeio) {
		this.passeio = passeio;
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

	public Integer getVagasPreenchidas() {
		return vagasPreenchidas;
	}

	public void setVagasPreenchidas(Integer vagasPreenchidas) {
		this.vagasPreenchidas = vagasPreenchidas;
	}

	public PacoteDTO converterParaDTO() {
		return new PacoteDTO();
	}

	public DetalhesPacoteDTO converterParaDetalhesPacoteDTO() {
		return new DetalhesPacoteDTO(this.descricao, this.dataEmbarque,
				this.dataDesembarque);
	}

	@Override
	public String toString() {
		return descricao;
	}

}
