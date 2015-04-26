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
    int ultimo = 0;
    
    Virtual(HD hd, RAM ram){
            this.hd = hd;
           this.memoriaFisica = ram;
        
        for (int i = 0; i < hd.valores.size(); i++) {
         
          paginas.add(new Pagina());
           
        }
        
    }
    
    
    public Integer pegarValor(int endereco){
    
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
                // FAZ O WS AQUI, GAY!
                // SE EU NÃO ME ENGANO, O MÉTODO DE WS IRÁ ME RETORNAR QUAL INDICE DA MEMORIA RAM QUE EU VOU PODER DESCATAR
                // AÍ É SÓ PEGAR ESSE VALOR, VERIFICAR AS RESTRIÇÕES (AQUELA PUTARIA DE MODIFICADO, ALTERADO, REFERECIADO)
                // E ATUALIZAR A MEMÓRIA NESSE TAL INDICE. CASO EU TENHA ALGUMA RESTRIÇÃO, EU VOU SALVAR ALGO NO HD (OU NÃO).
                // temp = moldura do retorno do ws;
                
            }
            
            memoriaFisica.valores.set(temp, hd.valores.get(endereco)); 
            paginas.get(endereco).referenciado = true;
            paginas.get(endereco).presente = true;
            paginas.get(endereco).enderecoFisico = temp;
            
            return memoriaFisica.valores.get(temp);
        }// fim do if
        
        
        else{// AQUI É QUANDO A PÁGINA ESTÁ PRESENTE
            return memoriaFisica.valores.get(paginas.get(endereco).enderecoFisico);
                   
        }
    
    
    }// FIM DO MÉTODO PEGAR VALOR
    
    public void atualizarValor(int endereco,  int valor){

        if(paginas.get(endereco).presente == true){
        
            memoriaFisica.valores.set(paginas.get(endereco).enderecoFisico, valor);
        
        }
        
        
        
    }
    
    
}// fim =]
