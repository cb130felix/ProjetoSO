/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_so;

import java.util.ArrayList;

/**
 *
 * @author Renan
 */
public class MemoriaVirtual implements TrocarPagina{
    
      ArrayList<Pagina> paginas;
      
      public MemoriaVirtual(int num_pag){
        
        this.paginas = new ArrayList<Pagina>(num_pag);
    
    }

    public int pegarValor(int indice_pagina){return 0;} 
    
    public void atualizarValor(int indice_pagina, float valor){} 

    @Override
    public void trocaPag(int pag_resgatada) {
        
    }
    
    
    
}
