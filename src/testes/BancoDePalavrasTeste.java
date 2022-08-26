package testes;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.forcaita.domain.BancoDePalavras;

public class BancoDePalavrasTeste {
	
	BancoDePalavras bancoPalavras = new BancoDePalavras();
	ArrayList<String> palavrasTeste = new ArrayList<String>();
	
	@Before
	public void criaListaDePalavras() {
		
		
		palavrasTeste.add("galinha");
		palavrasTeste.add("galo");
		palavrasTeste.add("gato");
		palavrasTeste.add("pato");
		palavrasTeste.add("sapo");
		palavrasTeste.add("camelo");
		palavrasTeste.add("camundongo");
		palavrasTeste.add("leão");
		palavrasTeste.add("elefante");
		palavrasTeste.add("baleia");
		palavrasTeste.add("cachorro");
		palavrasTeste.add("passaro");
		palavrasTeste.add("ararra");
		palavrasTeste.add("tucano");
		palavrasTeste.add("tubarão");
		palavrasTeste.add("rato");
		palavrasTeste.add("lhama");
		palavrasTeste.add("periquito");
		palavrasTeste.add("golfinho");
		palavrasTeste.add("ornitorinco");
	}
	
	@Test
	public void leituraArquivo() {
		assertEquals(true, this.palavrasTeste.contains(this.bancoPalavras.pegaPalavraAleatoria()));		
		//assertEquals(true, this.bancoPalavras.getPalavraAleatoria().equals(palavrasTeste.get(0)));
		//assertEquals(true, this.bancoPalavras.getPalavraAleatoria().equals(palavrasTeste.get(19)));
		
	}
	
	@Test
	public void palavrasRepitidas() {
		String palavraSorteadaTeste;
		ArrayList<String> palavrasSorteadasTeste = new ArrayList<String>();
		
		for (int i=0; i<=19; i++);
			palavraSorteadaTeste = this.bancoPalavras.pegaPalavraAleatoria();
			assertEquals(false, palavrasSorteadasTeste.contains(palavraSorteadaTeste));
			palavrasSorteadasTeste.add(palavraSorteadaTeste);
	}
	
}
