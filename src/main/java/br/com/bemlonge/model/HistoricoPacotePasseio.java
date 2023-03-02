package br.com.bemlonge.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dto.HistoricoClienteDTO;
import br.com.bemlonge.enums.TipoPagamentoEnum;

public class HistoricoPacotePasseio implements Serializable{
	
	static final Logger logger = LogManager.getLogger(HistoricoPacotePasseio.class.getName());
	
	private static final long serialVersionUID = -8958704978164586976L;
	
	private int ordem;
	private String cpf;
	private TipoPagamentoEnum tipo;
	private BigDecimal valorAPagar;
	private Date dataEmbarque;
	private Date dataCompra;
	private String descricao;
	private int numeroParcelas;
		
	public HistoricoPacotePasseio() {
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public TipoPagamentoEnum getTipo() {
		return tipo;
	}
	public void setTipo(TipoPagamentoEnum tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getValorAPagar() {
		return valorAPagar;
	}
	public void setValorAPagar(BigDecimal valorAPagar) {
		this.valorAPagar = valorAPagar;
	}
	public Date getDataEmbarque() {
		return dataEmbarque;
	}
	public void setDataEmbarque(Date dataEmbarque) {
		this.dataEmbarque = dataEmbarque;
	}
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getOrdem() {
		return ordem;
	}
	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public int getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(int numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}
	
	public void converterDTO(HistoricoClienteDTO dto){
		this.ordem = dto.getOrdem();
		this.cpf = dto.getCpf();
		this.dataCompra = dto.getDataCompra();
		this.dataEmbarque = dto.getDataEmbarque();
		this.descricao = dto.getDescricao();
		this.numeroParcelas = dto.getNumeroParcelas();
		this.tipo = dto.getTipo();
		this.valorAPagar = dto.getValorAPagar();
	}
	
}
