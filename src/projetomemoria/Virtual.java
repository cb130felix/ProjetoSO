/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomemoria;

import java.util.ArrayList;

/**
 *
 * @author Guto Leoni
 */
public class Virtual {
    
    
    HD hd ;
    RAM memoriaFisica;
    ArrayList<Pagina> paginas = new ArrayList<Pagina>();
    int ultimo = 0, tempoVirtual=0;
    WS ws = new WS();
    
    
    Virtual(HD hd, RAM ram){
            this.hd = hd;
           this.memoriaFisica = ram;
        
        for (int i = 0; i < hd.valores.size(); i++) {
         
          paginas.add(new Pagina());
           
        }
        
 
        
    }
    
    
    public synchronized Integer pegarValor(int endereco){
        
        int temp = -1,teste = 0;
        
        if(paginas.get(endereco).presente == false){// verificando se existe mapeamento
            
            
            for (int i = 0; i < memoriaFisica.valores.size(); i++) {
                
                if(memoriaFisica.valores.get(i) == null){
                
                    temp = i;
                    break;
                }
                
                else{// se esse contador for do tamanho da memoria fisica, quer dizer que todos o endereços de memoria estão cheios
                    
                    teste++;
                
                }
                
                
            }// fim do for
            
            if(teste == memoriaFisica.valores.size()){
           
                //WS vai indicar qual a página virtual que vai vazar
                int indicePaginaDescartada = ws.executarWs(tempoVirtual, paginas);
                temp = paginas.get(indicePaginaDescartada).enderecoFisico;
                
                if(paginas.get(teste).modificada == true){
                    this.hd.valores.set(indicePaginaDescartada, memoriaFisica.valores.get(temp));
                    //Se ela tiver sido modificada, atualizar no HD né broder
                }
                
                paginas.get(indicePaginaDescartada).limpar();// Limpando os dados da página que perdeu o mapeamento pra memória física
                
            }
            
            memoriaFisica.valores.set(temp, hd.valores.get(endereco)); 
            paginas.get(endereco).referenciado = true;
            paginas.get(endereco).presente = true;
            paginas.get(endereco).tempo = tempoVirtual;
            paginas.get(endereco).enderecoFisico = temp;
            
            return memoriaFisica.valores.get(temp);
        }// fim do if
        
        
        else{// AQUI É QUANDO A PÁGINA ESTÁ PRESENTE
            paginas.get(endereco).referenciado = true;
            return memoriaFisica.valores.get(paginas.get(endereco).enderecoFisico);
                   
        }
    
    
    }// FIM DO MÉTODO PEGAR VALOR
    
    public synchronized void atualizarValor(int endereco,  int valor){
        
        int temp = -1,teste = 0;
        
        if(paginas.get(endereco).presente == true){
        
            paginas.get(endereco).modificada = true;
            paginas.get(endereco).referenciado = true;
            memoriaFisica.valores.set(paginas.get(endereco).enderecoFisico, valor);
        
        }
        
        
       
        else{
        
            for (int x = 0; x < memoriaFisica.valores.size(); x++) {
                
                if(memoriaFisica.valores.get(x) == null){
                
                    temp = x;
                    break;
                }
                
                else{// se esse contador for do tamanho da memoria fisica, quer dizer que todos o endereços de memoria estão cheios
                    
                    teste++;
                
                }
                
            }// fim do for
            
            
            if(teste == memoriaFisica.valores.size()){
                
                //WS vai indicar qual a página virtual que vai vazar
                int indicePaginaDescartada = ws.executarWs(tempoVirtual, paginas);
                temp = paginas.get(indicePaginaDescartada).enderecoFisico;
                
                if(paginas.get(teste).modificada == true){
                    this.hd.valores.set(indicePaginaDescartada, memoriaFisica.valores.get(temp));
                    //Se ela tiver sido modificada, atualizar no HD né broder
                }
                
                paginas.get(indicePaginaDescartada).limpar();// Limpando os dados da página que perdeu o mapeamento pra memória física
                
                    
                }
                
                memoriaFisica.valores.set(temp,(Integer)valor);
                paginas.get(endereco).modificada = true;
                paginas.get(endereco).presente = true;
                paginas.get(endereco).referenciado = true;
                paginas.get(endereco).tempo = tempoVirtual;
                paginas.get(endereco).enderecoFisico = temp;
            
        }
        
        
    }
    
    
}// fim =]
