package br.com.forcaita.domain;

public class VidaDeGato extends MecanicaDoJogo {
	private int vida;
	
	public VidaDeGato() {
		this.vida = 7;
	}
	
	@Override
	public String getSlogan() {
		return "Você tem " + this.vida + " vidas, gatinho.";
	}

	@Override
	public boolean temProximoRound() {
		if (this.vida >= 1 && this.getRound() < 20) {
			return true;	
		}
		return false;
	}

	@Override
	protected void contaPontos() {
		this.pontos += this.vida;
		
	}

	@Override
	protected void respostaErrada() {
		this.vida--;
		if (this.pontos >= 5) {
			this.pontos -= 5;
		} else {
			this.pontos = 0;
		}
		
		
	}
}
