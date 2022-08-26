package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.forcaita.domain.Embaralhador;
import br.com.forcaita.domain.ExtremosFixo;
import br.com.forcaita.domain.FabricaEmbaralhadores;
import br.com.forcaita.domain.MeioFixo;

public class FabricaEmbaralhadoresTeste {
	FabricaEmbaralhadores fabricaEmbaralhador = new FabricaEmbaralhadores();
	
	@Before
	public void criaEmbaralhador() {
		
	}
	
	@Test
	public void retornaEmbaralhador() {		
		Embaralhador embaralhador1;
		Embaralhador embaralhador2;
		embaralhador1 = this.fabricaEmbaralhador.pegaEmbaralhadorAleatorio();
		embaralhador2 = this.fabricaEmbaralhador.pegaEmbaralhadorAleatorio();
		assertEquals(true, embaralhador1 instanceof Embaralhador && embaralhador2 instanceof Embaralhador);
		assertEquals(true, embaralhador1 instanceof ExtremosFixo || embaralhador1 instanceof MeioFixo);
		assertEquals(true, embaralhador2 instanceof ExtremosFixo || embaralhador2 instanceof MeioFixo);
		
	}
	@Test
	public void embaralhadoExtremosFixo() {
		Embaralhador embaralhador;
		while (true) {
			embaralhador = this.fabricaEmbaralhador.pegaEmbaralhadorAleatorio();
			if (embaralhador instanceof ExtremosFixo) {
				assertEquals(false, embaralhador.embaralhaPalavra("chapeu") == "chapeu");
				assertEquals(true, (embaralhador.embaralhaPalavra("chapeu")).charAt(0) == 'c');
				assertEquals(true, (embaralhador.embaralhaPalavra("chapeu")).charAt(5) == 'u');
				assertEquals(false, embaralhador.embaralhaPalavra("helicoptero") == "helicoptero");
				assertEquals(true, (embaralhador.embaralhaPalavra("helicoptero")).charAt(0) == 'h');
				assertEquals(true, (embaralhador.embaralhaPalavra("helicoptero")).charAt(10) == 'o');
				break;
			}
		}	
	}
	
	@Test
	public void embaralhadoMeioFixo() {
		Embaralhador embaralhador;
		while (true) {
			embaralhador = this.fabricaEmbaralhador.pegaEmbaralhadorAleatorio();
			if (embaralhador instanceof MeioFixo) {
				assertEquals(false, embaralhador.embaralhaPalavra("chapeu").equals("chapeu"));
				assertEquals(true, (embaralhador.embaralhaPalavra("chapeu")).charAt(2) == 'a');
				assertEquals(true, (embaralhador.embaralhaPalavra("luva")).charAt(1) == 'u');
				assertEquals(false, embaralhador.embaralhaPalavra("helicoptero").equals("helicoptero"));
				assertEquals(true, (embaralhador.embaralhaPalavra("helicoptero")).charAt(5) == 'o');
				assertEquals(false, embaralhador.embaralhaPalavra("oculos").equals("oculos"));
				assertEquals(true, (embaralhador.embaralhaPalavra("oculos")).charAt(2) == 'u');
				
				break;
			}
		}	
		
	}
	
}
