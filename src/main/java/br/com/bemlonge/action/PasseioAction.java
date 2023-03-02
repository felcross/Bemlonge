package br.com.bemlonge.action;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dto.PasseioDTO;
import br.com.bemlonge.exception.GuiaException;
import br.com.bemlonge.exception.PasseioException;
import br.com.bemlonge.facade.impl.GuiaServiceFacadeImpl;
import br.com.bemlonge.facade.impl.PasseioServiceFacadeImpl;
import br.com.bemlonge.model.Guia;

import com.opensymphony.xwork2.ActionSupport;

public class PasseioAction extends ActionSupport {

	static final Logger logger = LogManager.getLogger(PasseioAction.class
			.getName());

	private static final long serialVersionUID = -4386481340670551270L;

	private Integer id;
	private List<Guia> guias;
	private Integer guiaEscolhido;
	private String precoFiltro;
	private List<PasseioDTO> passeios;
	private List<PasseioDTO> todosPasseios;
	private PasseioDTO passeioDTO;
	private String status;
	private String idPasseio;

	public PasseioDTO getPasseioDTO() {
		return passeioDTO;
	}

	public void setPasseioDTO(PasseioDTO passeioDTO) {
		this.passeioDTO = passeioDTO;
	}

	public Integer getGuiaEscolhido() {
		return guiaEscolhido;
	}

	public void setGuiaEscolhido(Integer guiaEscolhido) {
		this.guiaEscolhido = guiaEscolhido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Guia> getGuias() {
		return guias;
	}

	public void setGuias(List<Guia> guias) {
		this.guias = guias;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<PasseioDTO> getPasseios() {
		return passeios;
	}

	public void setPasseios(List<PasseioDTO> passeios) {
		this.passeios = passeios;
	}

	public List<PasseioDTO> getTodosPasseios() {
		return todosPasseios;
	}

	public void setTodosPasseios(List<PasseioDTO> todosPasseios) {
		this.todosPasseios = todosPasseios;
	}

	public String getPrecoFiltro() {
		return precoFiltro;
	}

	public void setPrecoFiltro(String precoFiltro) {
		this.precoFiltro = precoFiltro;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIdPasseio() {
		return idPasseio;
	}

	public void setIdPasseio(String idPasseio) {
		this.idPasseio = idPasseio;
	}

	public String listarGuias() {
		GuiaServiceFacadeImpl facade = new GuiaServiceFacadeImpl();
		try {
			this.guias = facade.listar();
		} catch (GuiaException e) {
			logger.error("Erro ao listar guia.");
			return ERROR;
		}
		return SUCCESS;
	}

	public String salvarPasseio() {

		PasseioServiceFacadeImpl facade = new PasseioServiceFacadeImpl();
		try {
			facade.cadastrar(passeioDTO.getLocalPartida(),
					passeioDTO.getDestino(), passeioDTO.getPreco(),
					passeioDTO.getNumVagas(), passeioDTO.getSituacao(),
					getGuiaEscolhido());
		} catch (PasseioException e) {
			logger.error("erro ao cadastrar passeio. (cause): " + e.getCause());
		}
		return SUCCESS;

	}

	@Override
	public String execute() {
		PasseioServiceFacadeImpl facade = new PasseioServiceFacadeImpl();
		this.setPasseios(facade.listarPasseios());
		return SUCCESS;
	}

	public String listarPasseiosAtivos() {
		PasseioServiceFacadeImpl facade = new PasseioServiceFacadeImpl();
		this.setPasseios(facade.listarPasseiosAtivos());
		return SUCCESS;
	}

	public String filtrarPasseio() {
		PasseioServiceFacadeImpl facade = new PasseioServiceFacadeImpl();
		todosPasseios = facade.listarPasseios();
		try {
			this.setPasseios(facade.filtrarPasseios(
					this.passeioDTO.getDestino(), precoFiltro));
		} catch (PasseioException e) {
			logger.error("erro ao buscar passeio. (cause): " + e.getCause());
		}
		return SUCCESS;
	}

	public String filtrarPasseioAdm() {
		PasseioServiceFacadeImpl facade = new PasseioServiceFacadeImpl();
		try {
			this.setPasseios(facade.filtrarPasseios(this.passeioDTO
					.getDestino()));
		} catch (PasseioException e) {
			logger.error("erro ao buscar passeio. (cause): " + e.getCause());
		}

		return SUCCESS;
	}

	public String detalharPasseio() {
		PasseioServiceFacadeImpl facade = new PasseioServiceFacadeImpl();
		try {
			this.passeioDTO = facade.filtrarPeloId(id);
		} catch (PasseioException e) {
			logger.error("erro ao buscar passeio. (cause): " + e.getCause());
		}
		id = passeioDTO.getId();

		return SUCCESS;
	}

	public String confirmarEdicaoPasseio() {
		PasseioServiceFacadeImpl passeioFacade = new PasseioServiceFacadeImpl();
		PasseioDTO passeioDTO = null;
		try {
			passeioDTO = passeioFacade.buscarPasseio(this.idPasseio);
			passeioDTO.setSituacao(this.status);
			passeioFacade.atualizarPasseio(passeioDTO);
		} catch (PasseioException ex) {
			logger.error("null");
		} catch (GuiaException ex) {
			logger.error("null");
		}
		return SUCCESS;
	}

	public String editarPasseio() {
		PasseioServiceFacadeImpl passeioFacade = new PasseioServiceFacadeImpl();
		try {
			this.setPasseioDTO(passeioFacade.buscarPasseio(this.idPasseio));
		} catch (PasseioException ex) {

		} catch (GuiaException ex) {

		}
		return SUCCESS;
	}
}