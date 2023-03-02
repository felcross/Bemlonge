package br.com.bemlonge.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dto.ClienteDTO;
import br.com.bemlonge.dto.EnderecoDTO;
import br.com.bemlonge.dto.HistoricoClienteDTO;
import br.com.bemlonge.enums.MesesEnum;
import br.com.bemlonge.enums.UnidadeFederativaEnum;
import br.com.bemlonge.exception.ClienteException;
import br.com.bemlonge.exception.EnderecoException;
import br.com.bemlonge.facade.impl.ClienteServiceFacadeImpl;
import br.com.bemlonge.util.ConstantesUtils;
import br.com.bemlonge.util.FormatadorEspacosUtils;
import br.com.bemlonge.util.ValidadorCpfUtils;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Classe concreta action para ações do cliente
 * 
 * */
public class ClienteAction extends ActionSupport {

	private static final long serialVersionUID = -8633439851540759973L;

	static final Logger logger = LogManager.getLogger(ClienteAction.class.getName());

	private List<MesesEnum> listaMeses = Arrays.asList(MesesEnum.values());
	private List<UnidadeFederativaEnum> listaUfs = Arrays.asList(UnidadeFederativaEnum.values());
	private ClienteDTO clienteDto = new ClienteDTO();
	private EnderecoDTO enderecoDto = new EnderecoDTO();
	private ClienteServiceFacadeImpl clienteFacade = new ClienteServiceFacadeImpl();
	private List<HistoricoClienteDTO> listaHistorico = new ArrayList<HistoricoClienteDTO>();
	private String cpfConsultado;
	private List<ClienteDTO> listaClientes;
	private String filtroCliente;

	// // @Autowired
	// ClienteServiceFacade facade;

	/**
	 * Método para cadastrar cliente no banco de dados
	 * 
	 * @return String
	 * */
	public String cadastrarCliente() {
		try {
			if (clienteDto.getCpf() != null) {
				this.clienteDto = clienteFacade.formatarCaracteres(clienteDto);
				this.clienteDto.setResultado(clienteFacade.validarCadastro(
						clienteDto.getCpf()));
				this.clienteDto.setValidacaoCpf(ValidadorCpfUtils
						.isCPF(clienteDto.getCpf()));
				if (this.clienteDto.getValidacaoCpf()) {
					if (this.clienteDto.getResultado()) {
						try {
							clienteFacade.cadastrarCliente(clienteDto);
						} catch (EnderecoException e) {
							logger.error("Erro ao cadastrar cliente.");
						}
						return SUCCESS;
					} else {
						return ConstantesUtils.EXISTENTE;
					}
				} else {
					return ConstantesUtils.EXISTENTE;
				}
			} else {
				this.clienteDto.setResultado(Boolean.TRUE);
				this.clienteDto.setValidacaoCpf(Boolean.TRUE);
				return ConstantesUtils.VOLTAR;
			}
		} catch (ClienteException ex) {
			logger.error("Erro ao cadastrar Cliente.");
			return ERROR;
		}
	}

	/**
	 * Método para cadastrar cliente potencial no banco de dados
	 * 
	 * @return String
	 * */
	public String cadastrarClientePotencial() {
		try {
			this.clienteDto.setResultado(clienteFacade
					.cadastrarClientePotencial(clienteDto));
			if (this.clienteDto.getResultado()) {
				return SUCCESS;
			}
		} catch (ClienteException ex) {
			logger.error("Erro ao cadastrar cliente Potencial.");
			return ERROR;
		}
		return ERROR;
	}

	/**
	 * Método para alterar cliente no banco de dados
	 * 
	 * @return String
	 * */
	public String alterarCliente() {
		try {
			this.clienteDto = clienteFacade.formatarCaracteres(clienteDto);
			try {
				clienteFacade.alterarCliente(clienteDto);
			} catch (EnderecoException e) {

				logger.error("Erro ao alterar cliente.");
			}
			this.clienteDto.setResultado(Boolean.TRUE);
			this.listaHistorico = clienteFacade.listarHistorico(clienteDto
					.getCpf());
			return SUCCESS;
		} catch (ClienteException ex) {
			logger.error("Erro ao alterar Cliente");
			return ERROR;
		}
	}

	/**
	 * Método para resgatar cliente no banco de dados
	 * 
	 * @return String
	 * */
	public String listarCliente() {
		FormatadorEspacosUtils formatadorEspacos = new FormatadorEspacosUtils();
		this.clienteDto.setCpf(formatadorEspacos.removerCaracteres(clienteDto
				.getCpf()));
		try {
			this.listaHistorico = clienteFacade.listarHistorico(clienteDto
					.getCpf());
			this.clienteDto = clienteFacade.listarCliente(clienteDto.getCpf());
			return SUCCESS;
		} catch (ClienteException ex) {
			logger.error("Erro ao Listar Clientes.");
			return ERROR;
		}
	}

	/**
	 * Método para inicializar tela de cadastro do cliente na JSP
	 * 
	 * @return String
	 * */
	public String iniciarCliente() {
		try {
			this.clienteDto.setResultado(Boolean.TRUE);
			this.clienteDto.setValidacaoCpf(Boolean.TRUE);
			return SUCCESS;
		} catch (Exception ex) {
			return ERROR;
		}
	}

	public String consultarCadastro() {
		try {
			if (this.clienteDto.getCpf() != null) {
				ClienteServiceFacadeImpl facadeCliente = new ClienteServiceFacadeImpl();
				FormatadorEspacosUtils formatadorEspaços = new FormatadorEspacosUtils();
				String cpfFormatado = formatadorEspaços
						.removerCaracteres(clienteDto.getCpf());
				this.clienteDto.setResultado(facadeCliente
						.validarClienteCadastrado(clienteDto.getNome(),
								cpfFormatado));
				if (this.clienteDto.getResultado()) {
					return SUCCESS;
				} else {
					return ConstantesUtils.INEXISTENTE;
				}
			} else {
				this.clienteDto.setResultado(Boolean.FALSE);
				return ConstantesUtils.INEXISTENTE;
			}
		} catch (ClienteException ex) {
			logger.error("Erro ao consultar Cadastro Cliente.");
			return ERROR;
		}
	}

	public String listarFaturaClienteAdmin() {
		FormatadorEspacosUtils form = new FormatadorEspacosUtils();
		this.clienteDto.setCpf(form.removerCaracteres(cpfConsultado));
		try {
			this.listaHistorico = clienteFacade.listarHistorico(clienteDto
					.getCpf());
			this.clienteDto = clienteFacade.listarCliente(clienteDto.getCpf());
			return SUCCESS;
		} catch (ClienteException e) {
			return ERROR;
		}
	}

	public String limparFiltroCliente() {
		try {
			this.listaClientes = clienteFacade.buscarClientes();
		} catch (ClienteException e) {
			return ERROR;
		}
		return SUCCESS;

	}

	public String filtrarClientes() {
		try {
			this.listaClientes = clienteFacade.buscarClientes(this.filtroCliente);
		} catch (ClienteException e) {
			return ERROR;
		}
		return SUCCESS;
	}

	public ClienteDTO getClienteDto() {
		return clienteDto;
	}

	public void setClienteDto(ClienteDTO clienteDto) {
		this.clienteDto = clienteDto;
	}

	public ClienteServiceFacadeImpl getClienteFacade() {
		return clienteFacade;
	}

	public void setClienteFacade(ClienteServiceFacadeImpl clienteFacade) {
		this.clienteFacade = clienteFacade;
	}

	public List<HistoricoClienteDTO> getListaHistorico() {
		return listaHistorico;
	}

	public void setListaHistorico(List<HistoricoClienteDTO> historicoPacotes) {
		this.listaHistorico = historicoPacotes;
	}

	public List<MesesEnum> getListaMeses() {
		return listaMeses;
	}

	public void setListaMeses(List<MesesEnum> listaMeses) {
		this.listaMeses = listaMeses;
	}

	public List<UnidadeFederativaEnum> getUfs() {
		return listaUfs;
	}

	public void setUfs(List<UnidadeFederativaEnum> ufs) {
		this.listaUfs = ufs;
	}

	public EnderecoDTO getEnderecoDto() {
		return enderecoDto;
	}

	public void setEnderecoDto(EnderecoDTO enderecoDto) {
		this.enderecoDto = enderecoDto;
	}

	public String getCpfConsultado() {
		return cpfConsultado;
	}

	public void setCpfConsultado(String cpfConsultado) {
		this.cpfConsultado = cpfConsultado;
	}

	public String getFiltroCliente() {
		return filtroCliente;
	}

	public void setFiltroCliente(String filtroCliente) {
		this.filtroCliente = filtroCliente;
	}

	public List<ClienteDTO> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<ClienteDTO> listaClientes) {
		this.listaClientes = listaClientes;
	}
}
