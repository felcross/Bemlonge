package br.com.bemlonge.dao;

import java.util.List;

import br.com.bemlonge.exception.PacotePasseioException;
import br.com.bemlonge.model.Passeio;

public interface PacotePasseioDAO {
	/**
	 * Cadastra um passeio dentro de um pacote
	 * @param idPacote
	 * @param idPasseio
	 */
	void cadastrar(String idPacote, String idPasseio) throws PacotePasseioException;
	
	/**
	 * Lista os passeios de um pacote
	 * @param idPacote
	 * @return
	 */
	List<Passeio> listarPasseiosPacotes(int idPacote) throws PacotePasseioException;
}
