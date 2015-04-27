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
public class Clock extends Thread{
   
    Virtual mv;
    public int time = 0;
    boolean ligado = true;
    
    Clock(Virtual mv){
    
        this.mv = mv;
        
    }
    
    public void run(){
        
        
        //A cada ciclo de clock incremento +1 no tempoVirtual da mv e atualizo o
        //tempo das páginas que foram referenciadas recentemente
           
        while(ligado){
            
            
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }
            time++;
            mv.tempoVirtual++;
             for (int i = 0; i < mv.paginas.size(); i++) {
                if(mv.paginas.get(i).referenciado == true){
                    mv.paginas.get(i).referenciado = false;
                    mv.paginas.get(i).tempo = this.time;
                }
            }
            
        }
    }
    
}
