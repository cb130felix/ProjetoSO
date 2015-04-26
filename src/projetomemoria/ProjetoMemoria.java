/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomemoria;

/**
 *
 * @author Guto Leoni
 */
public class ProjetoMemoria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        int tamanho = 10;
        RAM r = new RAM(tamanho/2);
        HD h = new HD(tamanho);
        Virtual v = new Virtual(h, r);
        
        int a = v.pegarValor(2);
        System.out.println("A: "+a);
        
        int b = v.pegarValor(5);
        System.out.println("B: "+b);
        
        v.atualizarValor(2, b+a);
        
        int c =  v.pegarValor(2);
        System.out.println("Novo c: "+c);
        
    }
    
}