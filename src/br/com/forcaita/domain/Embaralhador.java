package br.com.forcaita.domain;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Embaralhador {

	public abstract String embaralhaPalavra(String palavra);

	protected String embaralhaTexto(String texto) {
		String textoEmbaralhado = "";	
		ArrayList<Character> textoArray = new ArrayList<Character>();
		for (char letra: texto.toCharArray()) {
			textoArray.add(letra);
		}
		Collections.shuffle(textoArray);
		
		for (char letra: textoArray) {
			textoEmbaralhado += letra;
		}
		
		return textoEmbaralhado;
	}

}
