package br.com.bemlonge.action;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dto.ClienteDTO;
import br.com.bemlonge.dto.DetalhesPacoteDTO;
import br.com.bemlonge.dto.PacoteDTO;
import br.com.bemlonge.dto.PasseioDTO;
import br.com.bemlonge.enums.TipoPagamentoEnum;
import br.com.bemlonge.exception.ClienteException;
import br.com.bemlonge.facade.impl.ClienteServiceFacadeImpl;
import br.com.bemlonge.util.ConstantesUtils;
import br.com.bemlonge.util.FormatadorEspacosUtils;

import com.opensymphony.xwork2.ActionSupport;

public class ConsultaCadClientePacoteAction extends ActionSupport {

	static final Logger logger = LogManager
			.getLogger(ConsultaCadClientePacoteAction.class.getName());

	private static final long serialVersionUID = 413211637977614310L;

	private ClienteDTO cliente = new ClienteDTO();
	private List<PasseioDTO> passeios;
	private BigDecimal preco;
	private Date dataAgenda;
	private PacoteDTO pacote;
	private DetalhesPacoteDTO detalhePacoteDTO;
	private String cpf;
	private Boolean resultado;
	private int id;
	private List<PasseioDTO> passeiosDTO;
	private BigDecimal precoDosPasseiosSelecionados;
	private Date dataEmbarque;
	private Date dataDesembarque;
	private String passeioSelecionado;
	private String descricao;

	public TipoPagamentoEnum[] getTiposPagamento() {
		return TipoPagamentoEnum.values();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPasseioSelecionado() {
		return passeioSelecionado;
	}

	public void setPasseioSelecionado(String passeioSelecionado) {
		this.passeioSelecionado = passeioSelecionado;
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

	public BigDecimal getPrecoDosPasseiosSelecionados() {
		return precoDosPasseiosSelecionados;
	}

	public void setPrecoDosPasseiosSelecionados(
			BigDecimal precoDosPasseiosSelecionados) {
		this.precoDosPasseiosSelecionados = precoDosPasseiosSelecionados;
	}

	public List<PasseioDTO> getPasseiosDTO() {
		return passeiosDTO;
	}

	public void setPasseiosDTO(List<PasseioDTO> passeiosDTO) {
		this.passeiosDTO = passeiosDTO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean isResultado() {
		return resultado;
	}

	public void setResultado(Boolean resultado) {
		this.resultado = resultado;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public List<PasseioDTO> getPasseios() {
		return passeios;
	}

	public void setPasseios(List<PasseioDTO> passeios) {
		this.passeios = passeios;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String consultaCpf() {
		try {
			if (this.cpf != null) {
				ClienteServiceFacadeImpl facadeCli = new ClienteServiceFacadeImpl();
				FormatadorEspacosUtils form = new FormatadorEspacosUtils();
				String cpfForm = form.removerCaracteres(getCpf());
				this.resultado = facadeCli.validarCadastro(cpfForm);

				this.detalhePacoteDTO = new DetalhesPacoteDTO(
						pacote.getDescricao(),
						pacote.getDataEmbarque(),
						pacote.getDataDesembarque());
				

				if (!this.resultado) {
					try {
						setCliente(facadeCli.buscarClientePorCPF(cpfForm));
						return ConstantesUtils.EXISTENTE;
					} catch (Exception e) {
						return ERROR;
					}
				}
			}
		} catch (ClienteException ex) {

		}
		return SUCCESS;
	}

	public Date getDataAgenda() {
		return dataAgenda;
	}

	public void setDataAgenda(Date dataAgenda) {
		this.dataAgenda = dataAgenda;
	}

	public PacoteDTO getPacote() {
		return pacote;
	}

	public void setPacote(PacoteDTO pacote) {
		this.pacote = pacote;
	}

	public DetalhesPacoteDTO getDetalhePacoteDTO() {
		return detalhePacoteDTO;
	}

	public void setDetalhePacoteDTO(DetalhesPacoteDTO detalhePacoteDTO) {
		this.detalhePacoteDTO = detalhePacoteDTO;
	}

}
