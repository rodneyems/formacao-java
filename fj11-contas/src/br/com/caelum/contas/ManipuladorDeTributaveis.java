package br.com.caelum.contas;

import br.com.caelum.javafx.api.util.Evento;

public class ManipuladorDeTributaveis {
	private double total;
	public int listaTributaveis(Evento evento) {
		return evento.getTamanhoDaLista("listaTributaveis");
	}
	
	
	public void calculaImpostos(Evento evento) {
		
	}
}


152