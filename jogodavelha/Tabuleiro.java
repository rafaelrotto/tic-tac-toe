package jogodavelha;

/**
 * Essa classe serve para definir e alterar o Tabuleiro
 * @author Rafael Roesler Otto
 *
 */

public class Tabuleiro {
    private int[][] tabuleiro= new int[3][3];
    
    /**
     * Método que zera o tabuleiro
     */
    public Tabuleiro(){
        zerarTabuleiro();
    }
    /**
     * Método respoável por deixar o tabuleiro vazio
     */
    public void zerarTabuleiro(){
        for(int linha=0 ; linha<3 ; linha++)
            for(int coluna=0 ; coluna<3 ; coluna++)
                tabuleiro[linha][coluna]=0;
    }
    /**
     * Método responsável pela demonstração do tabuleiro
     */
    public void exibeTabuleiro(){
        System.out.println();
        for(int linha=0 ; linha<3 ; linha++){
        
            for(int coluna=0 ; coluna<3 ; coluna++){
                
                if(tabuleiro[linha][coluna]==-1){
                    System.out.print(" X ");
                }
                if(tabuleiro[linha][coluna]==1){
                    System.out.print(" O ");
                }
                if(tabuleiro[linha][coluna]==0){
                    System.out.print("   ");
                }
                
                if(coluna==0 || coluna==1)
                    System.out.print("|");
                
            }
            System.out.println();
        }
                
    }
/**
 * Método responsável por retornar a posição escolhida pelo jogador
 * @param tentativa diz respeito a jogada de um jogador
 * @return retorna a jogada de um jogador
 */
    public int getPosicao(int[] tentativa){
        return tabuleiro[tentativa[0]][tentativa[1]];
    }
    /**
     * Método responsável por definir a posição escolhida por um jogador
     * @param tentativa diz respeito a jogada de um jogador
     * @param jogador define qual jogador está jogando
     */
    public void setPosicao(int[] tentativa, int jogador){
        if(jogador == 1)
            tabuleiro[tentativa[0]][tentativa[1]] = -1;
        else
            tabuleiro[tentativa[0]][tentativa[1]] = 1;
        
        exibeTabuleiro();
    }
/**
 * verifica as linhas do tabuleiro, e se elas não foram completadas
 * @return retorna se a linha está ou não completa
 */
    public int checaLinhas(){
        for(int linha=0 ; linha<3 ; linha++){

            if( (tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == -3)
                return -1;
            if( (tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == 3)
                return 1;
        }
        return 0;
                
    }
/**
 * verifica as colunas do tabuleiro, e se elas não foram completadas
 * @return retorna se a coluna está ou não completa
 */
    public int checaColunas(){
        for(int coluna=0 ; coluna<3 ; coluna++){

            if( (tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == -3)
                return -1;
            if( (tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == 3)
                return 1;
        }
        
        return 0;
                
    }
/**
 * verifica as diagonais do tabuleiro, e se elas não foram completadas
 * @return retorna se a diagonal está ou não completa
 */
    public int checaDiagonais(){
        if( (tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == -3)
            return -1;
        if( (tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == 3)
            return 1;
        if( (tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == -3)
            return -1;
        if( (tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == 3)
            return 1;
        
        return 0;
    }
    
    /**
     * verifica se o tabuleiro está completo em caso de empate ou todas as possibilidades de jogo estarem preenchidas
     * @return retorna false ou true para a verificação do tabuleiro completo
     */
    public boolean tabuleiroCompleto(){
        for(int linha=0 ; linha<3 ; linha++)
            for(int coluna=0 ; coluna<3 ; coluna++)
                if( tabuleiro[linha][coluna]==0 )
                    return false;
        return true;
    }
}
