package jogodavelha;

import java.util.Scanner;
import entradadados.Console;

/**
 * Classe responsável por criar um jogador do tipo Humano, controlado pelo usuário
 * @author Rafael Roesler Otto
 *
 */

public class JogadorHumano extends Jogador{
    
    public String nomeJogador;
    public Console console;
    
    /**
     * método responsável por iniciar um jogador Humano
     * @param jogador herdado da classe Jogador
     */
    public JogadorHumano(int jogador){
        super(jogador);
        console = new Console();
        this.jogador = jogador;
        System.out.println("Jogador Humano definido");
    }
    /**
     * responsável por definir a jogada de um jogador humano
     */
    @Override
    public void jogar(Tabuleiro tabuleiro){
        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    }
    /**
     * método responsável para receber o valor da jogada de um jogador
     */
    @Override
    public void Tentativa(Tabuleiro tabuleiro){
        do{
            do{
                System.out.print("Linha: ");
                tentativa[0] = console.getValor();
                
                if( tentativa[0] > 3 ||tentativa[0] < 1)
                    System.out.println("Linha invalida. Eh 1, 2 ou 3");
                
            }while( tentativa[0] > 3 ||tentativa[0] < 1);
            
            do{
                System.out.print("Coluna: ");
                tentativa[1] = console.getValor();
                
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
