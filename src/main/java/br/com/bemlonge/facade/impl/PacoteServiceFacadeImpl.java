package br.com.bemlonge.facade.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.converter.PacoteConverter;
import br.com.bemlonge.dao.impl.PacoteDAOImpl;
import br.com.bemlonge.dto.DetalhesPacoteDTO;
import br.com.bemlonge.dto.PacoteDTO;
import br.com.bemlonge.exception.PacoteException;
import br.com.bemlonge.exception.PasseioException;
import br.com.bemlonge.facade.PacoteServiceFacade;
import br.com.bemlonge.model.Pacote;
import br.com.bemlonge.util.DataUtils;
import br.com.bemlonge.util.PrecoUtils;

public class PacoteServiceFacadeImpl implements PacoteServiceFacade {

	static final Logger logger = LogManager
			.getLogger(PacoteServiceFacadeImpl.class.getName());

	PacoteDTO pacoteDTO = new PacoteDTO();
	PacoteDAOImpl dao = new PacoteDAOImpl();
	DataUtils dataUtils = new DataUtils();

	@Override
	public Boolean cadastrar(String nome, Date data_embarque,
			Date data_desembarque) throws PacoteException {

		// Formatando String de data
		String dataEmbarqueFormatada = dataUtils.formatarData(data_embarque);
		String dataDesembarqueFormatada = dataUtils
				.formatarData(data_desembarque);
		// Convertendo String para Date
		Date dataEmbarqueConvertida = null;
		Date dataDesembarqueConvertida = null;
		try {
			dataEmbarqueConvertida = dataUtils.converterParaData(dataEmbarqueFormatada);
			dataDesembarqueConvertida = dataUtils.converterParaData(dataDesembarqueFormatada);
		} catch (ParseException ex) {
			throw new PacoteException("Erro ao tentar converter para data.");
		}
		// Settando os atributos
		pacoteDTO.setDescricao(nome);
		pacoteDTO.setDataEmbarque(dataEmbarqueConvertida);
		pacoteDTO.setDataDesembarque(dataDesembarqueConvertida);
		// Convertendo de DTO para Pacote
		Pacote pacote = pacoteDTO.converterParaPacote();
		// Salvando no banco
		if (!nome.startsWith(" ")) {
			dao.cadastrar(pacote);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<PacoteDTO> filtro(String descricao, String mes, String preco)
			throws PacoteException {
		String precoCorrespondente = PrecoUtils.retornarPrecoPacote(preco);
		List<PacoteDTO> pacotesDTO = PacoteConverter.filtrarPacoteDTO(dao
				.filtrar(descricao, mes, precoCorrespondente));
		return pacotesDTO;
	}
	
	@Override
	public List<PacoteDTO> filtro(String descricao) throws PacoteException,
			PasseioException {
		List<PacoteDTO> pacotesDTO = PacoteConverter.filtrarPacoteDTO(dao
				.filtrar(descricao));
		return pacotesDTO;
	}
	@Override
	public List<DetalhesPacoteDTO> filtrarPeloId(int id)
			throws PacoteException, PasseioException {
		List<DetalhesPacoteDTO> detalhesPacoteDTO = PacoteConverter
				.filtrarDetalhesPacoteDTO(dao.buscarPacotePeloID(id));
		return detalhesPacoteDTO;
	}
	
	@Override
	public DetalhesPacoteDTO pegarPacotePeloID(Integer id) throws PacoteException {
		PacoteDAOImpl pacoteDAO = new PacoteDAOImpl();
		Pacote pacote = pacoteDAO.buscarPeloID(id);
		DetalhesPacoteDTO detalhesPacoteDTO = pacote.converterParaDetalhesPacoteDTO();
		return detalhesPacoteDTO;
	}
}
