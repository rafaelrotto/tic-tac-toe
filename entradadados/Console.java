package entradadados;

import jogodavelha.Jogador;
import jogodavelha.Tabuleiro;
import java.util.Scanner;

public class Console {
	private Tabuleiro tabuleiro;
	
	public Scanner scan = new Scanner(System.in);
	
	public Console(){
		tabuleiro = new Tabuleiro();
	}
	
	public int escolherJogadores(){
		int opcao=0;
		try {
        	do{
            	System.out.println("1. Humano");
            	System.out.println("2. Computador\n");
            	System.out.print("Opcao: ");
            	opcao = scan.nextInt();
            
            	if(opcao != 1 && opcao != 2)
            		System.out.println("Opcao invalida! Tente novamente");
        	}while(opcao != 1 && opcao != 2);
		}catch(Exception erro) {
			System.out.println("Valor invalido digitado! Erro " +erro);
		}
        return opcao;
    }
}
