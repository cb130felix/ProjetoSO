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
public class MMU {
    
    ArrayList<CelulaVirtual> mapa;
    
    public MMU(int tamanho){
        
        this.mapa = new ArrayList<CelulaVirtual>(tamanho);
        
        for (int i = 0; i < tamanho; i++) {
            this.mapa.add(new CelulaVirtual());
            
        }
    }
    
    
    
    
}
