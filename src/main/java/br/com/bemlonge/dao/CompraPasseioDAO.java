package br.com.bemlonge.dao;

import br.com.bemlonge.exception.CompraException;
import br.com.bemlonge.model.Compra;
import br.com.bemlonge.model.Passeio;

public interface CompraPasseioDAO {
	/**
	 * Cadastra compra_passeio
	 * @param compra
	 * @param passeio
	 */
	void cadastrarCompraPasseio(Compra compra, Passeio passeio) throws CompraException;
}
