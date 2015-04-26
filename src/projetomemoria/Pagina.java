/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomemoria;

/**
 *
 * @author Guto Leoni
 */
public class Pagina {
    
    
    boolean referenciado = false;
    boolean modificada = false;
    boolean presente = false;
    Integer enderecoFisico = null, tempo = 0;
    
    public void limpar(){
    
        referenciado = false;
        modificada = false;
        presente = false;
        enderecoFisico = null;
        tempo = 0;
        
    }
    
}
