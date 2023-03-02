package br.com.bemlonge.exception;

public class PacoteException extends Exception {

	private static final long serialVersionUID = -4590883942815376434L;

	private String mensagem;

	public PacoteException(String mensagem) {
		super(mensagem);
	}

	public PacoteException(String cause, String mensagem) {
		super(cause);
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
