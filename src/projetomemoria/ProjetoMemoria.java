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
     
        
        int exemplo = 1;
        SistemaOperacional so = new SistemaOperacional(20);
        
        
        if(exemplo == 1){
            so.addProcesso(new Processo(0,10));
            so.addProcesso(new Processo(11,15));
            so.addProcesso(new Processo(16,19));
        }else if(exemplo == 2){
            so.addProcesso(new Processo(0,17));
            so.addProcesso(new Processo(17,19));
        
        }
        
        so.iniciarProcessos();
       
       
        
    }
   
}
