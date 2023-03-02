package br.com.bemlonge.facade;

import java.util.List;

import br.com.bemlonge.dto.PacoteDTO;
import br.com.bemlonge.dto.PasseioDTO;
import br.com.bemlonge.exception.PacoteException;
import br.com.bemlonge.exception.PacotePasseioException;
import br.com.bemlonge.exception.PasseioException;

public interface PasseioPacoteServiceFacade {
	void cadastrar(String pacote, String passeio) throws PacotePasseioException;
	List<PasseioDTO> listarPasseios() throws PasseioException;
	List<PacoteDTO> listarPacotes() throws PacoteException;
}
