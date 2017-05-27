package Threads;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

import bd.BD;
import bd.daos.Jogadores;
import bd.dbos.Jogador;

public class ConexaoBDThread extends Thread{
	
	private BD bd;
	private Socket socket;
	private Scanner leitor;
	private PrintWriter escritor;
	public ConexaoBDThread(Socket socket) throws Exception
	{
		this.socket = socket;
		this.leitor = new Scanner(socket.getInputStream());
		this.escritor = new PrintWriter(socket.getOutputStream());
	}
	
	
	@Override
	public void run() {
		
		String msg;
		while((msg = leitor.nextLine()) != null)
		{
			try
			{
				Jogadores jogadores = new Jogadores();
				List<Jogador> listaRecords = jogadores.getJogadoresRecords();
				String jogadoresRecords="";
				for(Jogador jo: listaRecords)
				{
					jogadoresRecords += jo.getEmail() + "," + jo.getQtdVitoriasMes() + ";\n"; 
					System.out.println("Jogador: " + jo.getCodigo());
				}
				escritor.println(jogadoresRecords);
				escritor.flush();
			}catch(Exception ex){
				
			}
		}
	}	

}
