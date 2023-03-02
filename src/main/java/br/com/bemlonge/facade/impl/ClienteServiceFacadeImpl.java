package br.com.bemlonge.facade.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.converter.ClienteConverter;
import br.com.bemlonge.dao.impl.ClienteDAOImpl;
import br.com.bemlonge.dao.impl.EnderecoDAOImpl;
import br.com.bemlonge.dto.ClienteDTO;
import br.com.bemlonge.dto.HistoricoClienteDTO;
import br.com.bemlonge.exception.ClienteException;
import br.com.bemlonge.exception.EnderecoException;
import br.com.bemlonge.facade.ClienteServiceFacade;
import br.com.bemlonge.model.Cliente;
import br.com.bemlonge.model.HistoricoPacotePasseio;
import br.com.bemlonge.util.FormatadorEspacosUtils;

public class ClienteServiceFacadeImpl implements ClienteServiceFacade {
	
	static final Logger logger = LogManager.getLogger(ClienteServiceFacadeImpl.class.getName());

	@Override
	public Boolean cadastrarClientePotencial(ClienteDTO clienteDto) throws ClienteException{
		try {
			Cliente cliente = clienteDto.converterParaModel();
			ClienteDAOImpl clienteDao = new ClienteDAOImpl();
			clienteDao.cadastrar(cliente);
			return true;
		} catch (ClienteException ex) {
			ex.getMessage();
			logger.error("Erro ao Cadastrar Cliente Potencial.");
			return false;
		}
	}
	
	@Override
	public void alterarCliente(ClienteDTO clienteDto) throws ClienteException, EnderecoException{
			ClienteDAOImpl clienteDao = new ClienteDAOImpl();
			clienteDao.atualizar(clienteDto.converterParaModel());
			Integer idCliente = clienteDao.consultarId(clienteDto.getCpf());
			EnderecoDAOImpl enderecoDao = new EnderecoDAOImpl();
			enderecoDao.atualizarEndereco(clienteDto.getEndereco(), idCliente);	
	}

	@Override
	public ClienteDTO listarCliente(String cpf) throws ClienteException{
		ClienteDAOImpl clienteDao = new ClienteDAOImpl();
		ClienteDTO clienteDto = new ClienteDTO();
		try{
			clienteDto = clienteDao.consultarCliente(cpf);
			return clienteDto;
		}catch(ClienteException ex){
			logger.error("Erro ao Listar Cliente.");
			throw new ClienteException("Error ao listar Clientes.(message): "+ex.getMessage());
		}
		
	}

	@Override
	public Boolean validarCadastro(String cpf) throws ClienteException{
		ClienteDAOImpl clienteDao = new ClienteDAOImpl();
		try {
			List<ClienteDTO> list = clienteDao.listarPorCPF(cpf);
			if (list.isEmpty()) {
				return true;
			}	
		} catch (ClienteException ex) {
			logger.error("Cliente já cadastrado.");
			throw new ClienteException("CPF já está cadastrado na nossa base de dados.");
		}	
		return false;
	}

	@Override
	public Boolean validarClienteCadastrado(String nome, String cpf) throws ClienteException{
		ClienteDAOImpl clienteDao = new ClienteDAOImpl();
		try {
			List<ClienteDTO> list = clienteDao.listarPorCPF(cpf);
			if (list.isEmpty())
				return false;
			} catch (ClienteException ex) {
				logger.error("Erro ao validar Cadastro Cliente.");
				throw new ClienteException("Error ao validar Cliente.(message):"+ex.getMessage());
			}	
		return true;
	}

	@Override
	public void cadastrarCliente(ClienteDTO clienteDto) throws ClienteException, EnderecoException{
			ClienteDAOImpl clienteDao = new ClienteDAOImpl();
			clienteDao.cadastrar(clienteDto.converterParaModel());
			EnderecoDAOImpl enderecoDao = new EnderecoDAOImpl();
			clienteDto.setId(clienteDao.consultarId(clienteDto.getCpf()));
			enderecoDao.cadastrarEndereco(clienteDto.getEndereco(), clienteDto.getId());
	}
	
	@Override
	public ClienteDTO buscarClientePorCPF(String cpf)throws ClienteException{
		ClienteDAOImpl clienteDao = new ClienteDAOImpl();
		Cliente cliente = clienteDao.consultarCPF(cpf);
		return cliente.converterParaDTO();
	}
	
	@Override
	public ClienteDTO formatarCaracteres(ClienteDTO clienteDto) throws ClienteException{
		FormatadorEspacosUtils form = new FormatadorEspacosUtils();
		clienteDto.setCpf(form.removerCaracteres(clienteDto.getCpf()));
		clienteDto.setTelefone(form.removerCaracteres(clienteDto.getTelefone()));
		clienteDto.setRg(form.removerCaracteres(clienteDto.getRg()));
		clienteDto.getEndereco().setCep(form.removerCaracteres(clienteDto.getEndereco().getCep()));
		return clienteDto;
	}

	@Override
	public List<HistoricoClienteDTO> listarHistorico(String cpfConsultado)
			throws ClienteException {
		ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
		List<HistoricoPacotePasseio> historicoPacotes = new ArrayList<HistoricoPacotePasseio>();
		List<HistoricoPacotePasseio> historicoPasseios = new ArrayList<HistoricoPacotePasseio>();
		List<HistoricoClienteDTO> historicoCompleto = new ArrayList<HistoricoClienteDTO>();
		try {
			historicoPacotes = clienteDAO.listarHistoricoCompraPacote(cpfConsultado);
			historicoPasseios = clienteDAO.listarHistoricoCompraPasseio(cpfConsultado);
			for (HistoricoPacotePasseio historicoPacote : historicoPacotes ) {	
				HistoricoClienteDTO dto = new HistoricoClienteDTO();
				dto.converterModel(historicoPacote);
				historicoCompleto.add(dto);
			}
			for (HistoricoPacotePasseio historicoPasseio : historicoPasseios) {
				HistoricoClienteDTO dto = new HistoricoClienteDTO();
				dto.converterModel(historicoPasseio);
				historicoCompleto.add(dto);
			}
			Collections.sort(historicoCompleto, Collections.reverseOrder());
			return historicoCompleto;
		} catch (ClienteException ex) {
			logger.error("Erro ao listar histórico de compra Cliente.");
			throw new ClienteException("Erro ao listar histórico compra Cliente.(message): "+ex.getMessage());
		}		
	}
	
	@Override
	public List<ClienteDTO> buscarClientes() throws ClienteException{
		ClienteDAOImpl dao = new ClienteDAOImpl();
		return ClienteConverter.converterParaDTO(dao.listarClientes(100, 0));
	}
	
	@Override
	public List<ClienteDTO> buscarClientes(String nome) throws ClienteException{
		ClienteDAOImpl dao = new ClienteDAOImpl();
		return ClienteConverter.converterParaDTO(dao.filtrarClientes(nome));
	}

}
