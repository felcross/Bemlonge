package br.com.bemlonge.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dao.ClienteDAO;
import br.com.bemlonge.dao.MySQLDAO;
import br.com.bemlonge.dto.ClienteDTO;
import br.com.bemlonge.enums.TipoPagamentoEnum;
import br.com.bemlonge.exception.ClienteException;
import br.com.bemlonge.model.Cliente;
import br.com.bemlonge.model.HistoricoPacotePasseio;

/**Classe concreta para comunicação de dados do Cliente(Model) com o MYSQL
 * 	
 * */
public class ClienteDAOImpl implements ClienteDAO{
	
	static final Logger logger = LogManager.getLogger(ClienteDAOImpl.class.getName());

	MySQLDAO conn = new MySQLDAO();
	

	/**Método que cadastra cliente no MYSQL
	 * @param cliente Cliente que será cadastrado
	 * */
	public void cadastrar(Cliente cliente) throws ClienteException{
		
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO cliente (nome,cpf,rg,org_exp,telefone,email) ");
		query.append("VALUES (?,?,?,?,?,?);");
		
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getCpf());
			stm.setString(3, cliente.getRg());
			stm.setString(4, cliente.getOrgExpedidor());
			stm.setString(5, cliente.getTelefone());
			stm.setString(6, cliente.getEmail());
			stm.execute();
		} catch (SQLException ex) {
			throw new ClienteException("Erro ao cadastrar pessoa");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException e) {
				throw new ClienteException("Erro ao fechar conexão(message): "
						+ e.getMessage());
			}
		}
	}
	
	/**Método que atualiza o cliente no MYSQL
	 * @param cliente Novos dados do cliente que será atualizado
	 * */
	public void atualizar(Cliente cliente) throws ClienteException{
	
		StringBuilder query = new StringBuilder();
		query.append("UPDATE cliente SET nome = ?, telefone = ?, email= ? ");
		query.append("WHERE cpf = ?");
		
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getTelefone());
			stm.setString(3, cliente.getEmail());
			stm.setString(4, cliente.getCpf());
			stm.execute();
		} catch (SQLException ex) {
			throw new ClienteException("Erro ao atualizar pessoa");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException e) {
				throw new ClienteException("Erro ao fechar conexão(message): "
						+ e.getMessage());
			}
		}
	}

	/**Método que consulta o id do cliente pelo seu CPF no MYSQL
	 * @param cpf Cpf utilizado para consulta
	 * @return int - ID do cliente com o cpf consultado
	 * */
	public Integer consultarId(String cpf) throws ClienteException{
		Connection connection = conn.getConnection();
		PreparedStatement stm;
		ResultSet rs;
		Integer idCliente;
		try {
			stm = connection
					.prepareStatement("SELECT id FROM cliente WHERE cpf = ?");
			stm.setString(1, cpf);
			rs = stm.executeQuery();
			if (rs.next()) {
				idCliente = Integer.parseInt(rs.getString("id"));
				return idCliente;
			} else {
				return 0;
			}
		} catch (SQLException ex) {
			return 0;
		}
	}

	/**Método que consulta o cliente pelo seu CPF no MYSQL
	 * @param cpf Cpf utilizado para consulta
	 * @return Cliente - Cliente com o cpf consultado
	 * */
	public Cliente consultarCPF(String cpf) throws ClienteException{
		Connection connection = conn.getConnection();
		PreparedStatement stm;
		ResultSet rs;
		Cliente cliente = new Cliente();
		try {
			stm = connection
					.prepareStatement("SELECT * FROM cliente WHERE cpf = ?");
			stm.setString(1, cpf);
			rs = stm.executeQuery();
			if (rs.next()) {
				cliente.setCpf(rs.getString("cpf"));
				cliente.setNome(rs.getString("nome"));
				cliente.setRg(rs.getString("rg"));
				cliente.setOrgExpedidor(rs.getString("org_exp"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setEmail(rs.getString("email"));
				cliente.setId(Integer.parseInt(rs.getString("id")));
				return cliente;
			} else {
				return null;
			}
		} catch (SQLException ex) {
			return null;
		}
	}

	/**Método que consulta o nome do cliente pelo CPF no MYSQL
	 * @param cpf CPF do cliente pesquisado
	 * @return List<ClienteDTO> - Lista(máximo 1) contendo o cliente com o CPF consultado
	 * */
	public List<ClienteDTO> listarPorCPF(String cpf) throws ClienteException{
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT nome FROM cliente ");
		query.append("WHERE cpf = ?;");
	
		ResultSet result = null;
		Connection connection = null;
		PreparedStatement stm = null;
		List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setString(1, cpf);
			result = stm.executeQuery();

			while (result.next()) {
				ClienteDTO cliente = new ClienteDTO();
				cliente.setNome(result.getString("nome"));
				clientes.add(cliente);
			}
		} catch (SQLException ex) {
			throw new ClienteException("Erro ao listar pessoa por cpf");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException e) {
				throw new ClienteException("Erro ao fechar conexão(message): "
						+ e.getMessage());
			}
		}
		return clientes;
	}

	/**Método que resgata historico de pacote do cliente no MYSQL
	 * @param cpf Cpf do cliente que será realizado o historico de pacotes,
	 * @return List<HistoricoPacotePasseio> - Lista contendo o historico de pacotes do cliente consultado
	 * */
	public List<HistoricoPacotePasseio> listarHistoricoCompraPacote(String cpf) throws ClienteException{

		StringBuilder query = new StringBuilder();
		query.append("SELECT cpf, data_compra, data_embarque, nr_parcelas, tipo, valor_a_pagar, descricao ");
		query.append("FROM compra_pacote cp ");
		query.append("JOIN compra c ON c.id = cp.compra_id ");
		query.append("JOIN cliente cl ON cl.id = c.id_cliente ");
		query.append("JOIN pacote p ON p.id = cp.pacote_id ");
		query.append("JOIN pagamento pag ON pag.compra_id = c.id ");
		query.append("WHERE cl.cpf = ? ");
		query.append("GROUP BY data_compra;");
		
		logger.error(query.toString());
		
		ResultSet result = null;
		List<HistoricoPacotePasseio> historicoPacotes = new ArrayList<HistoricoPacotePasseio>();
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setString(1, cpf);
			result = stm.executeQuery();
			while (result.next()) {

				HistoricoPacotePasseio historicoPacote = new HistoricoPacotePasseio();
				historicoPacote.setCpf(result.getString("cpf"));
				historicoPacote.setDataCompra(result.getDate("data_compra"));
				historicoPacote.setDataEmbarque(result.getDate("data_embarque"));
				historicoPacote.setTipo(TipoPagamentoEnum.valueOf(result
						.getString("tipo")));
				historicoPacote.setValorAPagar(result.getBigDecimal("valor_a_pagar"));
				historicoPacote.setDescricao(result.getString("descricao"));
				historicoPacote.setOrdem(1);
				historicoPacote.setNumeroParcelas(result.getInt("nr_parcelas"));
				historicoPacotes.add(historicoPacote);
			}
		} catch (SQLException ex) {
			throw new ClienteException("Erro listar historico de compra pacote");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException e) {
				throw new ClienteException("Erro ao fechar conexão(message): "
						+ e.getMessage());
			}
		}
		return historicoPacotes;
	}

	/**Método que resgata historico de passeio do cliente no MYSQL
	 * @param cpf Cpf do cliente que será realizado o historico de passeio
	 * @return List<HistoricoPacotePasseio> - Lista contendo o historico de passeios do cliente consultado
	 * */
	public List<HistoricoPacotePasseio> listarHistoricoCompraPasseio(String cpf) throws ClienteException{
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT cpf, data, destino, nr_parcelas, preco, tipo, data_compra ");
		query.append("FROM agenda a ");
		query.append("JOIN compra_passeio cp ON cp.id = a.compra_passeio_id ");
		query.append("JOIN compra c ON c.id = cp.compra_id ");
		query.append("JOIN cliente cl ON cl.id = c.id_cliente ");
		query.append("JOIN passeio p ON p.id = cp.passeio_ID ");
		query.append("JOIN pagamento pag ON c.id = pag.compra_id ");
		query.append("WHERE cl.cpf = ? ");
		query.append("GROUP BY data_compra;");
		
		logger.error(query.toString());

		ResultSet result = null;
		List<HistoricoPacotePasseio> historicoPasseios = new ArrayList<HistoricoPacotePasseio>();
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setString(1, cpf);
			result = stm.executeQuery();
			while (result.next()) {

				HistoricoPacotePasseio historicoPasseio = new HistoricoPacotePasseio();
				historicoPasseio.setCpf(result.getString("cpf"));
				historicoPasseio.setDataCompra(result.getDate("data_compra"));
				historicoPasseio.setDataEmbarque(result.getDate("data"));
				historicoPasseio.setTipo(TipoPagamentoEnum.valueOf(result
						.getString("tipo")));
				historicoPasseio.setValorAPagar(result.getBigDecimal("preco"));
				historicoPasseio.setDescricao(result.getString("destino"));
				historicoPasseio.setOrdem(2);
				historicoPasseio.setNumeroParcelas(result.getInt("nr_parcelas"));
				historicoPasseios.add(historicoPasseio);
			}
		} catch (SQLException ex) {
			throw new ClienteException("Erro ao listar historico de compra passeio");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException e) {
				throw new ClienteException("Erro ao fechar conexão(message): "
						+ e.getMessage());
			}
		}
		return historicoPasseios;
	}
	
	/**Método que resgata dados cliente pelo cpf no MYSQL
	 * @param cpfConsultado Cpf do cliente consultado para resgatar seus dados
	 * @return ClienteDTO - Cliente com o cpf consultado
	 * */
	public ClienteDTO consultarCliente(String cpfConsultado) throws ClienteException{
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT nome, email, telefone, cpf, rg, org_exp, cep, logradouro, uf, bairro ");
		query.append("FROM `agencia_ebix`.`endereco` ");
		query.append("JOIN cliente ON cliente.id = endereco.id_cliente ");
		query.append("WHERE cliente.cpf= ?;");
		
		ResultSet result = null;
		Connection connection = null;
		PreparedStatement stm = null;
		ClienteDTO cliente = new ClienteDTO();
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setString(1, cpfConsultado);
			result = stm.executeQuery();
			while (result.next()) {
				cliente.getEndereco().setLogradouro(result.getString("logradouro"));
				cliente.getEndereco().setCep(result.getString("cep"));
				cliente.getEndereco().setBairro(result.getString("bairro"));
				cliente.getEndereco().setUf(result.getString("uf"));
				cliente.setNome(result.getString("nome"));
				cliente.setEmail(result.getString("email"));
				cliente.setTelefone(result.getString("telefone"));
				cliente.setCpf(result.getString("cpf"));
				cliente.setRg(result.getString("rg"));
				cliente.setOrgExpedidor(result.getString("org_exp"));
			}

		} catch (SQLException ex) {
			throw new ClienteException("Erro ao consultar pessoa");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException e) {
				throw new ClienteException("Erro ao fechar conexão(message): "
						+ e.getMessage());
			}
		}
		return cliente;
	}
	
	/**
	 * Retorna uma lista de clientes 
	 * @param limit
	 * @param ofsset
	 * @return
	 * @throws Exception
	 */
	public List<Cliente> listarClientes(Integer limit, Integer ofsset) throws ClienteException{
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append("FROM cliente ");
		query.append("LIMIT ? ");
		query.append("OFFSET ?;");
		
		ResultSet result = null;
		Connection connection = null;
		PreparedStatement stm = null;
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setInt(1, limit);
			stm.setInt(2, ofsset);
			result = stm.executeQuery();
			
			while (result.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(result.getInt("id"));
				cliente.setCpf(result.getString("cpf"));
				cliente.setNome(result.getString("nome"));
				cliente.setRg(result.getString("rg"));
				cliente.setTelefone(result.getString("telefone"));
				cliente.setOrgExpedidor(result.getString("org_exp"));
				cliente.setEmail(result.getString("email"));
				
				clientes.add(cliente);
			}

		}catch (SQLException ex) {
			throw new ClienteException("Erro ao listar clientes");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException e) {
				throw new ClienteException("Erro ao fechar conexão(message): "
						+ e.getMessage());
			}
		}
		return clientes;
	}
	
	
	/**
	 * Retorna uma lista de clientes que contenham o valor de @filtro
	 * @param filtro
	 * @return
	 * @throws Exception
	 */
	public List<Cliente> filtrarClientes(String nome) throws ClienteException{
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append("FROM cliente ");
		query.append("WHERE nome LIKE ?;");
		
		ResultSet result = null;
		Connection connection = null;
		PreparedStatement stm = null;
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			connection = conn.getConnection();
			stm = connection.prepareStatement(query.toString());
			stm.setString(1,'%' + nome + '%');
			result = stm.executeQuery();
			
			while (result.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(result.getInt("id"));
				cliente.setCpf(result.getString("cpf"));
				cliente.setNome(result.getString("nome"));
				cliente.setRg(result.getString("rg"));
				cliente.setTelefone(result.getString("telefone"));
				cliente.setOrgExpedidor(result.getString("org_exp"));
				cliente.setEmail(result.getString("email"));
				
				clientes.add(cliente);
			}

		} catch (SQLException ex) {
			throw new ClienteException("Erro ao filtrar cliente");
		} finally {
			try {
				connection.close();
				stm.close();
			} catch (SQLException e) {
				throw new ClienteException("Erro ao fechar conexão(message): "
						+ e.getMessage());
			}
		}
		return clientes;
	}
}
