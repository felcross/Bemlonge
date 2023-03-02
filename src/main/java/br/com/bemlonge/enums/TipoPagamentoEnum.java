package br.com.bemlonge.enums;

public enum TipoPagamentoEnum {
	A_VISTA("A_Vista", "A Vista"),
	PARCELADO("Parcelado", "Parcelado");

	private String valorBanco;
	private String valorExibicao;

	TipoPagamentoEnum(String valorBanco, String valorExibicao) {
		this.valorBanco = valorBanco;
		this.valorExibicao = valorExibicao;
	}	
	
	public String getValorExibicao() {
		return valorExibicao;
	}

	public String getValorBanco() {
		return this.valorBanco;
	}
}
