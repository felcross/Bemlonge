package br.com.bemlonge.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dao.CompraPacoteDAO;
import br.com.bemlonge.dao.MySQLDAO;
import br.com.bemlonge.exception.CompraException;
import br.com.bemlonge.model.Compra;
import br.com.bemlonge.model.Pacote;

public class CompraPacoteDAOImpl implements CompraPacoteDAO {
	
	static final Logger logger = LogManager.getLogger(CompraPacoteDAOImpl.class.getName());
	
	MySQLDAO conn = new MySQLDAO();
	

	public void cadastrarCompraPacote(Compra compra, Pacote pacote) throws CompraException{
		
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO compra_pacote(compra_id,pacote_id, qnt_pacote) ");
		query.append("VALUES (?,?,?);");
	
		Connection connection = conn.getConnection();
		PreparedStatement stm = null;
		try {
			stm = connection.prepareStatement(query.toString());
			stm.setInt(1, compra.getId());
			stm.setInt(2, pacote.getId());
			stm.setInt(3, 1);
			stm.execute();
		} catch (SQLException ex) {
			logger.error("Erro ao cadastrar compra Pacote.");
			throw new CompraException("Erro ao cadastrar compra pacote. (message): " + ex.getMessage());
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException e) {
				logger.error("Erro ao fechar conexão");
				throw new CompraException("Erro ao fechar conexão. (Message): " + e.getMessage());
			}
		}
	}
}
