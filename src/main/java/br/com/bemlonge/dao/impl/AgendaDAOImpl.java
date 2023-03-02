package br.com.bemlonge.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dao.AgendaDAO;
import br.com.bemlonge.dao.MySQLDAO;
import br.com.bemlonge.exception.AgendaException;
import br.com.bemlonge.model.Agenda;
import br.com.bemlonge.util.DataUtils;

public class AgendaDAOImpl implements AgendaDAO{
	
	static final Logger logger = LogManager.getLogger(AgendaDAOImpl.class.getName());
	
	MySQLDAO conn = new MySQLDAO();
	

	public void cadastrarCompra(Agenda agenda) throws AgendaException{
		
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO agenda (compra_passeio_id,data) " );
		query.append("VALUES (?,?);");
		
		Connection connection = conn.getConnection();
		PreparedStatement stm = null;
		try {
			stm = connection.prepareStatement(query.toString());
			
			stm.setInt(1, agenda.getIdCompraPasseio());
			stm.setString(2, DataUtils.formatarDataEHora(agenda.getData()));
			stm.execute();
		} catch (SQLException ex) {
			throw new AgendaException("erro ao cadastrar agenda");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException e) {
				logger.error("Erro ao Cadastrar Agenda.");
				throw new AgendaException("erro ao fechar conexão(message): " + e.getMessage());
			}
			
		}
	}
}
