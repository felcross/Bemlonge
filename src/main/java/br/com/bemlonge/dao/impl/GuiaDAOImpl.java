package br.com.bemlonge.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dao.GuiaDao;
import br.com.bemlonge.dao.MySQLDAO;
import br.com.bemlonge.dto.GuiaDTO;
import br.com.bemlonge.exception.GuiaException;
import br.com.bemlonge.model.Guia;

public class GuiaDAOImpl implements GuiaDao {
	
	static final Logger logger = LogManager.getLogger(GuiaDAOImpl.class.getName());

	static MySQLDAO conn = new MySQLDAO();

	@Override
	public void cadastrar(Guia guia) throws GuiaException {
		
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO guia (nome,cpf) ");
		query.append("VALUES (?, ?);");

		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setString(1, guia.getNome());
			stm.setString(2, guia.getCpf());
			stm.execute();

		} catch (SQLException ex) {
			logger.error("Erro ao cadastrar pessoa");
			throw new GuiaException("Erro ao cadastrar pessoa");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException e) {
				logger.error("Erro ao fechar conexão");
				throw new GuiaException("Erro ao fechar conexão(message): "
						+ e.getMessage());
			}
		}
	}

	@Override
	public List<Guia> listar() throws GuiaException {
		
	    StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append("FROM guia");
		
		ResultSet result = null;
		Connection connection = null;
		PreparedStatement stm = null;
		List<Guia> guias = new ArrayList<Guia>();
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			result = stm.executeQuery();
			while (result.next()) {
				Guia guia = new Guia();
				guia.setId(result.getInt("id"));
				guia.setCpf(result.getString("cpf"));
				guia.setNome(result.getString("nome"));
				guias.add(guia);
			}
			return guias;
		} catch (SQLException ex) {
			logger.error("Erro ao listar Guias");
			throw new GuiaException("Erro ao listar Guias");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException e) {
				logger.error("Erro ao fechar conexão");
				throw new GuiaException("Erro ao fechar conexão(message): "
						+ e.getMessage());
			}
		}
	}

	@Override
	public List<GuiaDTO> consultarGuiaPorCpf(String cpf) throws GuiaException {
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT nome ");
		query.append("FROM guia ");
		query.append("WHERE cpf = ?;");
	
		ResultSet result = null;
		Connection connection = null;
		PreparedStatement stm = null;
		List<GuiaDTO> guias = new ArrayList<GuiaDTO>();
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setString(1, cpf);
			result = stm.executeQuery();

			while (result.next()) {
				GuiaDTO guia = new GuiaDTO();
				guia.setNome(result.getString("nome"));
				guias.add(guia);
			}
		} catch (SQLException ex) {
			logger.error("Erro ao consultar Nome");
			throw new GuiaException("Erro ao consultar Nome");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException e) {
				logger.error("Erro ao fechar conexão");
				throw new GuiaException("Erro ao fechar conexão(message): "
						+ e.getMessage());
			}
		}
		return guias;
	}

	@Override
	public List<Guia> consultarGuiaPorNome(String nome) throws GuiaException {
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append("FROM guia ");
		query.append("WHERE nome LIKE ?;");
		
		ResultSet result = null;
		Connection connection = null;
		PreparedStatement stm = null;
		List<Guia> guias = new ArrayList<Guia>();
		try {
			if (nome != null) {
				connection = conn.getConnection();
				stm = connection.prepareStatement(query.toString());
				stm.setString(1, '%' + nome + '%');
				result = stm.executeQuery();

				while (result.next()) {
					Guia guia = new Guia();
					guia.setId(result.getInt("id"));
					guia.setNome(result.getString("nome"));
					guia.setCpf(result.getString("cpf"));
					guias.add(guia);
				}
			}
		} catch (SQLException ex) {
			logger.error("Erro ao consultar Nome");
			throw new GuiaException("Erro ao consultar Nome");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException e) {
				logger.error("Erro ao fechar conexão");
				throw new GuiaException("Erro ao fechar conexão(message): "
						+ e.getMessage());
			}
		}
		return guias;
	}

	@Override
	public Guia pegarGuiaPeloId(int id) throws GuiaException {
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT nome ");
		query.append("FROM guia ");
		query.append("WHERE id = ?;");
	
		ResultSet result = null;
		Connection connection = null;
		PreparedStatement stm = null;
		Guia guia = new Guia();
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setInt(1, id);
			result = stm.executeQuery();
			while (result.next()) {
				guia.setNome(result.getString("nome"));
			}
		} catch (SQLException ex) {
			logger.error("Erro ao consultar Id");
			throw new GuiaException("Erro ao consultar Id");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException e) {
				logger.error("Erro ao fechar conexão");
				throw new GuiaException("Erro ao fechar conexão(message): "
						+ e.getMessage());
			}
		}
		return guia;
	}
}
