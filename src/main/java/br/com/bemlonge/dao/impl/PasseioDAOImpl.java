package br.com.bemlonge.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dao.MySQLDAO;
import br.com.bemlonge.dao.PasseioDAO;
import br.com.bemlonge.exception.PasseioException;
import br.com.bemlonge.model.Passeio;

public class PasseioDAOImpl implements PasseioDAO {
	
	static final Logger logger = LogManager.getLogger(PasseioDAOImpl.class.getName());

	static MySQLDAO conn = new MySQLDAO();
	
	@Override
	public void cadastrar(Passeio passeio) throws PasseioException {
		
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO passeio (local_partida,destino,preco,vagas,status,id_guia) ");
		query.append("VALUES (?,?,?,?,?,?)");
		
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setString(1, passeio.getLocalPartida());
			stm.setString(2, passeio.getDestino());
			stm.setString(3, passeio.getPreco().toString());
			stm.setString(4, Integer.toString(passeio.getNumVagas()));
			stm.setString(5, "ATIVO");
			stm.setString(6, Integer.toString(passeio.getIdGuia()));
			stm.execute();
		} catch (SQLException ex) {
			logger.error(ex.getCause());
			throw new PasseioException("Erro ao cadastrar passeio");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException ex) {
				logger.error(ex.getCause());
				throw new PasseioException("Erro ao fechar conexão(message): "
						+ ex.getMessage());
			}
		}
	}
	
	@Override
	public void atualizar(Passeio passeio) throws PasseioException {
		
		StringBuilder query = new StringBuilder();
		query.append("UPDATE passeio ");
		query.append("SET `status`= ? ");
		query.append("WHERE id = ?;");
		
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setString(1, passeio.getSituacao());
			stm.setInt(2, passeio.getId());
			stm.execute();
		} catch(SQLException ex){
			logger.error(ex.getCause());
			throw new PasseioException("Erro ao atualizar passeio");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException ex) {
				logger.error(ex.getCause());
				throw new PasseioException("Erro ao fechar conexão.");
			}
		}
	}

	@Override
	public List<Passeio> listar() throws PasseioException {
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT passeio.*,guia.nome ");
		query.append("FROM passeio ");
		query.append("JOIN guia ON ((passeio.id_guia = guia.id));");
		
		ResultSet result = null;
		List<Passeio> passeios = new ArrayList<Passeio>();
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			result = stm.executeQuery();
			while (result.next()) {
				Passeio passeio = new Passeio();
				passeio.setId(result.getInt("id"));
				passeio.setDestino(result.getString("destino"));
				passeio.setIdGuia(result.getInt("id_guia"));
				passeio.setLocalPartida(result.getString("local_partida"));
				passeio.setNomeGuia(result.getString("nome"));
				passeio.setNumVagas(result.getInt("vagas"));
				passeio.setPreco(result.getBigDecimal("preco"));
				passeio.setSituacao(result.getString("status"));
				passeios.add(passeio);
			}
		} catch (SQLException ex) {
			logger.error(ex.getCause());
			throw new PasseioException("Erro listar Passeios");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException ex) {
				logger.error(ex.getCause());
				throw new PasseioException("Erro ao fechar conexão(message): "
						+ ex.getMessage());
			}
		}
		return passeios;
	}
	
	@Override
	public List<Passeio> listarPasseiosAtivos() throws PasseioException{
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT passeio.*,guia.nome ");
		query.append("FROM passeio ");
		query.append("JOIN guia ON ((passeio.id_guia = guia.id)) ");
		query.append("WHERE passeio.status = 'ATIVO';");
		
		ResultSet result = null;
		List<Passeio> passeios = new ArrayList<Passeio>();
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			result = stm.executeQuery();
			while (result.next()) {
				Passeio passeio = new Passeio();
				passeio.setId(result.getInt("id"));
				passeio.setDestino(result.getString("destino"));
				passeio.setIdGuia(result.getInt("id_guia"));
				passeio.setLocalPartida(result.getString("local_partida"));
				passeio.setNomeGuia(result.getString("nome"));
				passeio.setNumVagas(result.getInt("vagas"));
				passeio.setPreco(result.getBigDecimal("preco"));
				passeio.setSituacao(result.getString("status"));
				passeios.add(passeio);
			}
		} catch (SQLException ex) {
			logger.error(ex.getCause());
			throw new PasseioException("Erro listar Passeios");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException ex) {
				logger.error(ex.getCause());
				throw new PasseioException("Erro ao fechar conexão(message): "
						+ ex.getMessage());
			}
		}
		return passeios;
	}
	
	@Override
	public Passeio buscarPasseioPeloID(String id) throws PasseioException {
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append("FROM passeio ");
		query.append("WHERE id = ?;");
		
		ResultSet result = null;
		Connection connection = null;
		PreparedStatement stm = null;

		Passeio passeio = new Passeio();
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setString(1, id);
			result = stm.executeQuery();
			while (result.next()) {
				passeio.setId(result.getInt("id"));
				passeio.setLocalPartida(result.getString("local_partida"));
				passeio.setDestino(result.getString("destino"));
				passeio.setPreco(result.getBigDecimal("preco"));
				passeio.setNumVagas(result.getInt("vagas"));
				passeio.setSituacao(result.getString("status"));
				passeio.setIdGuia(result.getInt("id_guia"));
			}
		} catch (SQLException ex) {
			logger.error(ex.getCause());
			throw new PasseioException("Erro ao buscar passeio");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException ex) {
				logger.error(ex.getCause());
				throw new PasseioException("Erro ao fechar conexão");
			}
		}
		return passeio;
	}

	@Override
	public Passeio listarPasseioGuiaPeloID(Integer id) throws PasseioException {
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT passeio.*,guia.nome ");
		query.append("FROM passeio, guia ");
		query.append("WHERE ((passeio.id_guia = guia.id)) AND passeio.id =?;");
		
		ResultSet result = null;
		Connection connection = null;
		PreparedStatement stm = null;
		
		Passeio passeio = new Passeio();
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setInt(1, id);
			result = stm.executeQuery();

			while (result.next()) {
				passeio.setId(result.getInt("id"));
				passeio.setDestino(result.getString("destino"));
				passeio.setIdGuia(result.getInt("id_guia"));
				passeio.setNomeGuia(result.getString("nome"));
				passeio.setLocalPartida(result.getString("local_partida"));
				passeio.setNumVagas(result.getInt("vagas"));
				passeio.setPreco(result.getBigDecimal("preco"));
				passeio.setSituacao(result.getString("status"));
			}
		} catch (SQLException ex) {
			logger.error(ex.getCause());
			throw new PasseioException("Erro Listar Passeio por Id");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException ex) {
				logger.error(ex.getCause());
				throw new PasseioException("Erro ao fechar conexão(message): "
						+ ex.getMessage());
			}
		}
		return passeio;
	}

	
	public static int vagasPreenchidas(int id, Date data) throws PasseioException {
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT COUNT(cp.passeio_id) AS 'qnt_compra' ");
		query.append("FROM compra_passeio cp ");
		query.append("JOIN agenda a ON (cp.passeio_ID = ? AND a.data = ?) ");
		query.append("GROUP BY cp.passeio_ID;");
		
		ResultSet result = null;
		Connection connection = null;
		PreparedStatement stm = null;
		
		Passeio passeio = new Passeio();
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setInt(1, id);
			stm.setDate(2, data);
			result = stm.executeQuery();
			while (result.next()) {
				passeio.setVagasPreenchidas(result.getInt("qnt_compra"));
			}
		} catch (SQLException ex) {
			logger.error(ex.getCause());
			throw new PasseioException("Erro ao buscar as vagas preenchidas.");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException ex) {
				logger.error(ex.getCause());
				throw new PasseioException("Erro ao fechar conexão.");
			}
		}

		return passeio.getVagasPreenchidas();
	}

	@Override
	public List<Passeio> filtrarPasseio(String destino, String preco) throws PasseioException {
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append("FROM passeio ");
		query.append("WHERE preco <=? AND destino LIKE ?;");
		
		ResultSet result = null;
		Connection connection = null;
		PreparedStatement stm = null;
		
		List<Passeio> passeios = new ArrayList<Passeio>();
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setString(1, preco);
			stm.setString(2, '%' + destino + '%');
			result = stm.executeQuery();
			while (result.next()) {
				Passeio passeio = new Passeio();
				passeio.setId(result.getInt("id"));
				passeio.setDestino(result.getString("destino"));
				passeio.setIdGuia(result.getInt("id_guia"));
				passeio.setLocalPartida(result.getString("local_partida"));
				passeio.setNumVagas(result.getInt("vagas"));
				passeio.setPreco(result.getBigDecimal("preco"));
				passeio.setSituacao(result.getString("status"));
				passeios.add(passeio);
			}
		} catch (SQLException ex) {
			logger.error(ex.getCause());
			throw new PasseioException("Erro ao filtrar passeios");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException ex) {
				logger.error(ex.getCause());
				throw new PasseioException("Erro ao fechar conexão(message): "
						+ ex.getMessage());
			}
		}
		return passeios;
	}
	
	public List<Passeio> filtrarPasseiosAtivos(String destino, String preco) throws PasseioException {
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append("FROM passeio ");
		query.append("WHERE preco <=? AND destino LIKE ? AND status = 'ATIVO';");
		
		ResultSet result = null;
		Connection connection = null;
		PreparedStatement stm = null;
		
		List<Passeio> passeios = new ArrayList<Passeio>();
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setString(1, preco);
			stm.setString(2, '%' + destino + '%');
			result = stm.executeQuery();
			while (result.next()) {
				Passeio passeio = new Passeio();
				passeio.setId(result.getInt("id"));
				passeio.setDestino(result.getString("destino"));
				passeio.setIdGuia(result.getInt("id_guia"));
				passeio.setLocalPartida(result.getString("local_partida"));
				passeio.setNumVagas(result.getInt("vagas"));
				passeio.setPreco(result.getBigDecimal("preco"));
				passeio.setSituacao(result.getString("status"));
				passeios.add(passeio);
			}
		} catch (SQLException ex) {
			logger.error(ex.getCause());
			throw new PasseioException("Erro ao filtrar passeios");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException ex) {
				logger.error(ex.getCause());
				throw new PasseioException("Erro ao fechar conexão(message): "
						+ ex.getMessage());
			}
		}
		return passeios;
	}
	
	@Override
	public List<Passeio> filtrarPasseio(String destino) throws PasseioException {
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append("FROM passeio ");
		query.append("WHERE destino LIKE ?;");
		
		ResultSet result = null;
		Connection connection = null;
		PreparedStatement stm = null;
		
		List<Passeio> passeios = new ArrayList<Passeio>();
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setString(1, '%' + destino + '%');
			result = stm.executeQuery();
			while (result.next()) {
				Passeio passeio = new Passeio();
				passeio.setId(result.getInt("id"));
				passeio.setDestino(result.getString("destino"));
				passeio.setIdGuia(result.getInt("id_guia"));
				passeio.setLocalPartida(result.getString("local_partida"));
				passeio.setNumVagas(result.getInt("vagas"));
				passeio.setPreco(result.getBigDecimal("preco"));
				passeio.setSituacao(result.getString("status"));
				passeios.add(passeio);
			}
		} catch (SQLException ex) {
			logger.error(ex.getCause());
			throw new PasseioException("Erro ao filtrar passeios");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException ex) {
				logger.error(ex.getCause());
				throw new PasseioException("Erro ao fechar conexão(message): "
						+ ex.getMessage());
			}
		}
		return passeios;
	}

	@Override
	public List<Passeio> listarComLimit(Integer limit, Integer offSet) throws PasseioException {
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append("FROM passeio LIMIT ? OFFSET ?;");
		
		ResultSet result = null;
		Connection connection = null;
		PreparedStatement stm = null;
		
		List<Passeio> passeios = new ArrayList<Passeio>();
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setInt(1, limit);
			stm.setInt(2, offSet);
			result = stm.executeQuery();

			while (result.next()) {

				Passeio passeio = new Passeio();
				passeio.setId(result.getInt("id"));
				passeio.setLocalPartida(result.getString("local_partida"));
				passeio.setDestino(result.getString("destino"));
				passeio.setPreco(result.getBigDecimal("preco"));
				passeio.setNumVagas(result.getInt("vagas"));
				passeio.setSituacao(result.getString("status"));
				passeio.setIdGuia(result.getInt("id_guia"));
				passeios.add(passeio);
			}
		} catch (SQLException ex) {
			logger.error(ex.getCause());
			throw new PasseioException("Erro ao listar Passeios");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException ex) {
				logger.error(ex.getCause());
				throw new PasseioException("Erro ao fechar conexão(message): "
						+ ex.getMessage());
			}
		}
		return passeios;
	}

}
