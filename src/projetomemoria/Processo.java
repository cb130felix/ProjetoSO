/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomemoria;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renan
 */
public class Processo extends Thread{
    
    boolean emExecucao;
    Virtual mv;
    int inicioRam, finalRam, tamanho;
    String entrada;
    

    public Processo(int inicioRam, int finalRam) {
        
        this.inicioRam = inicioRam;
        this.finalRam = finalRam;
        tamanho = finalRam - inicioRam;
        this.entrada =  new FabricaDeEntradas(tamanho).getNewEntrada();
               
    }
    
    void teste() throws InterruptedException{
    
        for(int i = 0; i <= tamanho; i++){
            
            this.sleep(1000);
            mv.atualizarValor(i+inicioRam, 100);
            
            
        }
        emExecucao = false;
        
    }
    
    public void run(){
        
        try {
            teste();
        } catch (InterruptedException ex) {
            Logger.getLogger(Processo.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    
}
