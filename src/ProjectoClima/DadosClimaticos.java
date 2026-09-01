package ProjectoClima;

// CLASSE QUE SERVIRA COMO UM PACOTE QUE CARREGA APENA AS INFORMAÇÕES NECESSARIAS PARA A TELA.
public class DadosClimaticos {
	
	// ATRIBUTOS
	private String cidade;
	private String pais;
	private String dataHora;
	private double temperatura;
	private double sensacaoTermica;
	private String condicaoTempo;
	private int umidade;
	private double velocidadeVento;
	private double pressaoAtmosferica;
	
	// CONSTRUTOR
	public DadosClimaticos(String cidade, String pais, String dataHora, double temperatura,
						   double sensacaoTermica, String condicaoTempo, int umidade, double velocidadeVento,
						   double pressaoAtmosferica) {
		this.cidade = cidade;
		this.pais = pais;
		this.dataHora = dataHora;
		this.temperatura = temperatura;
		this.sensacaoTermica = sensacaoTermica;
		this.condicaoTempo = condicaoTempo;
		this.umidade = umidade;
		this.velocidadeVento = velocidadeVento;
		this.pressaoAtmosferica = pressaoAtmosferica;
	}
	
	// GETTERS
	public String getCidade() {
		return cidade;
	}
	public String getPais() {
		return pais;
	}
	public String getDataHora() {
		return dataHora;
	}
	public double getTemperatura() {
		return temperatura;
	}
	public double getSensacaoTermica() {
		return sensacaoTermica;
	}
	public String getCondicaoTempo() {
		return condicaoTempo;
	}
	public int getUmidade() {
		return umidade;
	}
	public double getVelocidadeVento() {
		return velocidadeVento;
	}
	public double getPressaoAtmosferica() {
		return pressaoAtmosferica;
	}

}
