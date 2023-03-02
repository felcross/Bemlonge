package br.com.bemlonge.dao;

import java.math.BigDecimal;
import java.util.List;

import br.com.bemlonge.exception.PacoteException;
import br.com.bemlonge.exception.PasseioException;
import br.com.bemlonge.model.Pacote;

public interface PacoteDAO {
	
	void cadastrar(Pacote pacote) throws PacoteException;
	List<Pacote> listar() throws PacoteException;
	List<Pacote> filtrar(String descricao, String mes, String preco) throws PacoteException;
	List<Pacote> filtrar(String descricao) throws PacoteException, PasseioException;
	BigDecimal precoPacote(int id) throws PacoteException;
	int vagasPacote(int id) throws PacoteException;
	Pacote buscarPeloID(int id) throws PacoteException;
	List<Pacote> buscarPacotePeloID(int id) throws Exception;
	int vagasPreenchidas(Integer id) throws PacoteException;

}
