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
public class MemoriaVirtual{
    
    MMU mmu;
        
    public MemoriaVirtual(int num_pag){
    
        this.mmu = new MMU(num_pag);
        
    }
    
   
    
    
    
}
