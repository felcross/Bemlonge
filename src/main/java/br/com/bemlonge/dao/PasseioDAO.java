package br.com.bemlonge.dao;

import java.util.List;

import br.com.bemlonge.exception.PasseioException;
import br.com.bemlonge.model.Passeio;

public interface PasseioDAO {
	void cadastrar(Passeio passeio) throws PasseioException;
	void atualizar(Passeio passeio) throws PasseioException;
	List<Passeio> listar() throws PasseioException;
	List<Passeio> listarPasseiosAtivos() throws PasseioException;
	Passeio listarPasseioGuiaPeloID(Integer id) throws PasseioException;
	List<Passeio> filtrarPasseio(String destino, String preco) throws PasseioException;
	List<Passeio> filtrarPasseio(String destino) throws PasseioException;
	List<Passeio> listarComLimit(Integer limit, Integer offSet) throws PasseioException;
	Passeio buscarPasseioPeloID(String id) throws PasseioException;
	
}
