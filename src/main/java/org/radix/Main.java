package org.radix;

public class Main {

	public static void main(String[] args) {

		String caminho = "src/main/resources/sorteios-mega-sena.xlsx";
		Radix radixSort = new Radix();

		LeitorExcel.lerSorteios( caminho, radixSort );

		if (radixSort.primeiro == null) {
			System.out.println("Nenhum dado de sorteio carregado. Verifique o arquivo Excel.");
			return;
		}

		System.out.println("Antes da ordenação (5 primeiros):");
		Nodo temp = radixSort.primeiro;
		for( int i = 0; i < 5 && temp != null; i++ ) {
			System.out.println( temp.dado );
			temp = temp.prox;
		}
		System.out.println("...");

		System.out.println("\nApós ordenação (Radix Sort):");
		radixSort.ordenaRadix();
		radixSort.imprimirRadix();
	}
}