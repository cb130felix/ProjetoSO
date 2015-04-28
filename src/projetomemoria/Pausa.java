/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomemoria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renan
 */
public class Pausa extends Thread {
    
    boolean pause = false;
    SistemaOperacional so;
    SOInfo info;

    public Pausa(SistemaOperacional so) {
        this.so = so;
        this.info = so.info;
    }
    
    
    
    
    public void run(){
    
        this.pause = true;
        info.pausa = true;
        for(int i = 0; i < this.so.processos.size(); i++){
                            this.so.processos.get(i).pausa = true;
        }
        //Iniciando os processos com pausados                
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try{

                int ascii = br.read();
                if(ascii == 10){

                    if(pause == false){
                        for(int i = 0; i < this.so.processos.size(); i++){
                            this.so.processos.get(i).pausa = true;
                        }
                        info.pausa = true;
                        so.clock.pausa = true;
                        pause = true;
                   
                    }else{
                        for(int i = 0; i < this.so.processos.size(); i++){
                            this.so.processos.get(i).pausa = false;
                        } 
                        info.pausa = false;
                        so.clock.pausa = false;
                        pause = false;
                        
                    }
                
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }
    
    
    }
    
}
