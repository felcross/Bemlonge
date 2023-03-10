package br.com.bemlonge.enums;

public enum UnidadeFederativaEnum {
	ACRE("Acre", "AC", "Rio Branco"), 
	ALAGOAS("Alagoas", "AL", "Macei?"), 
	AMAPA("Amap?", "AP", "Macap?"), 
	AMAZONAS("Amazonas", "AM", "Manaus"), 
	BAHIA("Bahia", "BA", "Salvador"), 
	CEARA("Cear?", "CE", "Fortaleza"), 
	DISTRITO_FEDERAL("Distrito Federal", "DF", "Bras?lia"),
	ESPIRITO_SANTO(	"Esp?rito Santo", "ES", "Vit?ria"), 
	GOIAS("Goi?s", "GO", "Goi?nia"), 
	MARANHAO("Maranh?o", "MA", "S?o Lu?s"), 
	MATO_GROSSO("Mato Grosso", "MT", "Cuiab?"), 
	MATO_GROSSO_DO_SUL("Mato Grosso do Sul", "MS", "Campo Grande"), 
	MINAS_GERAIS("Minas Gerais", "MG", "Belo Horizonte"), 
	PARA("Par?", "PA", "Bel?m"),
	PARAIBA("Para?ba", "PB", "Jo?o Pessoa"), 
	PARANA(	"Paran?", "PR", "Curitiba"),
	PERNAMBUCO("Pernambuco", "PE", "Recife"),
	PIAUI("Piau?", "PI", "Teresina"), 
	RIO_DE_JANEIRO("Rio de Janeiro", "RJ", "Rio de Janeiro"),
	RIO_GRANDE_DO_NORTE("Rio Grande do Norte", "RN", "Natal"),
	RIO_GRANDE_DO_SUL("Rio Grande do Sul", "RS", "Porto Alegre"), 
	RONDONIA("Rond?nia", "RO","Porto Velho"), 
	RORAIMA("Roraima", "RR", "Boa Vista"),	
	SANTA_CATARINA("Santa Catarina","SC", "Florian?polis"),
	SAO_PAULO("S?o Paulo", "SP", "S?o Paulo"), 
	SERGIPE("Sergipe", "SE", "Aracaju"),
	TOCANTINS("Tocantins","TO", "Palmas");	

	private UnidadeFederativaEnum(final String nome, final String sigla, final String capital) {
		this.nome = nome;
		this.sigla = sigla;
		this.capital = capital;
	}

	private String nome;
	private String sigla;
	private String capital;

	public String getSigla() {
		return this.sigla;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCapital() {
		return this.capital;
	}
}
