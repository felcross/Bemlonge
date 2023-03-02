package br.com.bemlonge.model;

import java.io.Serializable;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dto.ClienteDTO;
import br.com.bemlonge.enums.SituacaoClienteEnum;

public class Cliente implements Serializable{
	
	static final Logger logger = LogManager.getLogger(Cliente.class.getName());

	private static final long serialVersionUID = 1554091184902163399L;
	
	private int id;
	private String cpf;
	private String nome;
	private String rg;
	private String orgExpedidor;
	private String telefone;
	private String email;
	private SituacaoClienteEnum situacao;
	private Endereco endereco = new Endereco();
	
	public Cliente() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgExpedidor() {
		return orgExpedidor;
	}

	public void setOrgExpedidor(String orgExpedidor) {
		this.orgExpedidor = orgExpedidor;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SituacaoClienteEnum getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoClienteEnum situacao) {
		this.situacao = situacao;
	}	
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public ClienteDTO converterParaDTO() {
		ClienteDTO cliente = new ClienteDTO();
		cliente.setCpf(this.cpf);
		cliente.setEmail(this.email);
		cliente.setId(this.id);
		cliente.setEndereco(this.endereco.converterParaDTO());
		cliente.setNome(this.nome);
		cliente.setOrgExpedidor(this.orgExpedidor);
		cliente.setRg(this.rg);
		cliente.setSituacao(this.situacao);
		cliente.setTelefone(this.telefone);
		return cliente;
	}

}
