package br.com.bemlonge.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MySQLDAO {

	static final Logger logger = LogManager.getLogger(MySQLDAO.class.getName());
	
	public String URL = "jdbc:mysql://localhost:3306/agencia_ebix";
	public String USER = "bemlonge";
	public String PASSWORD = "bemlonge";

	public Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException ex) {
			logger.error("ClassNotFoundException: ", ex);
			throw new RuntimeException("Erro ao se conectar com o banco");
		} catch (SQLException ex) {
			logger.error("SQLException: ", ex);
			throw new RuntimeException("Erro ao se conectar com o banco");
		}
	}

}
