package br.com.bemlonge.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dao.impl.PacoteDAOImpl;
import br.com.bemlonge.dto.DetalhesPacoteDTO;
import br.com.bemlonge.dto.PacoteDTO;
import br.com.bemlonge.exception.PacoteException;
import br.com.bemlonge.model.Pacote;
import br.com.bemlonge.util.ConstantesUtils;

public class PacoteConverter {
	
	static final Logger logger = LogManager.getLogger(PacoteConverter.class.getName());
	
	static PacoteDAOImpl dao = new PacoteDAOImpl();

	public static List<PacoteDTO> converterParaDTO(List<Pacote> pacotes) {
		List<PacoteDTO> pacotesDTO = new ArrayList<PacoteDTO>();
		for (Pacote pacote : pacotes) {
			PacoteDTO pacoteDTO = new PacoteDTO(pacote,true);
			pacotesDTO.add(pacoteDTO);
		}
		return pacotesDTO;
	}
	
	public static List<PacoteDTO> converterParaDTO2(List<Pacote> pacotes) throws PacoteException {
		List<PacoteDTO> pacotesDTO = new ArrayList<PacoteDTO>();
		for (Pacote pacote : pacotes) {
			PacoteDTO pacoteDTO = new PacoteDTO(pacote);
			pacoteDTO.setPreco(dao.precoPacote(pacote.getId()));
			pacoteDTO.setVagas(dao.vagasPacote(pacote.getId()));
			pacotesDTO.add(pacoteDTO);
		}
		return pacotesDTO;
	}
	
	public static List<PacoteDTO> filtrarPacoteDTO(List<Pacote> pacotes) throws PacoteException {
		List<PacoteDTO> pacotesDTO = new ArrayList<PacoteDTO>();
		for (Pacote pacote : pacotes) {
			PacoteDTO pacoteDTO = new PacoteDTO(pacote);
			pacoteDTO.setPreco(dao.precoPacote(pacote.getId()));
			pacoteDTO.setVagas(dao.vagasPacote(pacote.getId()));
			pacotesDTO.add(pacoteDTO);
		}
		return pacotesDTO;
	}
	
	public static List<DetalhesPacoteDTO> filtrarDetalhesPacoteDTO(List<Pacote> pacotes) throws PacoteException {
		List<DetalhesPacoteDTO> detalhesPacotesDTO = new ArrayList<DetalhesPacoteDTO>();
		for (Pacote pacote : pacotes) {
			DetalhesPacoteDTO detalhesPacoteDTO = new DetalhesPacoteDTO(pacote);
			detalhesPacotesDTO.add(detalhesPacoteDTO);
		}
		detalhesPacotesDTO.get(ConstantesUtils.PACOTE).setPreco(dao.precoPacote(pacotes.get(ConstantesUtils.PACOTE).getId()));
		detalhesPacotesDTO.get(ConstantesUtils.PACOTE).setVagas(dao.vagasPacote(pacotes.get(ConstantesUtils.PACOTE).getId()));
		return detalhesPacotesDTO;
	}
	
}
