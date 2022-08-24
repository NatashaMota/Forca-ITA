package br.com.forcaita.domain;

import java.util.ArrayList;
import java.util.Collections;

public class FabricaEmbaralhadores {
	
	ArrayList<Embaralhador> embaralhadores = new ArrayList<Embaralhador>(); 
	
	public FabricaEmbaralhadores() {
		this.carregaEmbaralhadores();	
	}
	
	private void carregaEmbaralhadores() {
		this.embaralhadores.add(new ExtremosFixo());
		this.embaralhadores.add(new MeioFixo());
	}
	
	private void embaralhaEmbaralhadores() {
		Collections.shuffle(this.embaralhadores);
	}
	
	
	public Embaralhador getEmbaralhadorAleatorio() {
		this.embaralhaEmbaralhadores();
		return this.embaralhadores.get(0);
	}
}
