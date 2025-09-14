package org.algoritmos;

public abstract class Algoritmo {

	protected Nodo primeiro;
	protected Nodo ultimo;

	public void addNumero(int valor) {
		Nodo nodo = new Nodo(valor);

		if( this.primeiro == null ) {
			this.primeiro = nodo;
			this.ultimo = nodo;
		} else{
			this.ultimo.prox = nodo;
			nodo.ant = this.ultimo;
			this.ultimo = nodo;
		}
	}

	public void imprimeLista() {
		if (this.primeiro == null) {
			System.out.printf("A lista está vazia!");
		} else {
			Nodo nodoAtual = this.primeiro;
			while (nodoAtual != null) {
				System.out.print(nodoAtual.endereco + ", ");
				nodoAtual = nodoAtual.prox;
			}
		}
	}
}
