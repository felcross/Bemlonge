package br.com.bemlonge.dao;

import br.com.bemlonge.exception.AgendaException;
import br.com.bemlonge.model.Agenda;

public interface AgendaDAO {
	/**
	 * Cadastra a agenda
	 * @param agenda
	 */
	void cadastrarCompra(Agenda agenda) throws AgendaException;
}
