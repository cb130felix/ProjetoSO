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
public class HD {
        
    //public Integer[] valores;
    ArrayList<Integer> valores; 
    
    public HD(int tamanho){
        
        valores = new ArrayList<Integer>();
        
        for (int x = 0; x < tamanho; x++) {
            
            valores.add(x*100);
            
        }
    
    
    }
    
    
}
