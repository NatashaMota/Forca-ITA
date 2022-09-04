package br.com.forcaita.domain.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ColetorPalavraWEB {

	private static final String URL = "https://www.dicio.com.br/animais-de-a-a-z/";
	private ArrayList<String> palavras = new ArrayList<String>();
	
	public ColetorPalavraWEB() {
		this.preencherArrayPalavras();
		
	}
	
	
	public ArrayList<String> pegaPalavras() {
		ArrayList<String> copiaPalavras = new ArrayList<String>();
		for (String palavra: this.palavras){
			copiaPalavras.add(palavra);
		}
		return copiaPalavras;
	}
	
	private Elements pegarListItens() {
		Document doc;
		try {
			doc = Jsoup.connect(URL).get();
			Elements listItens = (doc.getElementById("contentArticle").select("li").not(".item"));
			return listItens;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	private void preencherArrayPalavras(){
		for (Element li : pegarListItens()) {
				this.palavras.add(this.limparPalavraLI(li));		
		}
	}
	
	private String limparPalavraLI(Element li) {
		String palavra;
		palavra = li.toString();
		palavra = palavra.substring(4, palavra.length()-6);
		return palavra;
	}
}
