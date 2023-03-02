package br.com.bemlonge.dao;

import br.com.bemlonge.exception.PagamentoException;
import br.com.bemlonge.model.Compra;
import br.com.bemlonge.model.Pagamento;

public interface PagamentoDAO {
	/**
	 * Cadastra o pagamento
	 * @param pagamento
	 * @param compra
	 */
	void CadastrarCompra(Pagamento pagamento, Compra compra) throws PagamentoException;
}
