package org.algoritmos;

public class QuickSort extends Algoritmo {

	public void ordenaQuick() {
		quickSort(this.primeiro, this.ultimo);
	}

	private void quickSort(Nodo inicio, Nodo fim) {
		if (fim != null && inicio != fim && inicio != fim.prox) {
			Nodo pivo = particiona(inicio, fim);
			quickSort(inicio, pivo.ant);
			quickSort(pivo.prox, fim);
		}
	}

	private Nodo particiona(Nodo inicio, Nodo fim) {
		int pivoValor = fim.endereco;
		Nodo i = inicio.ant;
		Nodo j = inicio;

		while (j != fim) {
			if (j.endereco <= pivoValor) {
				i = (i == null) ? inicio : i.prox;

				int temp = i.endereco;
				i.endereco = j.endereco;
				j.endereco = temp;
			}
			j = j.prox;
		}

		i = (i == null) ? inicio : i.prox;
		int temp = i.endereco;
		i.endereco = fim.endereco;
		fim.endereco = temp;

		return i;
	}
}
