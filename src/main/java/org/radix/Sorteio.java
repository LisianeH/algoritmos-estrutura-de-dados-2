package org.radix;

public class Sorteio {
	private int concurso;
	private int[] numeros;

	public Sorteio(int concurso, int[] numeros) {
		this.concurso = concurso;
		this.numeros = numeros;
	}

	public int getConcurso() {
		return concurso;
	}

	public int getNumero( int posicao ) {
		if ( posicao >= 0 && posicao < 6 ) {
			return numeros[posicao];
		}
		throw new IndexOutOfBoundsException( "Posição da dezena inválida: " + posicao );
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder( "[" );
		for ( int i = 0; i < numeros.length; i++ ) {
			sb.append( String.format( "%02d", numeros[ i ] ) );
			if ( i < numeros.length - 1 ) sb.append( "," );
		}
		sb.append( "] - " ).append( String.format( "%04d", concurso ) );
		return sb.toString();
	}
}
