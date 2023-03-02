package br.com.bemlonge.facade.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.converter.PacoteConverter;
import br.com.bemlonge.converter.PasseioConverter;
import br.com.bemlonge.dao.impl.PacoteDAOImpl;
import br.com.bemlonge.dao.impl.PacotePasseioDAOImpl;
import br.com.bemlonge.dao.impl.PasseioDAOImpl;
import br.com.bemlonge.dto.PacoteDTO;
import br.com.bemlonge.dto.PasseioDTO;
import br.com.bemlonge.exception.PacoteException;
import br.com.bemlonge.exception.PacotePasseioException;
import br.com.bemlonge.exception.PasseioException;
import br.com.bemlonge.facade.PasseioPacoteServiceFacade;

public class PasseioPacoteServiceFacadeImpl implements
		PasseioPacoteServiceFacade {

	static final Logger logger = LogManager
			.getLogger(PasseioPacoteServiceFacadeImpl.class.getName());

	@Override
	public void cadastrar(String idPacote, String idPasseio)
			throws PacotePasseioException {
		PacotePasseioDAOImpl dao = new PacotePasseioDAOImpl();
		String idPasseioTrim = idPasseio.trim();
		String[] idsPasseio = idPasseioTrim.split(",");
		for (int i = 0; i < idsPasseio.length; i++) {
			dao.cadastrar(idPacote, idsPasseio[i]);
		}
	}

	@Override
	public List<PasseioDTO> listarPasseios() throws PasseioException {
		PasseioDAOImpl passeioDao = new PasseioDAOImpl();
		List<PasseioDTO> passeios = null;
		passeios = PasseioConverter.converterParaDTO(passeioDao.listar()); 
		return passeios;
	}

	@Override
	public List<PacoteDTO> listarPacotes() throws PacoteException {
		PacoteDAOImpl pacoteDAO = new PacoteDAOImpl();
		List<PacoteDTO> pacotes = null;
		pacotes = PacoteConverter.converterParaDTO2(pacoteDAO.listar());
		return pacotes;
	}

}
