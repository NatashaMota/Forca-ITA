package br.com.forcaita.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;



public class BancoDePalavras {

	private int indice;
	private ArrayList<String> palavras = new ArrayList<String>();
	
	public BancoDePalavras() {
		this.indice = 0;
		this.carregaPalavrasTXT();
		this.embaralhaPalavras();
	}
	
	public String getPalavraAleatoria() {
		if (indice < palavras.size()) {
			//exception
		}
		return this.palavras.get(this.indice++);
		
	};
	
	private void embaralhaPalavras() {
		Collections.shuffle(this.palavras);
	}
	
	private void carregaPalavrasTXT(){
		String filePath = "/home/aluna/eclipse-workspace/Forca-ITA/dados/animais_palavras.txt";
		try {
			Scanner scan = new Scanner(new File(filePath));
			while(scan.hasNext()) {
				this.palavras.add(scan.next());	
							}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
