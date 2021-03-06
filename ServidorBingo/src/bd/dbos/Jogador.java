package bd.dbos;

public class Jogador {
	
	
	
	public Jogador(int codigo, String email, String senha, String primeiraDataMes, int qtdVitoriasMes) {
		super();
		this.codigo = codigo;
		this.email = email;
		this.senha = senha;
		this.primeiraDataMes = primeiraDataMes;
		this.qtdVitoriasMes = qtdVitoriasMes;
	}

	public Jogador(int codigo, String email) {
		this.codigo = codigo;
		this.email = email;
	}
	
	public Jogador(int codigo, String email, String senha) {
		this.codigo = codigo;
		this.email = email;
		this.senha = senha;
	}
	
	public Jogador() {
	}
	
	private int codigo;
	private String email;
	private String senha;
	private String primeiraDataMes;
	private int qtdVitoriasMes;
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getPrimeiraDataMes() {
		return primeiraDataMes;
	}
	public void setPrimeiraDataMes(String primeiraDataMes) {
		this.primeiraDataMes = primeiraDataMes;
	}
	public int getQtdVitoriasMes() {
		return qtdVitoriasMes;
	}
	public void setQtdVitoriasMes(int qtdVitoriasMes) {
		this.qtdVitoriasMes = qtdVitoriasMes;
	}
	
	
	
}
