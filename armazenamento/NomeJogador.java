package armazenamento;

public class NomeJogador implements GerenciaJogadores{
	private String nome; 
	@Override
	public void setNome(String nome){
		this.nome = nome;
	}
	@Override
	public String getNome() {
		return nome;
	}
}
