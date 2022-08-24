package br.com.forcaita.domain;

public class AcertaOuMorre extends MecanicaDoJogo {
	int vida;
	
	public AcertaOuMorre() {
		this.vida = 1;
	}
	
	@Override
	public String getSlogan() {
		return "Acerte ou morra!";
	}

	@Override
	public boolean temProximoRound() {
		if (this.vida == 1 && this.getRound() < 20) {
			return true;
		}
		return false;
	}

	@Override
	protected void contaPontos() {
		if (this.getRound() <= 5) {
			this.pontos += 10;
		} else if (this.getRound() <= 15) {
			this.pontos += 15;
		} else {
			this.pontos += 20;
		}
	}

	@Override
	protected void respostaErrada() {
		this.vida--;
	}

}
