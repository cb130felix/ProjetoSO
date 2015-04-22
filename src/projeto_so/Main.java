/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_so;

/**
 *
 * @author Renan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int num_pag = 10;
        SO so =  new SO(2 * num_pag,num_pag, 2 * num_pag); // Iniciando o SO
       
        System.out.println("Tamanho memoria virtual:" + so.mv.mmu.mapa.size());

        System.out.println("Tamanho memoria Fisica:" + so.mf.paginas.size());
        
        System.out.println("Tamanho disco:" + so.hd.paginas.size());
        
        
        float a = so.pegarValor(5); // só pra teste
        
        System.out.println("Valor: "+a);
        System.out.println("RAM(0) "+so.mf.paginas.get(0).valor);
        
        
        float c = so.pegarValor(5);
        System.out.println("Valor pegando direto da memoria Ram: "+c);
        
        
        float b = so.pegarValor(7);
        System.out.println("Valor B "+b);
        System.out.println("RAM(1) "+so.mf.paginas.get(1).valor);
        
        so.atualizarValor(5, a+b);
        
        System.out.println("Novo valor do incide 5 da memoria virtual apos ser escrito "+so.pegarValor(5));
        System.out.println("Memoria ram indice 0: "+so.mf.paginas.get(0).valor);
        System.out.println("Memoria ram indice 1: "+so.mf.paginas.get(1).valor);
               
                
    }
    
}
