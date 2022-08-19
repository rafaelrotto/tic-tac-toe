package jogodavelha;

import java.util.Scanner;
import entradadados.Console;
import armazenamento.NomeJogador;
import armazenamento.GerenciaJogadoresArquivo;
/**
 * Esta classe serve para definir os eventos do jogo
 * @author Rafael Roesler Otto
 *
 */

public class Jogo extends Jogada{
    private Tabuleiro tabuleiro;
    private Console console;
    private NomeJogador nome;
    private GerenciaJogadoresArquivo arquivo;
    private String nomeJogador1, nomeJogador2, nomeGanhador;
    private int rodada=1, vez=1;
    private Jogador jogador1;
    private Jogador jogador2;
    public Scanner entrada = new Scanner(System.in);
    //Console cons = new Console();
/**
 * Método utilizado para instanciar objetos e printar o tabuleiro vazio
 */
    public Jogo(){
        tabuleiro = new Tabuleiro();
        nome = new NomeJogador();
        arquivo = new GerenciaJogadoresArquivo();
        console = new Console();
        iniciarJogadores();
        System.out.println("\n");
        System.out.println("Tabuleiro:");
        tabuleiro.exibeTabuleiro();
        while( Jogar() );
    }
    
    /**
     * Esse método define qual tipo de jogador será criado e os inicia
     * jogador1 é o objeto do tipo jogador que será definido primeiro, podendo ser Humano ou Computador
     * jogador2 é o objeto do tipo jogador que será definido depois
     * nomeJogador1 recebe o nome do jogador 1
     * nomeJogador2 recebe o nome do jogador 2
     */
    
    public void iniciarJogadores(){
        System.out.println("Quem vai ser o Jogador 1 ?");
        if(escolherJogador() == 1) {
            this.jogador1 = new JogadorHumano(1);
        	System.out.println("Qual sera o nome do Jogador 1?");
        	nomeJogador1 = nome.getNome();
        }
        else {
            this.jogador1 = new JogadorComputador(1);
            nomeJogador1 = nome.getNomePc();
        }
        System.out.println("\n");
        System.out.println("Quem vai ser o Jogador 2 ?");
        
        if(escolherJogador() == 1) {
            this.jogador2 = new JogadorHumano(2);
        	System.out.println("Qual sera o nome do Jogador 2?");
        	nomeJogador2 = nome.getNome();
        }else {
            this.jogador2 = new JogadorComputador(2);
            nomeJogador2 = nome.getNomePc();
        }
    }
    
    /**
     * Esse metodo capitura a resposta sobre qual sera o tipo de jogador, Humano ou Computador
     * @return opcao retorna o valor digitado na classe Console
     */
    public int escolherJogador(){
    	int opcao=0;
		try {
        	do{
            	System.out.println("1. Humano");
            	System.out.println("2. Computador\n");
            	System.out.print("Opcao: ");
            	opcao = console.getValor();
            
            	if(opcao != 1 && opcao != 2)
            		System.out.println("Opcao invalida! Tente novamente");
        	}while(opcao != 1 && opcao != 2);
		}catch(Exception erro) {
			System.out.println("Valor invalido digitado! Erro " +erro);
		}
        return opcao;
    }
    /**
     * Esse método define de qual jogador é a vez e assim o chama
     * Também define quem será o vencedor
     * nomeGanhador serve para receber o nome do jogador que ganhou o jogo
     * Por final é gravado o nome do vencedor em um documento .txt
     */
    public boolean Jogar(){
        if(ganhou() == 0 ){
            System.out.println("\n");
            System.out.println("\nRodada "+rodada);
            System.out.println("Eh a vez do jogador " + vez() );
            
            if(vez()==1)
                jogador1.jogar(tabuleiro);
            else
                jogador2.jogar(tabuleiro);
            
            
            if(tabuleiro.tabuleiroCompleto()){
                System.out.println("Tabuleiro Completo. Jogo empatado");
                return false;
            }
            vez++;
            rodada++;

            return true;
        } else{
            if(ganhou() == -1) {
                System.out.println(nomeJogador1 + " ganhou!");
            	nomeGanhador = nomeJogador1;
            	arquivo.gravarVencedores(nomeGanhador);
            	arquivo.mostrarVencedores();
            }
            else {
                System.out.println(nomeJogador2 + " ganhou!");
                nomeGanhador = nomeJogador2;
                arquivo.gravarVencedores(nomeGanhador);
                arquivo.mostrarVencedores();
            }
            
            return false;
        }
            
    }
    
    /**
     * Esse método é utilizado para definir e passar a vez
     * @return 1 = vez do jogador 1
     * @return 2 = vez do jogador 2 
     */
    public int vez(){
        if(vez%2 == 1)
            return 1;
        else
            return 2;
    }
    
    /**
     * Esse método serve para dizer se o jogador ganhou ou não
     * @return 1 = jogador 1 ganhou
     * @return -1 = jogador 2 ganhou
     */
    
    public int ganhou(){
        if(tabuleiro.checaLinhas() == 1)
            return 1;
        if(tabuleiro.checaColunas() == 1)
            return 1;
        if(tabuleiro.checaDiagonais() == 1)
            return 1;
        
        if(tabuleiro.checaLinhas() == -1)
            return -1;
        if(tabuleiro.checaColunas() == -1)
            return -1;
        if(tabuleiro.checaDiagonais() == -1)
            return -1;
        
        return 0;
    }
    
    
}