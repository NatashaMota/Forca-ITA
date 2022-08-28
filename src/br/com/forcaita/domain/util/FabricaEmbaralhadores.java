package br.com.forcaita.domain.util;

import java.util.ArrayList;
import java.util.Collections;

import br.com.forcaita.domain.Embaralhador;
import br.com.forcaita.domain.ExtremosFixo;
import br.com.forcaita.domain.MeioFixo;

public class FabricaEmbaralhadores {
	
	private ArrayList<Embaralhador> embaralhadores = new ArrayList<Embaralhador>(); 
	
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
	
	
	public Embaralhador pegaEmbaralhadorAleatorio() {
		this.embaralhaEmbaralhadores();
		return this.embaralhadores.get(0);
	}
}
