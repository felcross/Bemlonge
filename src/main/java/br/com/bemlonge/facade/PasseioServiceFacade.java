package br.com.bemlonge.facade;

import java.math.BigDecimal;
import java.util.List;

import br.com.bemlonge.dto.PasseioDTO;
import br.com.bemlonge.exception.GuiaException;
import br.com.bemlonge.exception.PasseioException;

public interface PasseioServiceFacade {

	void cadastrar(String localPartida, String destino, BigDecimal preco,
			int numVagas, String situacao, int idGuia) throws PasseioException;

	List<PasseioDTO> listarPasseios() throws PasseioException;

	void atualizarPasseio(PasseioDTO passeioDTO) throws PasseioException;

	PasseioDTO buscarPasseio(String id) throws PasseioException, GuiaException;

	BigDecimal somarPrecoDosPasseiosSelecionados(List<PasseioDTO> passeios);

	List<PasseioDTO> filtrarPeloIdString(String ids) throws PasseioException;

	PasseioDTO filtrarPeloId(int id) throws PasseioException;

	List<PasseioDTO> filtrarPasseios(String destino) throws PasseioException;

	List<PasseioDTO> filtrarPasseios(String destino, String preco)
			throws PasseioException;

	List<PasseioDTO> listarPasseiosAtivos();
}
