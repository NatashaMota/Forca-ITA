package br.com.forcaita.aplication;

import java.util.Scanner;

import br.com.forcaita.domain.FabricaMecanicaDoJogo;
import br.com.forcaita.domain.MecanicaDoJogo;

public class Main {	
	private final static Scanner scan = new Scanner(System.in);
	private final static FabricaMecanicaDoJogo  fabricaMecanica = new FabricaMecanicaDoJogo();

	public static void main(String[] args){		
		
		MecanicaDoJogo mecanicaJogo;
		String resposta;
		
		int op = 1;
		while(op == 1) {
			
			mecanicaJogo = fabricaMecanica.getMecanicaAleatoria();			
			
			exibeIniciarJogo();
			op = Integer.parseInt(scan.nextLine()); 
			if (op == 2) {
				break;
			}
			while (mecanicaJogo.temProximoRound()) {
				exibePalavraComSlogan(mecanicaJogo.getSlogan(), mecanicaJogo.getPalavraEmbaralhada());
				resposta = pegaResposta();
				exibeResultado(mecanicaJogo.verificaResposta(resposta));			
			}		
			exibeResumoDoJogo(mecanicaJogo.getPontos(), mecanicaJogo.getAcertos(), mecanicaJogo.getRound());
		}
	}
	
	
	
	
	private static void exibePalavraComSlogan(String slogan, String palavra) {
		System.out.println(slogan);
		System.out.println(palavra);
		
	}
	
	private static void exibeResumoDoJogo(int pontos, int acertos, int rounds) {
		System.out.println("------- FIM DO JOGO ---------");
		System.out.println("Pontos: " + pontos);
		System.out.println("Rounds: " + rounds);
		System.out.println("Acertos: " + acertos);
		
	}
	
	private static void exibeResultado(boolean resultado) {
		if (resultado) {
			System.out.println("Droga, você acertou!");
		} else {
			System.out.println("HAHA, Você errou!!!!!!!");
		}
	};
	
	
	private static void exibeIniciarJogo() {
		System.out.println("-----INICIAR NOVO JOGO------");
		System.out.print("1 - Iniciar novo jogo \n2 - Sair\n");
	}

	
	private static String pegaResposta() {
		String resposta = scan.nextLine();
		return resposta;
	}
	
	
}
