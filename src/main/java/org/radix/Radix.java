package org.radix;

public class Radix {

	protected Nodo primeiro;
	protected Nodo ultimo;
	private static final int MAX_NUMERO = 61;

	public Radix() {
		this.primeiro = null;
		this.ultimo = null;
	}

	public void imprimirRadix() {
		Nodo atual = this.primeiro;
		if ( atual == null ) {
			System.out.println( "A lista de sorteios está vazia." );
			return;
		}

		while ( atual != null ) {
			System.out.println( atual.dado );
			atual = atual.prox;
		}
	}

	public void ordenaRadix() {
		if ( this.primeiro == null ) {
			return;
		}

		for ( int index = 5; index >= 0; index-- ) {
			this.primeiro = countingSort( this.primeiro, index );
		}

		Nodo atual = this.primeiro;
		Nodo anterior = null;
		while( atual != null ) {
			atual.ant = anterior;
			anterior = atual;
			if ( atual.prox == null ) {
				this.ultimo = atual;
			}
			atual = atual.prox;
		}
	}

	private Nodo countingSort( Nodo head, int index ) {

		Nodo[] heads = new Nodo[MAX_NUMERO];
		Nodo[] tails = new Nodo[MAX_NUMERO];

		Nodo atual = head;
		while (atual != null) {
			Nodo proximo = atual.prox;

			int valor = atual.dado.getNumero( index );

			if (heads[valor] == null) {
				heads[valor] = atual;
				tails[valor] = atual;
			} else {
				tails[valor].prox = atual;
				tails[valor] = atual;
			}

			atual.prox = null;
			atual = proximo;
		}

		Nodo novaHead = null;
		Nodo novoUltimo = null;

		for ( int i = 0; i < MAX_NUMERO; i++ ) {
			Nodo bucketHead = heads[ i ];
			Nodo bucketTail = tails[ i ];

			if ( bucketHead != null ) {
				if ( novaHead == null ) {
					novaHead = bucketHead;
					novoUltimo = bucketTail;
				} else {
					novoUltimo.prox = bucketHead;
					novoUltimo = bucketTail;
				}
			}
		}

		return novaHead;
	}
}