package br.com.forcaita.domain;

public class ExtremosFixo extends Embaralhador {
	
	private String inicio;
	private String fim;
	private String meio; 
	
	private void setMeio(String palavra) {
		this.meio = palavra.substring(1, palavra.length()-1);
	}
	
	private void fixaExtremos(String palavra) {
		this.inicio = palavra.substring(0, 1);
		this.fim = palavra.substring(palavra.length()-1, palavra.length());
	}
	
	private void embaralhaMeio() {
		String meioEmbaralhado = "";
		do {
			meioEmbaralhado = this.embaralhaTexto(this.meio);
		} while(this.meio.equals(meioEmbaralhado));
		this.meio = meioEmbaralhado;
	}
	
	@Override
	public String embaralhaPalavra(String palavra) {
		
		this.fixaExtremos(palavra);
		this.setMeio(palavra);
		this.embaralhaMeio(); 
		
		return this.inicio + this.meio + this.fim;
	}

}
