/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_so;

/**
 *
 * @author Renan
 */
public class SO {
    
    HD hd;
    MemoriaFisica mf;
    MemoriaVirtual mv;
    TrocadorDePagina trocador;
    int ultimo = 0;
    
    public SO(int hd_pag, int mf_pag, int mv_pag){
        
        this.hd = new HD(hd_pag);
        this.mv = new MemoriaVirtual(mv_pag);
        this.mf = new MemoriaFisica(mf_pag);
        this.trocador = new TrocadorDePagina(this.mf, this.mv);
       

        
    }
    
        public float pegarValor(int indice_pagina){ // vamos dizer que esse indice é 2
        
            
            //this.trocador.trocarPag(2); // Exemplo de Troca de página. Vou tirar a página de indice 2 da memória física e pegar uma página do disco de acordo com o algoritmo que vou implementar.
            
             if(mv.mmu.mapa.get(indice_pagina).presente == false){
                
                 float temp;
                 
                 mf.paginas.set(ultimo, new Pagina(hd.paginas.get(indice_pagina).valor));
                 mf.paginas.get(ultimo).referenciada = true;
                 
                 mv.mmu.mapa.get(indice_pagina).endereco_virtual = indice_pagina; // é dispensável!
                 mv.mmu.mapa.get(indice_pagina).endereco_fisico = ultimo;// ROLA!
                 mv.mmu.mapa.get(indice_pagina).presente = true;
                 
                 temp = mf.paginas.get(ultimo).valor;
                 ultimo++;
                 
                 return temp;
             }
             
             
             else{
                 
                int endereco =  mv.mmu.mapa.get(indice_pagina).endereco_fisico;
                
                mf.paginas.get(endereco).referenciada = true;
                return mf.paginas.get(endereco).valor;
             }
            
        
        } 
    
        public void atualizarValor(int indice_pagina, float valor){//indice pagina é o indice da memoria virutal na qual será escrita
        
            
            if(mv.mmu.mapa.get(indice_pagina).presente == false){
                
            // sei lá o que faz...
            }
            
            else{
                
                int indice = mv.mmu.mapa.get(indice_pagina).endereco_fisico;
                    
                mf.paginas.get(indice).valor = valor; 
                mf.paginas.get(indice).modificada = true;
            }
            
        
        } 
        
    
    
}
