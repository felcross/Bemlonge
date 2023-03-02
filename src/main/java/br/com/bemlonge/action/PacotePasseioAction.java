package br.com.bemlonge.action;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dto.PacoteDTO;
import br.com.bemlonge.dto.PasseioDTO;
import br.com.bemlonge.exception.PacoteException;
import br.com.bemlonge.exception.PacotePasseioException;
import br.com.bemlonge.exception.PasseioException;
import br.com.bemlonge.facade.impl.PasseioPacoteServiceFacadeImpl;

import com.opensymphony.xwork2.ActionSupport;

public class PacotePasseioAction extends ActionSupport {
	
	static final Logger logger = LogManager.getLogger(PacotePasseioAction.class.getName());

	private static final long serialVersionUID = 9212559593965906263L;
	
	private List<PacoteDTO> pacotes;
	private List<PasseioDTO> passeios;
	
	private String pacoteSelecionado;
	private String passeioSelecionado;
	
	public String getPacoteSelecionado() {
		return pacoteSelecionado;
	}

	public void setPacoteSelecionado(String pacoteSelecionado) {
		this.pacoteSelecionado = pacoteSelecionado;
	}

	public String getPasseioSelecionado() {
		return passeioSelecionado;
	}

	public void setPasseioSelecionado(String passeioSelecionado) {
		this.passeioSelecionado = passeioSelecionado;
	}



	public List<PacoteDTO> getPacotes() {
		return pacotes;
	}

	public void setPacotes(List<PacoteDTO> pacotes) {
		this.pacotes = pacotes;
	}

	public List<PasseioDTO> getPasseios() {
		return passeios;
	}

	public void setPasseios(List<PasseioDTO> passeios) {
		this.passeios = passeios;
	}

	@Override
	public String execute(){
		PasseioPacoteServiceFacadeImpl facade = new PasseioPacoteServiceFacadeImpl();
		try {
			this.setPacotes(facade.listarPacotes());
			this.setPasseios(facade.listarPasseios());
		} catch(PacoteException ex) {
			
		} catch(PasseioException ex) {
			
		}
		return SUCCESS;
	}
	
	public String cadastrar(){
		PasseioPacoteServiceFacadeImpl facade = new PasseioPacoteServiceFacadeImpl();
		try {
			facade.cadastrar(pacoteSelecionado, passeioSelecionado);
		} catch (PacotePasseioException ex) {
			logger.error("erro ao cadastrar passeio no pacote. (cause): " + ex.getCause());
			return ERROR;
		}
		return SUCCESS;
	}

}
