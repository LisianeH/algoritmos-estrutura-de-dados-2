package org.algoritmos;

public class Nodo {

	protected int endereco;
	protected Nodo ant;
	protected Nodo prox;

	public Nodo(int endereco) {
		this.endereco = endereco;
		this.ant = null;
		this.prox = null;
	}
}
