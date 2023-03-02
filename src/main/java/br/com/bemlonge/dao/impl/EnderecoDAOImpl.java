package br.com.bemlonge.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dao.EnderecoDAO;
import br.com.bemlonge.dao.MySQLDAO;
import br.com.bemlonge.dto.EnderecoDTO;
import br.com.bemlonge.exception.EnderecoException;

/**Classe concreta para comunicação de dados do Endereco(Model) com o MYSQL
 * 	
 * */
public class EnderecoDAOImpl implements EnderecoDAO{
	
	static final Logger logger = LogManager.getLogger(EnderecoDAOImpl.class.getName());

	MySQLDAO conn = new MySQLDAO();
	

	/**Método que consulta endereco pelo id do cliente
	 * @param idCliente ID do cliente consultado
	 * @return List<EnderecoDTO> - Lista contendo o endereco do cliente com o mesmo ID
	 * @throws EnderecoException 
	 * */
	public List<EnderecoDTO> consultarEndereco(String idCliente) throws EnderecoException{

		StringBuilder query = new StringBuilder();
		query.append("SELECT cep FROM endereco ");
		query.append("WHERE id_cliente =  ?;");
		
		ResultSet result = null;
		Connection connection = null;
		PreparedStatement stm = null;
		List<EnderecoDTO> enderecos = new ArrayList<EnderecoDTO>();
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setString(1, idCliente);
			result = stm.executeQuery();

			while (result.next()) {
				EnderecoDTO endereco = new EnderecoDTO();
				endereco.setCep(result.getString("cep"));
				enderecos.add(endereco);
			}
		} catch (SQLException ex) {
			throw new EnderecoException("Erro ao consultar endereco");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException e) {
				logger.error("Erro ao consultar endereço.");
				throw new EnderecoException("Erro ao fechar conexão(message): "
						+ e.getMessage());
			}
		}
		return enderecos;
	}
	
	/**Método que cadastra o endereco do cliente no MYSQL
	 * @param endereco Endereco que será cadastrado
	 * @param idCliente ID do cliente que cadastrara esse endereço
	 * @throws EnderecoException 
	 * */
	public void cadastrarEndereco(EnderecoDTO endereco, Integer idCliente) throws EnderecoException{
		
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO endereco (logradouro,bairro,cep,uf,id_cliente) ");
		query.append("VALUES (?,?,?,?,?);");
		
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setString(1, endereco.getLogradouro());
			stm.setString(2, endereco.getBairro());
			stm.setString(3, endereco.getCep());
			stm.setString(4, endereco.getUf());
			stm.setInt(5, idCliente);
			stm.execute();
		} catch (SQLException ex) {
			throw new EnderecoException("Erro ao cadastrar endereco");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException e) {
				logger.error("Erro ao cadastrar endereco.");
				throw new EnderecoException("Erro ao fechar conexão(message): "
						+ e.getMessage());
			}
		}
	}

	/**Método que atualiza o endereco do cliente no MYSQL
	 * @param endereco Endereco que será atualizado
	 * @param idCliente ID do cliente que atualizara esse endereço
	 * @throws EnderecoException 
	 * */
	public void atualizarEndereco(EnderecoDTO endereco, Integer idCliente) throws EnderecoException{
		
		StringBuilder query = new StringBuilder();
		query.append("UPDATE endereco ");
		query.append("SET logradouro = ?, bairro = ?, cep = ?, uf = ? ");
		query.append("WHERE id_cliente=?;");
		
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setString(1, endereco.getLogradouro());
			stm.setString(2, endereco.getBairro());
			stm.setString(3, endereco.getCep());
			stm.setString(4, endereco.getUf());
			stm.setInt(5, idCliente);
			stm.execute();
		} catch (SQLException ex) {
			throw new EnderecoException("Erro ao cadastrar endereco");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException e) {
				logger.error("Erro ao Cadastrar Agenda.");
				throw new EnderecoException("Erro ao fechar conexão(message): "
						+ e.getMessage());
			}
		}
	}

}
