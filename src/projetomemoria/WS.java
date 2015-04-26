/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomemoria;

/**
 *
 * @author Renan
 */
public class WS {
    
    Virtual mv;
    
    public WS(Virtual mv){
    
        this.mv = mv;
    
    }
    
    public int executarWs(){
    
    
        for(int i = 0; i < mv.paginas.size(); i++){
        
            if(mv.paginas.get(i).referenciado == true){
                
                
            
            }
            
        }
        
        return 0;
    
    }
    
    
}
