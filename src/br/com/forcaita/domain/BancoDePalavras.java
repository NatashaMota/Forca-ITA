package br.com.forcaita.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import br.com.forcaita.domain.util.ColetorPalavraWEB;



public class BancoDePalavras {

	private int indice;
	private ArrayList<String> palavras = new ArrayList<String>();
	
	public BancoDePalavras() {
		this.indice = 0;
		this.carregaPalavrasTXT();
		this.embaralhaPalavras();
	}
	
	public int pegarQuantidadePalavras() {
		return this.palavras.size();
	}
	
	public String pegaPalavraAleatoria() {
		if (indice < palavras.size()) {
			//exception
		}
		return this.palavras.get(this.indice++);
		
	};
	
	private void embaralhaPalavras() {
		Collections.shuffle(this.palavras);
	}
	
	private void carregaPalavrasTXT(){
		String filePath = "/home/aluna/git/Forca-ITA/dados/animais_palavras.txt";
		try {
			File arquivo = new File(filePath);
			if(!arquivo.exists()) {
				criarArquivo(arquivo);
			} 
			
			lerArquivo(filePath);
							
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void criarArquivo(File arquivo) throws IOException {
		ColetorPalavraWEB coletorPalavras = new ColetorPalavraWEB();
		
		FileWriter escritor = new FileWriter(arquivo);
		PrintWriter gravarArq = new PrintWriter(escritor);
		ArrayList<String> palavrascopia = coletorPalavras.pegaPalavras();
		for(String palavra: palavrascopia){
			gravarArq.println(palavrascopia);
		}
		arquivo.createNewFile();
		gravarArq.close();
	}
	
	private void lerArquivo(String arquivo) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(arquivo));
		while(scan.hasNext()) {
			this.palavras.add(scan.next());
		}
	}
}
