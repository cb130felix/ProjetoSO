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
public class WS {

    
    public int executarWs(int tempoVirtual, ArrayList<Pagina> paginas){
    
        int idade = 0, t = 20, indicePaginaAntiga = -1, maiorIdade = 0;
        
        
        
        for(int i = 0; i < paginas.size(); i++){
        
            if(paginas.get(i).presente == true){
                
                if(paginas.get(i).referenciado == true){
                    // Só atualizando o tempo das páginas referenciadas
                    paginas.get(i).tempo = tempoVirtual;

                }else{
                    idade =  tempoVirtual - paginas.get(i).tempo;
                    //Caso idade > 20, a página roda... achei isso desnecessário, faz o codo ser redundante
                    if(idade > t){
                        indicePaginaAntiga = i;
                    }
                    //Aqui eu calculo a página mais velha pra dizer qual vai sair da MV
                    if(idade > maiorIdade){
                            maiorIdade = idade;
                            indicePaginaAntiga = i;
                            
                    }


                }
            }
            
        }
        
        if(indicePaginaAntiga == -1){
        //Caso aconteça de todas as páginas estarem com referenciado == true
             for(int i = 0; i < paginas.size(); i++){
                 if(paginas.get(i).presente == true){
 
                     return i;
                 
                 }
             }
        
        }

        return indicePaginaAntiga;
    
    }
    
    
}
