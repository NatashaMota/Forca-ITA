package br.com.forcaita.domain;

public abstract class MecanicaDoJogo {
	private int round;
	private int acertos;
	private int pontos;
	private String resposta;
	private String palavra;
	private String palavraEmbaralhada;
	protected int vida;
	
	private Embaralhador embaralhador;
	private BancoDePalavras bancoPalavras = new BancoDePalavras();
	private FabricaEmbaralhadores fabricaEmbaralhadores = new FabricaEmbaralhadores();
	
	
	public MecanicaDoJogo() {
		this.round = 0;
		this.acertos = 0;
		this.pontos = 0;
		this.resposta = "";
		this.palavra = "";
		
	
	}
	
	private void iniciarRound() {
		if (this.temProximoRound()) {	
			this.round += 1;
			if (pegaPalavra()) {
				this.embaralhaPalavra();
				this.resposta = "";
			} else {
				palavra = "ERRO";
			}
		}
	}
	
	private void embaralhaPalavra() {
		this.embaralhador = this.fabricaEmbaralhadores.pegaEmbaralhadorAleatorio();
		this.palavraEmbaralhada = this.embaralhador.embaralhaPalavra(this.palavra);
		
	}
	
	private boolean pegaPalavra() {
		if (this.palavra.equals(this.resposta)) {
			this.palavra = this.bancoPalavras.pegaPalavraAleatoria();
		}
		return !palavra.equals("");
	}	
	
	public boolean verificaResposta(String resposta) {
		this.resposta = resposta;
		if (this.palavra.equals(this.resposta)) {
			this.acertos++;
			this.contaPontos();
			return true;
		}
		
		this.respostaErrada();
		return false;
	}
	
	public int getPontos() {
		return this.pontos;
	}
	
	protected void setPontos(int pontos) {
		this.pontos += pontos;
	}
	
	public int getRound() {
		return this.round;
	}
	
	public int getAcertos() {
		return this.acertos;	}
	
	public String getPalavraEmbaralhada() {
		this.iniciarRound();
		return this.palavraEmbaralhada;
	}
	
	public abstract String pegaSlogan();
	
	public abstract boolean temProximoRound();

	protected abstract void contaPontos();
	
	protected abstract void respostaErrada();
}
