package br.com.bemlonge.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.enums.TipoPagamentoEnum;

public class Pagamento implements Serializable{
	
	static final Logger logger = LogManager.getLogger(Pagamento.class.getName());

	private static final long serialVersionUID = -2767021815242301323L;
	
	private Integer id;
	private TipoPagamentoEnum tipo;
	private Integer numeroParcelas;
	private Integer parcelaPaga;
	private Date dataVencimento;
	private Date dataPagamento;
	private BigDecimal valorAPagar;
	private BigDecimal valorPago;
	private Integer idCompra;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoPagamentoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoPagamentoEnum tipo) {
		this.tipo = tipo;
	}

	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

	public Integer getParcelaPaga() {
		return parcelaPaga;
	}

	public void setParcelaPaga(Integer parcelaPaga) {
		this.parcelaPaga = parcelaPaga;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getValorAPagar() {
		return valorAPagar;
	}

	public void setValorAPagar(BigDecimal valorAPagar) {
		this.valorAPagar = valorAPagar;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

}
