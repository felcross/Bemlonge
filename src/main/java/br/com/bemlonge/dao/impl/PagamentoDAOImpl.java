package br.com.bemlonge.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dao.MySQLDAO;
import br.com.bemlonge.dao.PagamentoDAO;
import br.com.bemlonge.exception.PagamentoException;
import br.com.bemlonge.model.Compra;
import br.com.bemlonge.model.Pagamento;

public class PagamentoDAOImpl implements PagamentoDAO{
	
	static final Logger logger = LogManager.getLogger(PagamentoDAOImpl.class.getName());
	
	MySQLDAO conn = new MySQLDAO();
	

	public void CadastrarCompra(Pagamento pagamento, Compra compra) throws PagamentoException{
		
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO pagamento(tipo,nr_parcelas,compra_id,valor_a_pagar) ");
		query.append("VALUES(?,?,?,?);");
		
		Connection connection = conn.getConnection();
		PreparedStatement stm = null;
		try {
			stm = connection.prepareStatement(query.toString());

			stm.setString(1, pagamento.getTipo().getValorBanco());
			stm.setInt(2, pagamento.getNumeroParcelas());
			stm.setInt(3, compra.getId());
			stm.setBigDecimal(4, pagamento.getValorAPagar());
			stm.execute();
		} catch (SQLException ex) {
			logger.error("Erro ao cadastrar pagamento. (cause): " + ex.getCause());
			throw new PagamentoException("erro ao cadastrar pagamento");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException ex) {
				logger.error("Erro ao fechar conexão. (cause): " + ex.getCause());
				throw new PagamentoException("erro ao fechar conexão(message): " + ex.getMessage());
			}
		}
	}
}
