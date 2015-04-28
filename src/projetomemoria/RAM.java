/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomemoria;

import java.util.ArrayList;

/**
 * 
 *
 * @author Guto Leoni
 */
public class RAM {
    
    
    ArrayList<Integer> valores; 
    
    public RAM(int tamanho){
    
        valores = new ArrayList<Integer>();
        
        
            for (int i = 0; i < tamanho; i++) {
            
                valores.add(null); // Iniciando a memória RAM vazia
            
            }
        
           
    }
    
    
}
