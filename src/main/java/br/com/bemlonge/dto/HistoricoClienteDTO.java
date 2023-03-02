package br.com.bemlonge.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.enums.MesesEnum;
import br.com.bemlonge.enums.TipoPagamentoEnum;
import br.com.bemlonge.model.HistoricoPacotePasseio;
import br.com.bemlonge.util.DataUtils;

public class HistoricoClienteDTO implements Comparable<HistoricoClienteDTO>, Serializable {
	
	static final Logger logger = LogManager.getLogger(HistoricoClienteDTO.class.getName());

	private static final long serialVersionUID = 5790369052172691262L;
	
	private int ordem;
	private String cpf;
	private TipoPagamentoEnum tipo;
	private BigDecimal valorAPagar;
	private Date dataEmbarque;
	private Date dataCompra;
	private String descricao;
	private MesesEnum mes;
	private int numeroParcelas;
		
	public HistoricoClienteDTO() {
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoricoClienteDTO other = (HistoricoClienteDTO) obj;
		if (dataCompra == null) {
			if (other.dataCompra != null)
				return false;
		} else if (!dataCompra.equals(other.dataCompra))
			return false;
		return true;
	}

	@Override
	public int compareTo(HistoricoClienteDTO o) {
		return getDataCompra().compareTo(o.getDataCompra());
	}

	public String getMes() {
		return mes.getNomeMesCompleto();
	}

	public void setMes(MesesEnum mes) {
		this.mes = mes;
	}

	public int getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(int numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}
	
	public void converterModel(HistoricoPacotePasseio historico){
		DataUtils data = new DataUtils();
		this.cpf = historico.getCpf();
		this.dataCompra = historico.getDataCompra();
		this.dataEmbarque = historico.getDataEmbarque();
		this.descricao = historico.getDescricao();
		this.mes = data.converterParaMes(historico.getDataCompra());
		this.numeroParcelas = historico.getNumeroParcelas();
		this.ordem = historico.getOrdem();
		this.tipo = historico.getTipo();
		this.valorAPagar = historico.getValorAPagar();
	}
	
}
