package br.com.bemlonge.facade.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.converter.PasseioConverter;
import br.com.bemlonge.dao.impl.GuiaDAOImpl;
import br.com.bemlonge.dao.impl.PasseioDAOImpl;
import br.com.bemlonge.dto.PasseioDTO;
import br.com.bemlonge.exception.GuiaException;
import br.com.bemlonge.exception.PasseioException;
import br.com.bemlonge.facade.PasseioServiceFacade;
import br.com.bemlonge.model.Guia;
import br.com.bemlonge.model.Passeio;
import br.com.bemlonge.util.PrecoUtils;

public class PasseioServiceFacadeImpl implements PasseioServiceFacade {

	static final Logger logger = LogManager
			.getLogger(PasseioServiceFacadeImpl.class.getName());


	@Override
	public void cadastrar(String localPartida, String destino,
			BigDecimal preco, int numVagas, String situacao, int idGuia)
			throws PasseioException {

		PasseioDAOImpl passeioDAO = new PasseioDAOImpl();
		PasseioDTO passeioDTO = new PasseioDTO();
		passeioDTO.setLocalPartida(localPartida);
		passeioDTO.setDestino(destino);
		passeioDTO.setPreco(preco);
		passeioDTO.setNumVagas(numVagas);
		passeioDTO.setSituacao(situacao);
		passeioDTO.setIdGuia(idGuia);
		Passeio passeio = passeioDTO.converterParaModel();
		passeioDAO.cadastrar(passeio);

	}

	@Override
	public List<PasseioDTO> listarPasseios() {
		PasseioDAOImpl passeioDAO = new PasseioDAOImpl();
		List<PasseioDTO> passeios = null;
		try {
			passeios = PasseioConverter.converterParaDTO(passeioDAO.listar());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return passeios;
	}

	@Override
	public List<PasseioDTO> listarPasseiosAtivos() {
		PasseioDAOImpl passeioDAO = new PasseioDAOImpl();
		List<PasseioDTO> passeios = null;
		try {
			passeios = PasseioConverter.converterParaDTO(passeioDAO
					.listarPasseiosAtivos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return passeios;
	}

	@Override
	public List<PasseioDTO> filtrarPasseios(String destino, String preco)
			throws PasseioException {
		PasseioDAOImpl passeioDAO = new PasseioDAOImpl();
		String precoPasseios = PrecoUtils.retornarPrecoPasseio(preco);
		List<PasseioDTO> passeios = PasseioConverter
				.converterParaDTO(passeioDAO.filtrarPasseiosAtivos(destino,
						precoPasseios));
		return passeios;
	}

	@Override
	public List<PasseioDTO> filtrarPasseios(String destino)
			throws PasseioException {
		PasseioDAOImpl passeioDAO = new PasseioDAOImpl();
		List<PasseioDTO> passeios = PasseioConverter
				.converterParaDTO(passeioDAO.filtrarPasseio(destino));
		return passeios;
	}

	@Override
	public PasseioDTO filtrarPeloId(int id) throws PasseioException {
		PasseioDAOImpl passeioDAO = new PasseioDAOImpl();
		PasseioDTO passeiosDTO = PasseioConverter.filtrarDTO(passeioDAO
				.listarPasseioGuiaPeloID(id));
		return passeiosDTO;
	}

	@Override
	public List<PasseioDTO> filtrarPeloIdString(String ids)
			throws PasseioException {
		List<PasseioDTO> passeiosDTO = new ArrayList<PasseioDTO>();
		PasseioDAOImpl passeioDAO = new PasseioDAOImpl();
		String passeioTrim = ids.trim();
		String[] passeios = passeioTrim.split(",");

		for (int i = 0; i < passeios.length; i++) {
			Passeio passeio = passeioDAO.buscarPasseioPeloID(passeios[i]);
			PasseioDTO passeioDTO = passeio.converterParaDTO();
			passeiosDTO.add(passeioDTO);
		}
		return passeiosDTO;
	}

	@Override
	public BigDecimal somarPrecoDosPasseiosSelecionados(List<PasseioDTO> passeios) {
		BigDecimal preco = new BigDecimal(0);
		for (PasseioDTO passeioDTO : passeios) {
			preco = preco.add(passeioDTO.getPreco());
		}
		return preco;
	}

	@Override
	public void atualizarPasseio(PasseioDTO passeioDTO) throws PasseioException {
		if (passeioDTO.getSituacao().equals("1")) {
			passeioDTO.setSituacao("ATIVO");
		} else {
			passeioDTO.setSituacao("INATIVO");
		}
		Passeio passeio = passeioDTO.converterParaModel();
		PasseioDAOImpl passeioDAO = new PasseioDAOImpl();
		passeioDAO.atualizar(passeio);
	}

	@Override
	public PasseioDTO buscarPasseio(String id) throws PasseioException,
			GuiaException {
		PasseioDAOImpl passeioDAO = new PasseioDAOImpl();
		GuiaDAOImpl guiaDAO = new GuiaDAOImpl();
		PasseioDTO passeioDTO = null;
		if (!id.equals(" ")) {
			try {
				Passeio passeio = passeioDAO.buscarPasseioPeloID(id);
				passeioDTO = passeio.converterParaDTO();
				Guia guia = guiaDAO.pegarGuiaPeloId(passeioDTO.getIdGuia());
				passeioDTO.setNomeGuia(guia.getNome());
			} catch (NullPointerException ex) {
				throw new PasseioException("Erro ao buscar passeio.");
			}
		}
		return passeioDTO;
	}
}
