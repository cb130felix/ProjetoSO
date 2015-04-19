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
public class HD {
    
      ArrayList<Pagina> paginas;

    public HD(int num_pag){
        
        this.paginas = new ArrayList<Pagina>();
        
        for (int i = 0; i < num_pag; i++) {
            this.paginas.add(new Pagina());
            
        }
    
    }
      
      
    
}
