package br.com.bemlonge.dao;

import br.com.bemlonge.exception.CompraException;
import br.com.bemlonge.model.Compra;
import br.com.bemlonge.model.Pacote;

public interface CompraPacoteDAO {
	/**
	 * Cadastra compra_pacote
	 * @param compra
	 * @param pacote
	 */
	void cadastrarCompraPacote(Compra compra, Pacote pacote) throws CompraException ;
}
