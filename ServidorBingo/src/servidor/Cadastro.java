package servidor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import bd.daos.Jogadores;
import bd.dbos.Jogador;

public class Cadastro extends Thread{
	
	private Jogadores jogadoresDao = new Jogadores();
	private Jogador jogador;
	private PrintWriter escritor;
	private boolean isValido;
	
	public Cadastro(int codigo, String email, String senha, Socket socket) throws Exception
	{
		this.jogador = new Jogador(codigo, email, senha);
		this.escritor = new PrintWriter(socket.getOutputStream());
	}
	
	public void criar() throws Exception
	{
		jogadoresDao.incluir(jogador);
		this.isValido = true;
	}
	
	public void run()
	{
		
		while(!isValido)
		{
			try
			{
				this.criar();
				if(this.isValido)
				{
					this.escritor.println("OK");
				}
			}catch(Exception ex){
				this.escritor.println("ERRO");
			}
		}
	}
	
}