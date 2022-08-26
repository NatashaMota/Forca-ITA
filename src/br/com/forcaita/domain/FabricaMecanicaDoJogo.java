package br.com.forcaita.domain;
import java.util.ArrayList;
import java.util.Collections;

public class FabricaMecanicaDoJogo {
		
	private ArrayList<MecanicaDoJogo> mecanicas = new ArrayList<MecanicaDoJogo>(); 
		
	private void carregaMecanicas() {
		this.mecanicas.add(new AcertaOuMorre());
		this.mecanicas.add(new VidaDeGato());
	}
		
	private void embaralhaMecanicas() {
		Collections.shuffle(this.mecanicas);
	}
				
	public MecanicaDoJogo pegaMecanicaAleatoria() {
		this.mecanicas.clear();
		this.carregaMecanicas();
		this.embaralhaMecanicas();
		return this.mecanicas.get(0);
	}
	

}
