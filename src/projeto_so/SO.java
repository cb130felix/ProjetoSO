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
    
    public SO(int hd_pag, int mf_pag, int mv_pag){
        
        this.hd = new HD(hd_pag);
        this.mv = new MemoriaVirtual(mv_pag);
        this.mf = new MemoriaFisica(mf_pag);
    
    }
    
}
