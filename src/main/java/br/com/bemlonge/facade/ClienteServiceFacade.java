package br.com.bemlonge.facade;

import java.util.List;

import br.com.bemlonge.dto.ClienteDTO;
import br.com.bemlonge.dto.HistoricoClienteDTO;
import br.com.bemlonge.exception.ClienteException;
import br.com.bemlonge.exception.EnderecoException;

public interface ClienteServiceFacade {

	Boolean validarCadastro(String cpf) throws ClienteException;

	void alterarCliente(ClienteDTO clienteDto) throws ClienteException, EnderecoException;

	ClienteDTO listarCliente(String cpf) throws ClienteException;

	Boolean cadastrarClientePotencial(ClienteDTO clienteDto) throws ClienteException;

	void cadastrarCliente(ClienteDTO clienteDto) throws ClienteException, EnderecoException;
	
	public Boolean validarClienteCadastrado(String nome, String cpf) throws ClienteException;
	
	public ClienteDTO buscarClientePorCPF(String cpf)throws ClienteException;
	
	public ClienteDTO formatarCaracteres(ClienteDTO clienteDto) throws ClienteException;
	
	public List<HistoricoClienteDTO> listarHistorico(String cpfConsultado) throws ClienteException;
	
	public List<ClienteDTO> buscarClientes() throws ClienteException;
	
	public List<ClienteDTO> buscarClientes(String nome) throws ClienteException;
	
}
