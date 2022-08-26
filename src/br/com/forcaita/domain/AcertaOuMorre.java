package br.com.forcaita.domain;

public class AcertaOuMorre extends MecanicaDoJogo {
	
	public AcertaOuMorre() {
		this.vida = 1;
	}
	
	@Override
	public String pegaSlogan() {
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
		int pontos;
		if (this.getRound() <= 5) {
			pontos = 10;
		} else if (this.getRound() <= 15) {
			pontos = 15;
		} else {
			pontos = 20;
		}
		this.setPontos(pontos);
	}

	@Override
	protected void respostaErrada() {
		this.vida--;
	}

}
