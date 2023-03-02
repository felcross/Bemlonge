package br.com.bemlonge.dao;

import java.util.List;

import br.com.bemlonge.dto.GuiaDTO;
import br.com.bemlonge.exception.GuiaException;
import br.com.bemlonge.model.Guia;

public interface GuiaDao {
	void cadastrar(Guia guia) throws GuiaException;
	List<Guia> listar() throws GuiaException; 
	List<GuiaDTO> consultarGuiaPorCpf(String cpf) throws GuiaException;
	List<Guia> consultarGuiaPorNome(String nome) throws GuiaException;
	Guia pegarGuiaPeloId(int id) throws GuiaException;
	
}
