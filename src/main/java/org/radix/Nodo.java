package org.radix;

public class Nodo {

	protected Sorteio dado;
	protected Nodo ant;
	protected Nodo prox;

	public Nodo( Sorteio sorteio ) {
		this.dado = sorteio;
		this.ant = null;
		this.prox = null;
	}
}
