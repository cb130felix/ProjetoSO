/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomemoria;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Renan
 */
public class FabricaDeEntradas {
	
	public static final int QTD_ACESSO_ENTRADA = 100;
	private int tamanhoMemoriaVirtual = 0;
	private int seed;
	
	public FabricaDeEntradas(int tamanhoMemoria) {
		this.tamanhoMemoriaVirtual = tamanhoMemoria;
		Random r = new Random();
		this.seed = r.nextInt(tamanhoMemoria);
		System.out.println("Semente = " + seed);
		if(tamanhoMemoria < 1) {
			throw new IllegalArgumentException("Memória muito pequena - valor mínimo 1");
		}
		if(tamanhoMemoria > 40) {
			throw new IllegalArgumentException("Memória grande - valor máximo 40");
		}
		
		if(QTD_ACESSO_ENTRADA < 25) {
			throw new IllegalArgumentException("Tamanho da entrada não pode ser menor que 20");
		}
	}
	
	public String getNewEntrada() {
		String value = "";
		Random r = new Random(this.seed);
		
		ArrayList<Integer> reads = new ArrayList<Integer>();
		String[] loop = new String[4];
		int indexLoop = 0;
		
		StringBuffer sb = new StringBuffer();
		int loop1 = QTD_ACESSO_ENTRADA/3 * 1;
		int loop2 = QTD_ACESSO_ENTRADA/3 * 2;
		//System.out.println("Loop1 = "  + loop1 + " - loop2 = " + loop2);
		
		for (int i = 0; i < QTD_ACESSO_ENTRADA; i++) {
			if(i == loop1 || i == loop2) {
				//sb.append("|- ");
				for (int j = 0; j < loop.length; j++) {
					sb.append(loop[indexLoop++]);
					indexLoop = indexLoop % loop.length;
				}
				//sb.append(" -|");
				i = i + loop.length-1;
				continue;
			}
			
			int endereco = r.nextInt(tamanhoMemoriaVirtual);
			
			int index = reads.indexOf(endereco);
			if(index == -1) {
				sb.append(endereco + "-R,");
				loop[indexLoop++] = endereco + "-R,";
				indexLoop = indexLoop % loop.length;
				reads.add(endereco);
			} else {
				boolean tipoAcesso = r.nextBoolean();
				if(tipoAcesso) {
					sb.append(endereco + "-R,");
					loop[indexLoop++] = endereco + "-R,";
					indexLoop = indexLoop % loop.length;
				} else {
					sb.append(endereco + "-W,");
					loop[indexLoop++] = endereco + "-W,";
					indexLoop = indexLoop % loop.length;
				}
			}
		}
		
		value = sb.substring(0, sb.length()-1);
		return value;
	}
	
}