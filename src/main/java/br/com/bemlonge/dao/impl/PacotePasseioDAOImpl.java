package br.com.bemlonge.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dao.MySQLDAO;
import br.com.bemlonge.dao.PacotePasseioDAO;
import br.com.bemlonge.exception.PacotePasseioException;
import br.com.bemlonge.model.Passeio;

public class PacotePasseioDAOImpl implements PacotePasseioDAO{
	
	static final Logger logger = LogManager.getLogger(PacotePasseioDAOImpl.class.getName());

	MySQLDAO conn = new MySQLDAO();
	

	public void cadastrar(String idPacote, String idPasseio) throws PacotePasseioException {
		
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO pacote_passeio (pacote_id, passeio_id,valor_passeio) ");
		query.append("VALUES (?,?,?);");
	
		Connection connection = conn.getConnection();
		PreparedStatement stm = null;
		try {
			stm = connection.prepareStatement(query.toString());
			stm.setString(1, idPacote);
			stm.setString(2, idPasseio);
			stm.setString(3, "200.00");
			stm.execute();

		} catch (SQLException ex) {
			logger.error("Erro ao cadastrar passeio no pacote. (cause): " + ex.getCause());
			throw new PacotePasseioException("Erro ao cadastrar passeio no pacote");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException ex) {
				logger.error("erro ao fechar conexão. (cause): " + ex.getCause());
				throw new PacotePasseioException("erro ao fechar conexão(message): " + ex.getMessage());
			}
		}

	}

	public List<Passeio> listarPasseiosPacotes(int idPacote) throws PacotePasseioException{
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT local_partida, destino, preco, vagas ");
		query.append("FROM(((pacote p JOIN pacote_passeio pp ON ((p.id = pp.pacote_id))) ");
		query.append("JOIN passeio pa ON ((pp.passeio_id = pa.id)))) ");
		query.append("where p.id = ?;");
		
		Connection connection = conn.getConnection();
		PreparedStatement stm = null;
		
		List<Passeio> passeios = new ArrayList<Passeio>();
		
		try {
			ResultSet result = null;
			stm = connection.prepareStatement(query.toString());
			stm.setInt(1, idPacote);
			result = stm.executeQuery();
			while (result.next()) {
				Passeio passeio = new Passeio();
				passeio.setLocalPartida(result.getString("local_partida"));
				passeio.setDestino(result.getString("destino"));
				passeio.setPreco(result.getBigDecimal("preco"));
				passeio.setNumVagas(result.getInt("vagas"));
				passeios.add(passeio);
			}
			return passeios;

		} catch (SQLException ex) {
			throw new PacotePasseioException("Erro ao cadastrar passeio no pacote");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException e) {
				throw new PacotePasseioException("erro ao fechar conexão(message): " + e.getMessage());
			}
		}
	}

}
