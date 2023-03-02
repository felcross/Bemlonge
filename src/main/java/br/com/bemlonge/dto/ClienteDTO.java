package br.com.bemlonge.dto;

import java.io.Serializable;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import br.com.bemlonge.enums.SituacaoClienteEnum;
import br.com.bemlonge.model.Cliente;

public class ClienteDTO implements Serializable{
	
	static final Logger logger = LogManager.getLogger(ClienteDTO.class.getName());

	private static final long serialVersionUID = -4409679415522131131L;
	
	private int id;
	private String cpf;
	private String nome;
	private String rg;
	private String orgExpedidor;
	private String telefone;
	private String email;
	private SituacaoClienteEnum situacao;
	private EnderecoDTO endereco = new EnderecoDTO();
	private Boolean resultado;
	private Boolean validacaoCpf;

	public ClienteDTO(Cliente cliente){
		this.id = cliente.getId();
		this.cpf = cliente.getCpf();
		this.nome = cliente.getNome();
		this.rg = cliente.getRg();
		this.orgExpedidor = cliente.getOrgExpedidor();
		this.telefone = cliente.getTelefone();
		this.email = cliente.getEmail();
		this.situacao = cliente.getSituacao();
	}
	
	public ClienteDTO() {
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

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public Cliente converterParaModel() {
		Cliente cliente = new Cliente();
		cliente.setCpf(this.cpf);
		cliente.setId(this.id);
		cliente.setEmail(this.email);
		cliente.setEndereco(this.endereco.converterParaModel());
		cliente.setNome(this.nome);
		cliente.setOrgExpedidor(this.orgExpedidor);
		cliente.setRg(this.rg);
		cliente.setSituacao(this.situacao);
		cliente.setTelefone(this.telefone);		
		return cliente;
	}

	public Boolean getResultado() {
		return resultado;
	}

	public void setResultado(Boolean resultado) {
		this.resultado = resultado;
	}

	public Boolean getValidacaoCpf() {
		return validacaoCpf;
	}

	public void setValidacaoCpf(Boolean validacaoCpf) {
		this.validacaoCpf = validacaoCpf;
	}

}
