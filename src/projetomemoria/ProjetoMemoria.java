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
    public static void main(String[] args) throws InterruptedException {
      
        /*
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
        */
        
       
        SistemaOperacional so = new SistemaOperacional(20);
        //Exemplo 1
        
        so.addProcesso(new Processo(0,10));
        so.addProcesso(new Processo(11,15));
        so.addProcesso(new Processo(16,19));
        
        //Exemplo 2
        /*
        so.addProcesso(new Processo(0,17));
        so.addProcesso(new Processo(17,19));
        */
        
        
        so.iniciarProcessos();
       
        
        
               
        
    }
   
}
