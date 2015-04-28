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

//Essa classe é criado por pura viadagem. ATF puro, só pra mostar na tela como
//se encontra o SO nesse determinado momento.
public class SOInfo extends Thread{
    
     boolean pausa = false;
     SistemaOperacional so;
     
    public SOInfo(SistemaOperacional so) {
        this.so = so;
    }
    
    public void interfaceTexto(boolean ligado) throws InterruptedException{
        while(ligado){
            
                sleep(300);
                if(pausa == false){
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    
                    System.out.println("Tempo virtual: " + so.clock.time);
                    
                    for (int i = 0; i < so.processos.size(); i++) {
                        
                        System.out.println("Processo["+i+"]"+": " + " /Inicio: " + so.processos.get(i).inicioRam + " /Final: " + so.processos.get(i).finalRam + " /Proximo comando: " + so.processos.get(i).lerComando() );
                    }
                    
                    System.out.println("");
                    
                    for(int i = 0; i < so.mv.paginas.size(); i++){
                    System.out.println("Virtual["+i+"]-> M: " + so.mv.paginas.get(i).modificada + "\t/R: " + so.mv.paginas.get(i).referenciado + "\t/P:" + so.mv.paginas.get(i).presente + " \t/Moldura: " + so.mv.paginas.get(i).enderecoFisico + "\t/Tempo: " + so.mv.paginas.get(i).tempo);
                    }
                    //Imprimindo a memória fisica
                    System.out.print("\nMemoria Física { ");
                    for(int i = 0; i < so.mv.memoriaFisica.valores.size(); i++){
                    System.out.print(so.mv.memoriaFisica.valores.get(i) + ", ");
                    }
                    System.out.println(" }");
                    //Imprimindo o disco
                    System.out.print("HD { ");
                    for(int i = 0; i < so.mv.hd.valores.size(); i++){
                    System.out.print(so.mv.hd.valores.get(i) + ", ");
                    }
                    System.out.println(" }");
                    System.out.println(">>>>>>>>>>> Pressione Enter para pausar ou despausar o processo!");
                    
                    
                    
                    int j = 0;
                    int i;
                    for( i = 0 ; i < so.processos.size(); i++){
                    if(so.processos.get(i).emExecucao == false){
                        j++;
                    }
                    }
                    if(j == i){break;}

                    
        
        
        
        }
         
        }
        
        this.so.clock.ligado = false;
    }
    
    public void run(){
       
        try {
            interfaceTexto(true);
        } catch (InterruptedException ex) {
            Logger.getLogger(SOInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
