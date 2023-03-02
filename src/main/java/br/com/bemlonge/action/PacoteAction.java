package br.com.bemlonge.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.converter.PasseioConverter;
import br.com.bemlonge.dao.impl.PacoteDAOImpl;
import br.com.bemlonge.dao.impl.PacotePasseioDAOImpl;
import br.com.bemlonge.dto.DetalhesPacoteDTO;
import br.com.bemlonge.dto.PacoteDTO;
import br.com.bemlonge.dto.PasseioDTO;
import br.com.bemlonge.exception.PacoteException;
import br.com.bemlonge.exception.PasseioException;
import br.com.bemlonge.facade.impl.PacoteServiceFacadeImpl;
import br.com.bemlonge.facade.impl.PasseioPacoteServiceFacadeImpl;
import br.com.bemlonge.facade.impl.PasseioServiceFacadeImpl;
import br.com.bemlonge.model.Passeio;
import br.com.bemlonge.util.ConstantesUtils;

import com.opensymphony.xwork2.ActionSupport;

public class PacoteAction extends ActionSupport {

	static final Logger logger = LogManager.getLogger(PacoteAction.class
			.getName());

	private static final long serialVersionUID = 487535084271193826L;

	private Integer id;
	private String descricao;
	private String nome;
	private Date dataEmbarque;
	private Date dataDesembarque;
	private Boolean resultado;
	private List<PacoteDTO> pacotes;
	private PacoteDTO pacote;
	private String mesSelecionado;
	private String preco;
	private Integer vagas;
	private Integer vagasDisponiveis;
	private BigDecimal precoPacote;
	private String passeioSelecionado;
	private DetalhesPacoteDTO detalhePacoteDTO;
	private List<PasseioDTO> passeiosDTO;
	private BigDecimal precoDosPasseiosSelecionados;
	private List<DetalhesPacoteDTO> detalhesPacote;

	public String salvarPacote() {
		PacoteServiceFacadeImpl facade = new PacoteServiceFacadeImpl();
		try {
			this.resultado = facade.cadastrar(getNome(), getDataEmbarque(),
					getDataDesembarque());
		} catch (PacoteException ex) {

		}
		if (this.resultado == true) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String execute() {
		PasseioPacoteServiceFacadeImpl facade = new PasseioPacoteServiceFacadeImpl();
		try {
			this.setPacotes(facade.listarPacotes());
		} catch (PacoteException ex) {

		}
		return SUCCESS;
	}

	public String filtrar() {
		PacoteServiceFacadeImpl pacoteFacade = new PacoteServiceFacadeImpl();
		try {
			this.setPacotes(pacoteFacade.filtro(this.nome, this.mesSelecionado,
					this.preco));
		} catch (PacoteException ex) {

		}
		if (!this.pacotes.isEmpty()) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String filtrarPacotesAdm() {
		PacoteServiceFacadeImpl facade = new PacoteServiceFacadeImpl();
		try {
			this.setPacotes(facade.filtro(this.nome));
		} catch (PasseioException ex) {
			logger.error("erro ao buscar pacote. (cause): " + ex.getCause());
		} catch (PacoteException ex) {

		}
		return SUCCESS;
	}

	public String detalharPacote() {
		PacoteServiceFacadeImpl pacoteFacade = new PacoteServiceFacadeImpl();
		PacoteDAOImpl pacoteDAO = new PacoteDAOImpl();
		try {
			int vagasPreenchidas = pacoteDAO.vagasPreenchidas(this.id);
			this.detalhesPacote = pacoteFacade.filtrarPeloId(this.id);
			this.descricao = detalhesPacote.get(ConstantesUtils.PACOTE)
					.getDescricao();
			this.dataEmbarque = detalhesPacote.get(ConstantesUtils.PACOTE)
					.getDataEmbarque();
			this.dataDesembarque = detalhesPacote.get(ConstantesUtils.PACOTE)
					.getDataDesembarque();
			this.vagas = detalhesPacote.get(ConstantesUtils.PACOTE).getVagas();
			this.vagasDisponiveis = vagas - vagasPreenchidas;
			this.precoPacote = detalhesPacote.get(ConstantesUtils.PACOTE)
					.getPreco();
		} catch (PasseioException ex) {
			logger.error("erro ao buscar pacote. (cause): " + ex.getCause());
		} catch (PacoteException ex) {

		}
		return SUCCESS;
	}

	public String consultarTelaCadastro() {
		PasseioServiceFacadeImpl passeioFacade = new PasseioServiceFacadeImpl();
		PacoteServiceFacadeImpl pacoteFacade = new PacoteServiceFacadeImpl();
		try {
			this.detalhePacoteDTO = pacoteFacade.pegarPacotePeloID(this.id);
			this.passeiosDTO = passeioFacade
					.filtrarPeloIdString(passeioSelecionado);
			this.precoDosPasseiosSelecionados = passeioFacade
					.somarPrecoDosPasseiosSelecionados(this.passeiosDTO);
		} catch (PacoteException ex) {

		} catch (PasseioException ex) {

		}
		return SUCCESS;
	}

	public String listarPacote() throws Exception {
		pacote = new PacoteDTO();
		pacote.setId(this.id);
		pacote.setDescricao(this.descricao);
		PacotePasseioDAOImpl pacoteDAO = new PacotePasseioDAOImpl();
		List<Passeio> passeios = new ArrayList<Passeio>();
		passeiosDTO = new ArrayList<PasseioDTO>();
		passeios = pacoteDAO.listarPasseiosPacotes(pacote.getId());
		passeiosDTO = PasseioConverter.converterParaDTO(passeios);
		return SUCCESS;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataEmbarque() {
		return dataEmbarque;
	}

	public void setDataEmbarque(Date dataEmbarque) {
		this.dataEmbarque = dataEmbarque;
	}

	public Date getDataDesembarque() {
		return dataDesembarque;
	}

	public void setDataDesembarque(Date dataDesembarque) {
		this.dataDesembarque = dataDesembarque;
	}

	public List<PacoteDTO> getPacotes() {
		return pacotes;
	}

	public void setPacotes(List<PacoteDTO> pacotes) {
		this.pacotes = pacotes;
	}

	public String getMesSelecionado() {
		return mesSelecionado;
	}

	public void setMesSelecionado(String mesSelecionado) {
		this.mesSelecionado = mesSelecionado;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public Integer getVagas() {
		return vagas;
	}

	public void setVagas(Integer vagas) {
		this.vagas = vagas;
	}

	public Integer getVagasDisponiveis() {
		return vagasDisponiveis;
	}

	public void setVagasDisponiveis(Integer vagasDisponiveis) {
		this.vagasDisponiveis = vagasDisponiveis;
	}

	public BigDecimal getPrecoPacote() {
		return precoPacote;
	}

	public void setPrecoPacote(BigDecimal precoPacote) {
		this.precoPacote = precoPacote;
	}

	public String getPasseioSelecionado() {
		return passeioSelecionado;
	}

	public void setPasseioSelecionado(String passeioSelecionado) {
		this.passeioSelecionado = passeioSelecionado;
	}

	public DetalhesPacoteDTO getDetalhePacoteDTO() {
		return detalhePacoteDTO;
	}

	public void setDetalhePacoteDTO(DetalhesPacoteDTO detalhePacoteDTO) {
		this.detalhePacoteDTO = detalhePacoteDTO;
	}

	public List<PasseioDTO> getPasseiosDTO() {
		return passeiosDTO;
	}

	public void setPasseiosDTO(List<PasseioDTO> passeiosDTO) {
		this.passeiosDTO = passeiosDTO;
	}

	public BigDecimal getPrecoDosPasseiosSelecionados() {
		return precoDosPasseiosSelecionados;
	}

	public void setPrecoDosPasseiosSelecionados(
			BigDecimal precoDosPasseiosSelecionados) {
		this.precoDosPasseiosSelecionados = precoDosPasseiosSelecionados;
	}

	public List<DetalhesPacoteDTO> getDetalhesPacote() {
		return detalhesPacote;
	}

	public void setDetalhesPacote(List<DetalhesPacoteDTO> detalhesPacote) {
		this.detalhesPacote = detalhesPacote;
	}

	public PacoteDTO getPacote() {
		return pacote;
	}

	public void setPacote(PacoteDTO pacote) {
		this.pacote = pacote;
	}

	public Boolean getResultado() {
		return resultado;
	}

	public void setResultado(Boolean resultado) {
		this.resultado = resultado;
	}

}
