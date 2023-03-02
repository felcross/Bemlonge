package br.com.bemlonge.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.model.Pacote;

public class DetalhesPacoteDTO implements Serializable{
	
	static final Logger logger = LogManager.getLogger(DetalhesPacoteDTO.class.getName());

	private static final long serialVersionUID = 1831193080457871245L;
	
	private Integer id;
	private Integer idPasseio;
	private String descricao;
	private Date dataEmbarque;
	private Date dataDesembarque;
	private BigDecimal preco;
	private Integer vagas;
	private PasseioDTO passeio;
	private BigDecimal precoPasseio;

	public DetalhesPacoteDTO(Pacote pacote) {
		this.id = pacote.getId();
		this.descricao = pacote.getDescricao();
		this.dataEmbarque = pacote.getDataEmbarque();
		this.dataDesembarque = pacote.getDataDesembarque();
		this.preco = pacote.getPreco();
		this.vagas = pacote.getVagas();
		this.passeio = pacote.getPasseio().converterParaDTO();
		this.precoPasseio = pacote.getPasseio().getPreco();
		this.idPasseio = pacote.getPasseio().getId();
	}
	
	public DetalhesPacoteDTO(String descricao, Date dataEmbarque, Date dataDesembarque) {
		this.descricao = descricao;
		this.dataEmbarque = dataEmbarque;
		this.dataDesembarque = dataDesembarque;		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdPasseio() {
		return idPasseio;
	}

	public void setIdPasseio(Integer idPasseio) {
		this.idPasseio = idPasseio;
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

	public PasseioDTO getPasseio() {
		return passeio;
	}

	public void setPasseio(PasseioDTO passeio) {
		this.passeio = passeio;
	}

	public BigDecimal getPrecoPasseio() {
		return precoPasseio;
	}

	public void setPrecoPasseio(BigDecimal precoPasseio) {
		this.precoPasseio = precoPasseio;
	}

	@Override
	public String toString() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String preco = currency.format(getPrecoPasseio());
		return " " + getPasseio() + " " +  preco;
	}
}
