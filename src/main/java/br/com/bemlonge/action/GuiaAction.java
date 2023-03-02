package br.com.bemlonge.action;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dto.GuiaDTO;
import br.com.bemlonge.facade.impl.GuiaServiceFacadeImpl;
import br.com.bemlonge.util.ConstantesUtils;
import br.com.bemlonge.util.FormatadorEspacosUtils;
import br.com.bemlonge.util.ValidadorCpfUtils;

import com.opensymphony.xwork2.ActionSupport;

public class GuiaAction extends ActionSupport {
	
	static final Logger logger = LogManager.getLogger(GuiaAction.class.getName());
	
	private static final long serialVersionUID = -4970601727226256120L;
	
	private GuiaDTO guiaDto = new GuiaDTO();
	private List<GuiaDTO> guias;

	public String salvarGuia() throws Exception {
		if (this.guiaDto.getCpf()!= null) {
			GuiaServiceFacadeImpl facade = new GuiaServiceFacadeImpl();
			FormatadorEspacosUtils form = new FormatadorEspacosUtils();
			this.guiaDto.setCpf(form.removerCaracteres(guiaDto.getCpf()));
			this.guiaDto.setResultado(facade.validarCadastro(guiaDto));
			this.guiaDto.setValidacaoCpf(ValidadorCpfUtils.isCPF(guiaDto.getCpf()));
			if (this.guiaDto.getValidacaoCpf()) {
				if (this.guiaDto.getResultado()) {
					try {
						facade.cadastrarGuia(guiaDto);
						return SUCCESS;
					} catch (Exception e) {
						return ERROR;
					}
				} else {
					return ConstantesUtils.EXISTENTE;
				}
			} else {
				return ConstantesUtils.EXISTENTE;
			}
		} else {
			this.guiaDto.setResultado(Boolean.TRUE);
			this.guiaDto.setValidacaoCpf(Boolean.TRUE);
			return ConstantesUtils.VOLTAR;
		}
	}
	
	@Override
	public String execute() throws Exception {
		GuiaServiceFacadeImpl facade = new GuiaServiceFacadeImpl();
		guias = facade.listarGuias();
		return SUCCESS;
	}
	
	public String filtrarGuias() throws Exception {
		GuiaServiceFacadeImpl facade = new GuiaServiceFacadeImpl();
		this.setGuias(facade.filtrar(guiaDto.getNome()));
		return SUCCESS;
	}

	public List<GuiaDTO> getGuias() {
		return guias;
	}

	public void setGuias(List<GuiaDTO> guias) {
		this.guias = guias;
	}

	public GuiaDTO getGuiaDto() {
		return guiaDto;
	}

	public void setGuiaDto(GuiaDTO guiaDto) {
		this.guiaDto = guiaDto;
	}

	
}
