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
        tamanho = (finalRam - inicioRam) + 1;
        this.entrada =  new FabricaDeEntradas(tamanho).getNewEntrada();
        System.out.println(entrada);
               
    }
    
    String lerComando(){
        String comando = null;
        
        
        
        if(entrada.length() > 4){
         int i = 0;
         for(i = 0; i < this.entrada.length(); i++){
            if(this.entrada.charAt(i) == 'W' || this.entrada.charAt(i) == 'R'){
            break;
            }
         }
        
            comando = this.entrada.substring(0, i+1);
        }else{
            comando = "Acabaram os comando!";
        }
        return comando;
    }
    
    String pegarComando(){
        int i = 0; String comando = "";
      
            for(i = 0; i < this.entrada.length(); i++){
                if(this.entrada.charAt(i) == 'W' || this.entrada.charAt(i) == 'R'){
                break;
                }

            }
        
        comando = this.entrada.substring(0, i+1);

        if(entrada.contains(",")){
         this.entrada = this.entrada.substring(i+2, entrada.length());
        }
        

         return comando;
    }
    
    void teste() throws InterruptedException{
    
        while(entrada.length() > 3){
            this.sleep(1000);
            String comando = pegarComando();
            String[] comandoTratado = comando.split("-");
            if(comandoTratado[1].equals("R")){
                mv.pegarValor(Integer.parseInt(comandoTratado[0])+inicioRam);
            }else if(comandoTratado[1].equals("W")){
                mv.atualizarValor(Integer.parseInt(comandoTratado[0])+inicioRam, 100);
            }
            
            
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
