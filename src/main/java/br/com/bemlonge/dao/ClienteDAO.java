package br.com.bemlonge.dao;

import java.util.List;

import br.com.bemlonge.dto.ClienteDTO;
import br.com.bemlonge.exception.ClienteException;
import br.com.bemlonge.model.Cliente;
import br.com.bemlonge.model.HistoricoPacotePasseio;

public interface ClienteDAO {
	void cadastrar(Cliente cliente) throws ClienteException;
	void atualizar(Cliente cliente) throws ClienteException;
	Integer consultarId(String cpf) throws ClienteException;
	Cliente consultarCPF(String cpf) throws ClienteException;
	List<ClienteDTO> listarPorCPF(String cpf) throws ClienteException;
	List<HistoricoPacotePasseio> listarHistoricoCompraPacote(String cpf) throws ClienteException;
	List<HistoricoPacotePasseio> listarHistoricoCompraPasseio(String cpf) throws ClienteException;
	ClienteDTO consultarCliente(String cpfConsultado) throws ClienteException;
	List<Cliente> listarClientes(Integer limit, Integer ofsset) throws ClienteException;
	List<Cliente> filtrarClientes(String nome) throws ClienteException;
}
