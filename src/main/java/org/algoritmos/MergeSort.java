package org.algoritmos;

public class MergeSort extends Algoritmo {

	public void ordenaMerge() {
		this.primeiro = mergeSort(this.primeiro);

		Nodo atual = this.primeiro;
		Nodo aux = null;

		while (atual != null) {
			atual.ant = aux;
			aux = atual;
			if (atual.prox == null) {
				this.ultimo = atual;
			}
			atual = atual.prox;
		}
	}

	private Nodo mergeSort(Nodo nodoAtual) {

		if (nodoAtual == null || nodoAtual.prox == null) {
			return nodoAtual;
		}

		Nodo meio = divide(nodoAtual);
		Nodo esquerda = mergeSort(nodoAtual);
		Nodo direita = mergeSort(meio);

		return merge(esquerda, direita);
	}

	private Nodo divide(Nodo head) {
		Nodo lento = head;
		Nodo rapido = head;

		while (rapido.prox != null && rapido.prox.prox != null) {
			lento = lento.prox;
			rapido = rapido.prox.prox;
		}

		Nodo meio = lento.prox;
		lento.prox = null;
		if (meio != null) {
			meio.ant = null;
		}
		return meio;
	}

	private Nodo merge(Nodo esquerda, Nodo direita) {
		if (esquerda == null) {
			return direita;
		}
		if (direita == null) {
			return esquerda;
		}

		Nodo resultado;
		if (esquerda.endereco <= direita.endereco) {
			resultado = esquerda;
			resultado.prox = merge(esquerda.prox, direita);
			if (resultado.prox != null) {
				resultado.prox.ant = resultado;
			}
		} else {
			resultado = direita;
			resultado.prox = merge(esquerda, direita.prox);
			if (resultado.prox != null) {
				resultado.prox.ant = resultado;
			}
		}

		resultado.ant = null;
		return resultado;
	}
}
