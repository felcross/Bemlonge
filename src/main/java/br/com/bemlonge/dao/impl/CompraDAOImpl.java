package br.com.bemlonge.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dao.CompraDAO;
import br.com.bemlonge.dao.MySQLDAO;
import br.com.bemlonge.exception.CompraException;
import br.com.bemlonge.model.Cliente;
import br.com.bemlonge.model.Compra;
import br.com.bemlonge.util.DataUtils;

public class CompraDAOImpl implements CompraDAO{
	
	static final Logger logger = LogManager.getLogger(CompraDAOImpl.class.getName());

	MySQLDAO conn = new MySQLDAO();
	

	public void cadastrarCompra(Compra compra, Cliente cliente) throws CompraException{
		
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO compra(data_compra,id_cliente) ");
		query.append("VALUES (?,?);");
		Connection connection = conn.getConnection();
		PreparedStatement stm = null;
		try {
			stm = connection.prepareStatement(query.toString());

			stm.setString(1,
					DataUtils.formatarDataEHora(compra.getDataCompra()));
			stm.setInt(2, cliente.getId());
			stm.execute();
		} catch (SQLException ex) {
			logger.error("Erro ao cadastrar compra");
			throw new CompraException("Erro ao cadastra compra");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException e) {
				logger.error("Erro ao fechar conexão");
				throw new CompraException("Erro ao fechar conexão(message): "
						+ e.getMessage());
			}
		}
	}

	public Compra buscarCompra(Date dataCompra, Integer idCliente) throws CompraException{
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT * FROM compra ");
		query.append("WHERE data_compra = ? ");
		query.append("AND id_cliente = ?;");
		
		Connection connection = conn.getConnection();
		PreparedStatement stm = null;

		Compra compra = null;

		try {
			stm = connection.prepareStatement(query.toString());

			stm.setString(1, DataUtils.formatarDataEHora(dataCompra));
			stm.setInt(2, idCliente);

			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				compra = new Compra(rs.getInt("id"), rs.getInt("id_cliente"),
						rs.getDate("data_compra"));
			}

		} catch (SQLException ex) {
			logger.error("Erro ao Consultar Compras.");
			throw new CompraException("Erro ao consultar compras");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException e) {
				logger.error("Erro ao fechar conexão.");
				throw new CompraException("Erro ao fechar conexão(message): "
						+ e.getMessage());
			}
		}

		return compra;
	}

	public Integer buscarCompraPasseioId(Compra compra) throws CompraException{
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT * FROM compra_passeio ");
		query.append("WHERE compra_id = ?;");
		
		Connection connection = conn.getConnection();
		PreparedStatement stm = null;

		Integer compraPasseioId = null;

		try {
			stm = connection.prepareStatement(query.toString());

			stm.setInt(1, compra.getId());

			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				compraPasseioId = rs.getInt("id");
			}

		} catch (SQLException ex) {
			logger.error("Erro ao consultar compras.");
			throw new CompraException("Erro ao consultar compras");
		} finally {
			try {
				stm.close();
				connection.close();
			} catch (SQLException e) {
				logger.error("Erro ao fechar conexão.");
				throw new CompraException("Erro ao fechar conexão(message): "
						+ e.getMessage());
			}
		}

		return compraPasseioId;
	}
}
