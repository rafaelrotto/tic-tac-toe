package jogodavelha;

import java.util.Random;
/**
 * Essa classe é utilizada para criar um jogador do tipo computador, controlado pelo PC
 * @author Rafael Roesler Otto
 *
 */

public class JogadorComputador extends Jogador{
	/**
     * método responsável por iniciar um jogador Computador
     * @param jogador herdado da classe Jogador
     */
    
    public JogadorComputador(int jogador){
        super(jogador);
        System.out.println("Jogador Computador definido");
    }
    /**
     * responsável por definir a jogada de um jogador computador
     */
    @Override
    public void jogar(Tabuleiro tabuleiro){
        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador); 
    }
    /**
     * método responsável para receber o valor da jogada do computador através de valores aleatórios
     */
    @Override
    public void Tentativa(Tabuleiro tabuleiro){
        Random r = new Random();
        do{
            do{
                System.out.print("Linha: ");
                tentativa[0] = r.nextInt(4);
                
                if( tentativa[0] > 3 ||tentativa[0] < 1)
                    System.out.println("Linha invalida. Eh 1, 2 ou 3");
                
            }while( tentativa[0] > 3 ||tentativa[0] < 1);
            
            do{
                System.out.print("Coluna: ");
                tentativa[1] = r.nextInt(4);
                
                if(tentativa[1] > 3 ||tentativa[1] < 1)
                    System.out.println("Coluna invalida. Eh 1, 2 ou 3");
                
            }while(tentativa[1] > 3 ||tentativa[1] < 1);
            
            tentativa[0]--; 
            tentativa[1]--;
            
            if(!checaTentativa(tentativa, tabuleiro))
                System.out.println("Esse local ja foi marcado. Tente outro.");
        }while( !checaTentativa(tentativa, tabuleiro) );
    }
}
