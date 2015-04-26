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
                
                
                int indicePaginaDescartada=0;
                // FAZ O WS AQUI, GAY!
                // SE EU NÃO ME ENGANO, O MÉTODO DE WS IRÁ ME RETORNAR QUAL INDICE DA MEMORIA RAM QUE EU VOU PODER DESCATAR
                // AÍ É SÓ PEGAR ESSE VALOR, VERIFICAR AS RESTRIÇÕES (AQUELA PUTARIA DE MODIFICADO, ALTERADO, REFERECIADO)
                // E ATUALIZAR A MEMÓRIA NESSE TAL INDICE. CASO EU TENHA ALGUMA RESTRIÇÃO, EU VOU SALVAR ALGO NO HD (OU NÃO).
                // temp = moldura do retorno do ws;
               
                indicePaginaDescartada = ws.executarWs(tempoVirtual, paginas);
                //System.out.println("Falta de página! Entrou[" + endereco + "] / Saiu["+indicePaginaDescartada+"}");
                //System.out.println(paginas.get(indicePaginaDescartada).enderecoFisico);
                temp = paginas.get(indicePaginaDescartada).enderecoFisico;
                
                if(paginas.get(teste).modificada == true){
                //Atualiza o disco
                    this.hd.valores.set(indicePaginaDescartada, memoriaFisica.valores.get(temp));
                }
                
                paginas.get(indicePaginaDescartada).limpar();
                
            }else{//System.out.println("Tinha espaço de memória!");
                
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
        
        int temp = -1,teste = 0;
        
        if(paginas.get(endereco).presente == true){
        
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
                
                    // FUDEU, WS!
                    
                }
                
                memoriaFisica.valores.set(temp,(Integer)valor);
                paginas.get(endereco).modificada = true;
                paginas.get(endereco).presente = true;
                paginas.get(endereco).referenciado = true;
                paginas.get(endereco).enderecoFisico = temp;
            
        }
        
        
    }
    
    
}// fim =]
