package br.com.bemlonge.dao;

import java.util.List;

import br.com.bemlonge.dto.EnderecoDTO;
import br.com.bemlonge.exception.EnderecoException;

public interface EnderecoDAO {
	List<EnderecoDTO> consultarEndereco(String idCliente) throws EnderecoException;
	void cadastrarEndereco(EnderecoDTO endereco, Integer idCliente) throws EnderecoException;
	void atualizarEndereco(EnderecoDTO endereco, Integer idCliente) throws EnderecoException;
}
