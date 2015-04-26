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
public class SOInfo extends Thread{
    
     SistemaOperacional so;

    public SOInfo(SistemaOperacional so) {
        this.so = so;
    }
    
    public void interfaceTexto() throws InterruptedException{
        while(true){
             
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    
                    System.out.println("Tempo virtual: " + so.clock.time);
                    for (int i = 0; i < so.processos.size(); i++) {
                        
                        System.out.println("Processo["+i+"]"+": " + so.processos.get(i).emExecucao);
                    }

                    for(int i = 0; i < so.mv.paginas.size(); i++){
                    System.out.println("Virtual["+i+"]-> M: " + so.mv.paginas.get(i).modificada + " /R: " + so.mv.paginas.get(i).referenciado + " /P:" + so.mv.paginas.get(i).presente + " /Molddura: " + so.mv.paginas.get(i).enderecoFisico + " /Tempo: " + so.mv.paginas.get(i).tempo);
                    }
                    sleep(1000);

        }
    }
    
    public void run(){
       
        try {
            interfaceTexto();
        } catch (InterruptedException ex) {
            Logger.getLogger(SOInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
