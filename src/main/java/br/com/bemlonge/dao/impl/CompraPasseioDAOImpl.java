package br.com.bemlonge.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dao.CompraPasseioDAO;
import br.com.bemlonge.dao.MySQLDAO;
import br.com.bemlonge.exception.CompraException;
import br.com.bemlonge.model.Compra;
import br.com.bemlonge.model.Passeio;

public class CompraPasseioDAOImpl implements CompraPasseioDAO {
	
	static final Logger logger = LogManager.getLogger(CompraPasseioDAOImpl.class.getName());

	MySQLDAO conn = new MySQLDAO();
	;

	public void cadastrarCompraPasseio(Compra compra, Passeio passeio) throws CompraException{
		
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO compra_passeio(compra_id,passeio_ID,qnt_passeio) ");
		query.append("VALUES (?,?,?);");
		
		Connection connection = conn.getConnection();
		PreparedStatement stm = null;
		try {
			stm = connection.prepareStatement(query.toString());
			stm.setInt(1, compra.getId());
			stm.setInt(2, passeio.getId());
			stm.setInt(3, 1);
			stm.execute();
		} catch (SQLException ex) {
			logger.error("Erro ao cadastrar compra Passeio.");
			throw new CompraException("Erro ao cadastra compra passeio. (message): " + ex.getMessage());
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException e) {
				logger.error("Erro ao cadastrar compra Passeio.");
				throw new CompraException("Erro ao fechar conexão. (message): " + e.getMessage());
			}
			
		}
	}
}
