package br.com.bemlonge.facade.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dao.impl.AgendaDAOImpl;
import br.com.bemlonge.dao.impl.CompraDAOImpl;
import br.com.bemlonge.dao.impl.CompraPacoteDAOImpl;
import br.com.bemlonge.dao.impl.CompraPasseioDAOImpl;
import br.com.bemlonge.dao.impl.PagamentoDAOImpl;
import br.com.bemlonge.dto.ClienteDTO;
import br.com.bemlonge.dto.PacoteDTO;
import br.com.bemlonge.dto.PasseioDTO;
import br.com.bemlonge.exception.AgendaException;
import br.com.bemlonge.exception.CompraException;
import br.com.bemlonge.exception.PagamentoException;
import br.com.bemlonge.facade.CompraServiceFacade;
import br.com.bemlonge.model.Agenda;
import br.com.bemlonge.model.Compra;
import br.com.bemlonge.model.Pagamento;

public class CompraServiceFacadeImpl implements CompraServiceFacade {

	static final Logger logger = LogManager
			.getLogger(CompraServiceFacadeImpl.class.getName());

	public void cadastrarCompra(Compra compra, PacoteDTO pacote,
			ClienteDTO cliente, Pagamento pagamento) throws CompraException,
			PagamentoException {

		CompraDAOImpl compraDao = new CompraDAOImpl();
		CompraPacoteDAOImpl compraPacoteDao = new CompraPacoteDAOImpl();

		compraDao.cadastrarCompra(compra, cliente.converterParaModel());

		Compra compraConsulta = compraDao.buscarCompra(compra.getDataCompra(),
				cliente.getId());
		compraPacoteDao.cadastrarCompraPacote(compraConsulta,
				pacote.converterParaPacote());

		cadastrarPagamento(compraConsulta, pagamento);

	}

	public void cadastrarCompra(Compra compra, PasseioDTO passeio,
			ClienteDTO cliente, Pagamento pagamento) throws CompraException,
			PagamentoException {

		CompraDAOImpl compraDao = new CompraDAOImpl();
		CompraPasseioDAOImpl compraPasseioDao = new CompraPasseioDAOImpl();

		compraDao.cadastrarCompra(compra, cliente.converterParaModel());

		Compra compraConsulta = compraDao.buscarCompra(compra.getDataCompra(),
				cliente.getId());
		compraPasseioDao.cadastrarCompraPasseio(compraConsulta,
				passeio.converterParaModel());

		cadastrarPagamento(compraConsulta, pagamento);

	}

	public void cadastrarCompra(Compra compra, PasseioDTO passeio,
			ClienteDTO cliente, Pagamento pagamento, Agenda agenda)
			throws CompraException, PagamentoException {

		CompraDAOImpl compraDao = new CompraDAOImpl();
		CompraPasseioDAOImpl compraPasseioDao = new CompraPasseioDAOImpl();

		compraDao.cadastrarCompra(compra, cliente.converterParaModel());

		Compra compraConsulta = compraDao.buscarCompra(compra.getDataCompra(),
				cliente.getId());
		compraPasseioDao.cadastrarCompraPasseio(compraConsulta,
				passeio.converterParaModel());

		cadastrarPagamento(compraConsulta, pagamento);

		agenda.setIdCompraPasseio(compraDao
				.buscarCompraPasseioId(compraConsulta));

		try {
			cadastrarAgenda(agenda);
		} catch (AgendaException e) {
			logger.error("Erro ao cadastrar Agenda");

		}

	}

	private void cadastrarPagamento(Compra compra, Pagamento pagamento)
			throws PagamentoException {
		PagamentoDAOImpl dao = new PagamentoDAOImpl();
		dao.CadastrarCompra(pagamento, compra);
	}

	private void cadastrarAgenda(Agenda agenda) throws AgendaException {
		AgendaDAOImpl dao = new AgendaDAOImpl();
		dao.cadastrarCompra(agenda);
	}
}
