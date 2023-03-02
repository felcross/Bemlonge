package br.com.bemlonge.facade;

import java.util.Date;
import java.util.List;

import br.com.bemlonge.dto.DetalhesPacoteDTO;
import br.com.bemlonge.dto.PacoteDTO;
import br.com.bemlonge.exception.PacoteException;
import br.com.bemlonge.exception.PasseioException;

public interface PacoteServiceFacade {

	Boolean cadastrar(String nome, Date data_embarque, Date data_desembarque)
			throws PacoteException, PasseioException;

	List<PacoteDTO> filtro(String descricao, String mes, String preco)
			throws PacoteException;

	List<PacoteDTO> filtro(String descricao) throws PacoteException,
			PasseioException;

	List<DetalhesPacoteDTO> filtrarPeloId(int id) throws PacoteException,
			PasseioException;

	DetalhesPacoteDTO pegarPacotePeloID(Integer id) throws PacoteException;

}
