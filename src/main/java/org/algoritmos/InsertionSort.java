package org.algoritmos;

public class InsertionSort extends Algoritmo {

	public void ordenaInsertionSort() {
		Nodo nodoAtual = this.primeiro.prox;
		while (nodoAtual != null) {
			int endereco = nodoAtual.endereco;
			Nodo nodoAux = nodoAtual.ant;

			while (nodoAux != null && nodoAux.endereco > endereco) {
				nodoAux.prox.endereco = nodoAux.endereco;
				nodoAux = nodoAux.ant;
			}

			if (nodoAux == null) {
				this.primeiro.endereco = endereco;
			} else {
				nodoAux.prox.endereco = endereco;
			}

			nodoAtual = nodoAtual.prox;
		}
	}
}
