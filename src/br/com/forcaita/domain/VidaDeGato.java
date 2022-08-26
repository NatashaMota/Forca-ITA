package br.com.forcaita.domain;

public class VidaDeGato extends MecanicaDoJogo {
	
	public VidaDeGato() {
		this.vida = 7;
	}
	
	@Override
	public String pegaSlogan() {
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
		this.setPontos(this.vida);
		
	}

	@Override
	protected void respostaErrada() {
		this.vida--;
		if (this.getPontos() >= 5) {
			this.setPontos(-5);
		} else {
			this.setPontos(0);
		}	
	}
}
