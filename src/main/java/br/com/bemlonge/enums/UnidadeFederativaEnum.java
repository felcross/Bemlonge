package br.com.bemlonge.enums;

public enum UnidadeFederativaEnum {
	ACRE("Acre", "AC", "Rio Branco"), 
	ALAGOAS("Alagoas", "AL", "Maceió"), 
	AMAPA("Amapá", "AP", "Macapá"), 
	AMAZONAS("Amazonas", "AM", "Manaus"), 
	BAHIA("Bahia", "BA", "Salvador"), 
	CEARA("Ceará", "CE", "Fortaleza"), 
	DISTRITO_FEDERAL("Distrito Federal", "DF", "Brasília"),
	ESPIRITO_SANTO(	"Espírito Santo", "ES", "Vitória"), 
	GOIAS("Goiás", "GO", "Goiânia"), 
	MARANHAO("Maranhão", "MA", "São Luís"), 
	MATO_GROSSO("Mato Grosso", "MT", "Cuiabá"), 
	MATO_GROSSO_DO_SUL("Mato Grosso do Sul", "MS", "Campo Grande"), 
	MINAS_GERAIS("Minas Gerais", "MG", "Belo Horizonte"), 
	PARA("Pará", "PA", "Belém"),
	PARAIBA("Paraíba", "PB", "João Pessoa"), 
	PARANA(	"Paraná", "PR", "Curitiba"),
	PERNAMBUCO("Pernambuco", "PE", "Recife"),
	PIAUI("Piauí", "PI", "Teresina"), 
	RIO_DE_JANEIRO("Rio de Janeiro", "RJ", "Rio de Janeiro"),
	RIO_GRANDE_DO_NORTE("Rio Grande do Norte", "RN", "Natal"),
	RIO_GRANDE_DO_SUL("Rio Grande do Sul", "RS", "Porto Alegre"), 
	RONDONIA("Rondônia", "RO","Porto Velho"), 
	RORAIMA("Roraima", "RR", "Boa Vista"),	
	SANTA_CATARINA("Santa Catarina","SC", "Florianópolis"),
	SAO_PAULO("São Paulo", "SP", "São Paulo"), 
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
