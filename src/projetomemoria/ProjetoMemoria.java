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
public class ProjetoMemoria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
     
        
        int exemplo = 1;
        SistemaOperacional so = new SistemaOperacional(20); // Sistema Operacional sendo criado com um HD e MV de tamanho 20 e RAM de 10
        

        //Aqui a gente tem dois exemplos, é só escolher um e rodar pra ver ele funcionando.
        //No SO da pra adicionar processos. Ao criar um processo você precisa informar de onde
        //um processo começa a enxergar a memória até onde ele termina de enxergar ela
        
        //OBS interessante: Todos os comandos de escrita
        //escrevem o valor 24 na memória.
        
        //No primeiro exemplo temos a memória relativamente bem dividida para três processos. 
        //Ao final do programa podemos observar que muito provavelmente o HD vai conter
        //apenas numero 24 como dados, porque é muito provável que todas as páginas
        //fiquem "obsoletas" pelo menos uma vez durante a execução do programa.
        
        //No segundo exemplo temos um processo que ocupa quase toda a memória virtual
        //e um segundo processo que ocupa um pequeno pedaço dela. Dessa maneira
        //é muito improvável que uma página do processo 2 passe a ficar "velha",
        //pois a probabilidade dela ser referenciada novamente por um outro comando
        //é muito grande, já que a quantidade de páginas desse processo é menor.
        //Logo o HD provavelmente não vai ser atualizado com o valor 24 nos índices
        //referentes ao processo 2
        
        if(exemplo == 1){
            so.addProcesso(new Processo(0,10));
            so.addProcesso(new Processo(11,15));
            so.addProcesso(new Processo(16,19));
        }else if(exemplo == 2){
            
            so.addProcesso(new Processo(0,17));
            so.addProcesso(new Processo(17,19));
        
        }
        
        so.iniciarProcessos();
       
       
        System.out.println("\n\n\n\n\t\t\t>>>>>>>>>> Pressione Enter para iniciar o simulador de memoria virtual! <<<<<<<<<");
        System.out.println("\t\t>>>>>>>>>> Durante a execução, pressioner enter novamente para pausar/despausar o programa! <<<<<<<<<");
        
        Pausa pausa = new Pausa(so);
        pausa.start();
        
        
    }
   
}
