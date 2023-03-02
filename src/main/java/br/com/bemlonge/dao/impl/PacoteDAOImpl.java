package br.com.bemlonge.dao.impl;

import java.math.BigDecimal;
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
import br.com.bemlonge.dao.PacoteDAO;
import br.com.bemlonge.exception.PacoteException;
import br.com.bemlonge.exception.PasseioException;
import br.com.bemlonge.model.Pacote;

public class PacoteDAOImpl implements PacoteDAO {
	
	static final Logger logger = LogManager.getLogger(PacoteDAOImpl.class.getName());

	static MySQLDAO conn = new MySQLDAO();
	

	@Override
	public void cadastrar(Pacote pacote) throws PacoteException {
		
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO pacote (descricao, data_embarque, data_desembarque) ");
		query.append("VALUES (?, ?, ?);");
		
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setString(1, pacote.getDescricao());
			stm.setDate(2, (Date) pacote.getDataEmbarque());
			stm.setDate(3, (Date) pacote.getDataDesembarque());
			stm.execute();
		} catch (SQLException ex) {
			logger.error("SQLException: "+ ex.getMessage());
			throw new PacoteException("Erro ao cadastrar pacote");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException e) {
				throw new PacoteException("Erro ao fechar conexão.");
			}
		}
	}

	@Override
	public List<Pacote> listar() throws PacoteException {
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append("FROM pacote;");
		
		ResultSet result = null;
		Connection connection = null;
		PreparedStatement stm = null;
		
		List<Pacote> pacotes = new ArrayList<Pacote>();
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			result = stm.executeQuery();
			while (result.next()) {
				Pacote pacote = new Pacote();
				pacote.setId(result.getInt("id"));
				pacote.setDescricao(result.getString("descricao"));
				pacote.setDataEmbarque(result.getDate("data_embarque"));
				pacote.setDataDesembarque(result.getDate("data_desembarque"));
				pacotes.add(pacote);
			}
		} catch (SQLException ex) {
			logger.error("SQLException: "+ ex.getMessage());
			throw new PacoteException("Erro ao tentar listar pacote. Mensagem de erro: " + ex.getCause(), 
					"Erro ao consultar pacote, tente mais tarde.");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException ex) {
				logger.error("SQLException: "+ ex.getMessage());
				throw new PacoteException("Erro ao fechar conexão.");
			}
		}
		return pacotes;
	}

	@Override
	public List<Pacote> filtrar(String descricao, String mes, String preco) throws PacoteException {
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT p.id AS id_pacote, ");
		query.append("p.descricao AS descricao, ");
		query.append("p.data_embarque AS embarque, ");
		query.append("p.data_desembarque AS desembarque, ");
		query.append("SUM(ps.preco) AS preco ");
		query.append("FROM(pacote_passeio pp ");
		query.append("JOIN pacote p ");
		query.append("JOIN passeio ps ON ((p.id = pp.pacote_id AND ps.id = pp.passeio_id))) ");
		query.append("WHERE p.descricao ");
		query.append("LIKE ? and EXTRACT(MONTH FROM data_embarque) = ? ");
		query.append("GROUP BY id_pacote HAVING preco <= ?;");

		ResultSet result = null;
		Connection connection = null;
		PreparedStatement stm = null;
		
		List<Pacote> pacotes = new ArrayList<Pacote>();
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setString(1,'%' + descricao + '%');
			stm.setString(2, mes);
			stm.setString(3, preco);
			result = stm.executeQuery();
			while (result.next()) {
				Pacote pacote = new Pacote();
				pacote.setId(result.getInt("id_pacote"));
				pacote.setDescricao(result.getString("descricao"));
				pacote.setDataEmbarque(result.getDate("embarque"));
				pacote.setDataDesembarque(result.getDate("desembarque"));
				pacote.setPreco(result.getBigDecimal("preco"));
				pacotes.add(pacote);
			}
		} catch (SQLException ex) {
			logger.error("SQLException: "+ ex.getMessage());
			throw new PacoteException("Erro ao filtrar pacote.");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException ex) {
				logger.error("SQLException: "+ ex.getMessage());
				throw new PacoteException("Erro ao fechar conexão.");
			}
		}
		return pacotes;
	}
	
	@Override
	public List<Pacote> filtrar(String descricao) throws PacoteException, PasseioException {
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append("FROM pacote ");
		query.append("WHERE descricao LIKE ?;");
		
		ResultSet result = null;
		Connection connection = null;
		PreparedStatement stm = null;
		
		List<Pacote> pacotes = new ArrayList<Pacote>();
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setString(1, '%' + descricao + '%');
			result = stm.executeQuery();
			while (result.next()) {
				Pacote pacote = new Pacote();
				pacote.setId(result.getInt("id"));
				pacote.setDescricao(result.getString("descricao"));
				pacote.setDataEmbarque(result.getDate("data_embarque"));
				pacote.setDataDesembarque(result.getDate("data_desembarque"));
				pacotes.add(pacote);
			}
		} catch (SQLException ex) {
			logger.error("SQLException: "+ ex.getMessage());
			throw new PacoteException("Erro ao filtrar pacotes"+ ex);
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException ex) {
				logger.error("SQLException: "+ ex.getMessage());
				throw new PasseioException("Erro ao fechar conexão");
			}
		}
		return pacotes;
	}

	@Override
	public BigDecimal precoPacote(int id) throws PacoteException {
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT SUM(pa.preco) AS preco ");
		query.append("FROM(`pacote` `p` " );
		query.append("JOIN `pacote_passeio` `pp` ");
		query.append("JOIN `passeio` `pa` ON ((p.id = ? AND p.id = pp.pacote_id AND pp.passeio_id = pa.id))) ");
		query.append("GROUP BY `p`.id;");
		
		ResultSet result = null;
		Connection connection = null;
		PreparedStatement stm = null;
		
		Pacote pacote = new Pacote();
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setInt(1, id);
			result = stm.executeQuery();
			while (result.next()) {
				pacote.setPreco(result.getBigDecimal("preco"));
			}
		} catch (SQLException ex) {
			logger.error("SQLException: "+ ex.getMessage());
			throw new PacoteException("Erro ao buscar o preço do pacote");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException ex) {
				logger.error("SQLException: "+ ex.getMessage());
				throw new PacoteException("Erro ao fechar conexão");
			}
		}
		return pacote.getPreco();
	}

	@Override
	public int vagasPacote(int id) throws PacoteException {
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT MIN(ps.vagas) AS vagas, pp.passeio_id ");
		query.append("FROM pacote ");
		query.append("pc JOIN ");
		query.append("pacote_passeio pp ON ((pc.id = ? AND pc.id = pp.pacote_id)) ");
		query.append("JOIN passeio ps ");
		query.append("ON ((pp.passeio_id = ps.id));");
		
		ResultSet result = null;
		Connection connection = null;
		PreparedStatement stm = null;
		
		Pacote pacote = new Pacote();
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setInt(1, id);
			result = stm.executeQuery();
			while (result.next()) {
				pacote.setVagas(result.getInt("vagas"));
			}
		} catch (SQLException ex) {
			logger.error("SQLException: "+ ex.getMessage());
			throw new PacoteException("Erro ao buscar vagas. (message): " + ex.getMessage());
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException ex) {
				logger.error("SQLException: "+ ex.getMessage());
				throw new PacoteException("Erro ao fechar conexão.");
			}
		}
		return pacote.getVagas();
	}

	@Override
	public Pacote buscarPeloID(int id) throws PacoteException {
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append("FROM pacote ");
		query.append("WHERE id = ?;");
		
		ResultSet result = null;
		Connection connection = null;
		PreparedStatement stm = null;
		
		Pacote pacote = new Pacote();
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setInt(1, id);
			result = stm.executeQuery();

			while (result.next()) {
				pacote.setId(result.getInt("id"));
				pacote.setDescricao(result.getString("descricao"));
				pacote.setDataEmbarque(result.getDate("data_embarque"));
				pacote.setDataDesembarque(result.getDate("data_desembarque"));
			}
		} catch (SQLException ex) {
			logger.error("SQLException: "+ ex.getMessage());
			throw new PacoteException("Erro ao buscar pessoa");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException ex) {
				logger.error("SQLException: "+ ex.getMessage());
				throw new PacoteException("Erro ao fechar conexão.");
			}
		}
		return pacote;
	}

	@Override
	public List<Pacote> buscarPacotePeloID(int id) throws PacoteException, PasseioException {

		StringBuilder query = new StringBuilder();
		query.append("SELECT p.id AS id, p.descricao AS descricao, ");
		query.append("p.data_embarque AS data_embarque, p.data_desembarque AS data_desembarque, ");
		query.append("pp.passeio_id AS passeio_id, pa.destino AS destino, pa.preco AS preco, ");
		query.append("pa.vagas AS vagas FROM(pacote p JOIN pacote_passeio pp ");
		query.append("JOIN passeio pa ON ((p.id = ? AND p.id = pp.pacote_id AND pp.passeio_id = pa.id))) ");
		query.append("GROUP BY pp.passeio_id;");
		
		ResultSet result = null;
		Connection connection = null;
		PreparedStatement stm = null;
		
		PasseioDAOImpl passeioDAO = new PasseioDAOImpl();
		List<Pacote> pacotes = new ArrayList<Pacote>();
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setInt(1, id);
			result = stm.executeQuery();

			while (result.next()) {
				Pacote pacote = new Pacote();
				pacote.setId(result.getInt("id"));
				pacote.setDescricao(result.getString("descricao"));
				pacote.setDataEmbarque(result.getDate("data_embarque"));
				pacote.setDataDesembarque(result.getDate("data_desembarque"));
				pacote.setPasseio(passeioDAO.buscarPasseioPeloID(result
						.getString("passeio_id")));
				pacote.getPasseio().setDestino(result.getString("destino"));
				pacote.getPasseio().setPreco(result.getBigDecimal("preco"));
				pacote.getPasseio().setNumVagas(result.getInt("vagas"));
				pacotes.add(pacote);
			}
		} catch (SQLException ex) {
				logger.error("SQLException: "+ ex.getMessage());
				throw new PacoteException("Erro ao encontrar o pacote.");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException ex) {
				logger.error("SQLException: "+ ex.getMessage());
				throw new PacoteException("Erro ao fechar conexão.");
			}
		}
		return pacotes;
	}
	
	@Override
	public int vagasPreenchidas(Integer id) throws PacoteException {
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT COUNT(cp.pacote_id) AS 'qnt_compras' ");
		query.append("FROM compra_pacote cp ");
		query.append("JOIN pacote p ON p.id = cp.pacote_id AND cp.pacote_id = ? ");
		query.append("GROUP BY 'qnt_compras';");
		
		ResultSet result = null;
		Connection connection = null;
		PreparedStatement stm = null;
		
		Pacote pacote = new Pacote();
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setInt(1, id);
			result = stm.executeQuery();
			while (result.next()) {
				pacote.setVagasPreenchidas(result.getInt("qnt_compras"));
			}
		} catch (SQLException ex) {
			logger.error("SQLException: "+ ex.getMessage());
			throw new PacoteException("Erro ao buscar vagas preenchidas.");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException ex) {
				logger.error("SQLException: "+ ex.getMessage());
				throw new PacoteException("Erro ao fechar conexão.");
			}
		}
		if(pacote.getVagasPreenchidas()==null){
			pacote.setVagasPreenchidas(0);
		}
		return pacote.getVagasPreenchidas();
	}
	
}
