package br.com.bemlonge.dao;

import java.util.Date;

import br.com.bemlonge.exception.CompraException;
import br.com.bemlonge.model.Cliente;
import br.com.bemlonge.model.Compra;

public interface CompraDAO {
	/**
	 * Cadastra compra
	 * @param compra
	 * @param cliente
	 */
	void cadastrarCompra(Compra compra, Cliente cliente) throws CompraException;
	
	/**
	 * Busca compra pela data de compra e id do cliente
	 * @param dataCompra
	 * @param idCliente
	 * @return
	 */
	Compra buscarCompra(Date dataCompra, Integer idCliente) throws CompraException;
	
	/**
	 * Busca o id da compra de um passeio
	 * @param compra
	 * @return
	 */
	Integer buscarCompraPasseioId(Compra compra) throws CompraException;
}
