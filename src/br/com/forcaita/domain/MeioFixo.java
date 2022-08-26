package br.com.forcaita.domain;

public class MeioFixo extends Embaralhador {

	private int meioIndex;
	private String palavra;
	
	
	private void definePalavra(String palavra) {
		this.palavra = palavra;
	}
	
	private void defineMeioIndex() {
		this.meioIndex = this.palavra.length()/2;
		if (this.palavra.length()  % 2 != 0) {
			this.meioIndex += 1;
		}
		
	}
		
	private String pegaMeio() {
		return this.palavra.substring(this.meioIndex-1, this.meioIndex);
	}
	
	private String pegaInicio() {
		return this.embaralhaTexto(this.palavra.substring(0, this.meioIndex-1));
	}
	
	private String pegaFim() {
		
		return this.embaralhaTexto(this.palavra.substring(this.meioIndex, this.palavra.length()));
	}
	
	@Override
	public String embaralhaPalavra(String palavra) {
		this.definePalavra(palavra);
		this.defineMeioIndex();
		String palavraEmbaralhada = "";
		do {
			palavraEmbaralhada = this.pegaInicio() + this.pegaMeio() + this.pegaFim();
		} while(palavra.equals(palavraEmbaralhada));
		
		return palavraEmbaralhada;
	}

}
