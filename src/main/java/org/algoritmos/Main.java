package org.algoritmos;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {

		int[] listaDesordenada = {30, 20, 50, 10};

		System.out.println("Lista Desordenada: \n"+ Arrays.toString(listaDesordenada));

		// INSERT SORT
		InsertionSort insertionSort = new InsertionSort();
		for (int numero : listaDesordenada) {
			insertionSort.addNumero(numero);
		}
		insertionSort.ordenaInsertionSort();
		System.out.println("\nLista Ordenada com Insertion Sort:");
		insertionSort.imprimeLista();

		// MERGE SORT
		MergeSort mergeSort = new MergeSort();
		for (int numero : listaDesordenada) {
			mergeSort.addNumero(numero);
		}
		mergeSort.ordenaMerge();
		System.out.println("\n\nLista Ordenada com Merge Sort:");
		mergeSort.imprimeLista();

		// QUICK SORT
		QuickSort quickSort = new QuickSort();
		for (int numero : listaDesordenada) {
			quickSort.addNumero(numero);
		}
		quickSort.ordenaQuick();
		System.out.println("\n\nLista Ordenada com Quick Sort:");
		quickSort.imprimeLista();

	}
}