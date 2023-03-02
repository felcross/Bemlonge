package br.com.bemlonge.facade;

import br.com.bemlonge.dto.ClienteDTO;
import br.com.bemlonge.dto.PacoteDTO;
import br.com.bemlonge.dto.PasseioDTO;
import br.com.bemlonge.exception.CompraException;
import br.com.bemlonge.exception.PagamentoException;
import br.com.bemlonge.model.Compra;
import br.com.bemlonge.model.Pagamento;

public interface CompraServiceFacade {
	void cadastrarCompra(Compra compra, PacoteDTO pacote, ClienteDTO cliente,
			Pagamento pagamento) throws CompraException, PagamentoException;

	void cadastrarCompra(Compra compra, PasseioDTO passeio, ClienteDTO cliente,
			Pagamento pagamento) throws CompraException ,PagamentoException;
}
