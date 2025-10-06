package org.radix;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class LeitorExcel {

	public static void lerSorteios( String caminhoArquivo, Radix lista ) {

		try ( FileInputStream fis = new FileInputStream( caminhoArquivo );
		     Workbook workbook = new XSSFWorkbook( fis ) ) {

			Sheet sheet = workbook.getSheetAt( 0 );
			boolean isHeader = true;

			for ( Row row : sheet ) {
				if ( isHeader ) {
					isHeader = false; continue;
				}

				Cell cellConcurso = row.getCell( 0 );
				if ( cellConcurso == null || cellConcurso.getCellType() != CellType.NUMERIC ) continue;

				int concurso = ( int ) cellConcurso.getNumericCellValue();
				int[] numeros = new int[ 6 ];
				boolean dadosValidos = true;

				for ( int i = 0; i < 6; i++ ) {
					Cell cell = row.getCell( i + 2 );

					if ( cell == null || cell.getCellType() != CellType.NUMERIC ) {
						dadosValidos = false;
						break;
					}
					numeros[ i ] = ( int ) cell.getNumericCellValue();
				}

				if ( dadosValidos ) {
					Sorteio novoSorteio = new Sorteio( concurso, numeros );
					Nodo novoNodo = new Nodo(novoSorteio);

					if ( lista.primeiro == null ) {
						lista.primeiro = novoNodo;
						lista.ultimo = novoNodo;
					} else {
						lista.ultimo.prox = novoNodo;
						novoNodo.ant = lista.ultimo;
						lista.ultimo = novoNodo;
					}
				}
			}
		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo Excel. Verifique se o arquivo está fechado.");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Erro inesperado durante a leitura: " + e.getMessage());
			e.printStackTrace();
		}
	}
}