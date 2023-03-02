package br.com.bemlonge.action;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dto.ClienteDTO;
import br.com.bemlonge.dto.PacoteDTO;
import br.com.bemlonge.dto.PasseioDTO;
import br.com.bemlonge.enums.TipoPagamentoEnum;
import br.com.bemlonge.exception.CompraException;
import br.com.bemlonge.exception.PagamentoException;
import br.com.bemlonge.facade.impl.CompraServiceFacadeImpl;
import br.com.bemlonge.model.Agenda;
import br.com.bemlonge.model.Compra;
import br.com.bemlonge.model.Pagamento;
import br.com.bemlonge.util.ConstantesUtils;

import com.opensymphony.xwork2.ActionSupport;

public class PagamentoAction extends ActionSupport {

	static final Logger logger = LogManager.getLogger(PagamentoAction.class
			.getName());

	private static final long serialVersionUID = 6949049385371362417L;

	private ClienteDTO cliente;
	private Pagamento pagamento;
	private PacoteDTO pacote;
	private PasseioDTO passeio;
	private Agenda agenda;

	public String realizarCompraPacote() {
		CompraServiceFacadeImpl facade = new CompraServiceFacadeImpl();
		Compra compra = new Compra(cliente.getId());

		try {
			facade.cadastrarCompra(compra, pacote, cliente, pagamento);
		} catch (CompraException e) {
			logger.error("Erro ao Realizar Compra Pacote");
			return ERROR;
		} catch (PagamentoException e) {
			logger.error("Erro ao Realizar Compra Pacote");
			return ERROR;
		}

		return SUCCESS;
	}

	public String realizarCompraPasseio() {

		CompraServiceFacadeImpl facade = new CompraServiceFacadeImpl();
		Compra compra = new Compra(cliente.getId());

		pagamento.setTipo(TipoPagamentoEnum.A_VISTA);
		pagamento.setNumeroParcelas(ConstantesUtils.PARCELA_UNICA);

		try {
			facade.cadastrarCompra(compra, passeio, cliente, pagamento, agenda);
		} catch (CompraException e) {
			logger.error("Erro ao Realizar Compra Passeio");
			return ERROR;
		} catch (PagamentoException e) {
			logger.error("Erro ao Realizar Compra Passeio");
			return ERROR;
		}
		return SUCCESS;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public PacoteDTO getPacote() {
		return pacote;
	}

	public void setPacote(PacoteDTO pacote) {
		this.pacote = pacote;
	}

	public PasseioDTO getPasseio() {
		return passeio;
	}

	public void setPasseio(PasseioDTO passeio) {
		this.passeio = passeio;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
}
