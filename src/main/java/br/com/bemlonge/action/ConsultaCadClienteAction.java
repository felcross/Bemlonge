package br.com.bemlonge.action;


import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dto.ClienteDTO;
import br.com.bemlonge.dto.PasseioDTO;
import br.com.bemlonge.exception.ClienteException;
import br.com.bemlonge.exception.PasseioException;
import br.com.bemlonge.facade.impl.ClienteServiceFacadeImpl;
import br.com.bemlonge.facade.impl.PasseioServiceFacadeImpl;
import br.com.bemlonge.util.FormatadorEspacosUtils;

import com.opensymphony.xwork2.ActionSupport;

public class ConsultaCadClienteAction extends ActionSupport {
	
	static final Logger logger = LogManager.getLogger(ConsultaCadClienteAction.class.getName());

	private static final long serialVersionUID = 7142265490303505024L;
	
	private ClienteDTO cliente = new ClienteDTO();

	private Integer id;

	private List<PasseioDTO> passeios;
	private PasseioDTO passeio;
	private Integer idPasseio;
	private Date dataAgendamento;
	

	public List<PasseioDTO> getPasseios() {
		return passeios;
	}

	public void setPasseios(List<PasseioDTO> passeios) {
		this.passeios = passeios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



   
	public String consultaCpf() {

		if (cliente.getCpf() != null) {
			ClienteServiceFacadeImpl facadeCli = new ClienteServiceFacadeImpl();
			FormatadorEspacosUtils form = new FormatadorEspacosUtils();
			String cpfForm = form.removerCaracteres(cliente.getCpf());
			try {
				cliente.setResultado(facadeCli.validarClienteCadastrado(cliente.getNome(), cpfForm));
				PasseioServiceFacadeImpl facadePasseio = new PasseioServiceFacadeImpl();
				this.passeio = facadePasseio.filtrarPeloId(id);
			} catch (ClienteException e) {
				logger.error("erro ao validar cliente. (cause): " + e.getCause());
				return ERROR;
			} catch (PasseioException e) {
				logger.error("erro ao buscar passeio. (cause): " + e.getCause());
			}
			
			idPasseio = passeio.getId();
	
			
				if (this.cliente.getResultado()) {
					try {
						setCliente(facadeCli.buscarClientePorCPF(cpfForm));
						return "existente";
					} catch (Exception e) {
						return ERROR;
					}
				} else {
					return SUCCESS;
					
				}
		} else {
			this.cliente.setResultado(Boolean.TRUE);
			return "voltar";
		}
	}

	
	public String detalharPasseioCad(){
		PasseioServiceFacadeImpl facade = new PasseioServiceFacadeImpl();
		this.cliente.setResultado(Boolean.TRUE);
		try {
			this.passeio = facade.filtrarPeloId(id);
		} catch (PasseioException e) {
			logger.error("erro ao buscar passeio. (cause): " + e.getCause());
		}
		id = passeio.getId();
		setDataAgendamento(getDataAgendamento());
		return SUCCESS;
	}
	
	public PasseioDTO getPasseio() {
		return passeio;
	}

	public void setPasseio(PasseioDTO passeio) {
		this.passeio = passeio;
	}

	public Integer getIdPasseio() {
		return idPasseio;
	}

	public void setIdPasseio(Integer idPasseio) {
		this.idPasseio = idPasseio;
	}



	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	
	
	
}