/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomemoria;

import java.util.ArrayList;

/**
 *
 * @author Renan
 */
public class SistemaOperacional {
    
    Virtual mv;
    Clock clock;   
    ArrayList<Processo> processos = new ArrayList<Processo>();
    
   public SistemaOperacional(int tamanho){
        
        
        RAM r = new RAM(tamanho/2);
        HD h = new HD(tamanho);
        mv = new Virtual(h, r);
        clock = new Clock(mv);
        clock.start();
        
   }
   
   public void iniciarProcessos(){
   
       for(int i = 0 ; i < processos.size(); i++){
           processos.get(i).start();
           processos.get(i).emExecucao = true;
           
       }
       SOInfo info = new SOInfo(this);
       info.start();
       
   }
   
   public void addProcesso(Processo processo){
   
       processo.mv = this.mv;
       this.processos.add(processo);
       
   }
   
       
}
