package servidor;

import java.net.Socket;
import java.util.List;
import java.util.Scanner;

import bd.daos.Jogadores;
import bd.dbos.Jogador;

import java.io.IOException;
import java.io.PrintWriter;

public class Record extends Thread {
	
	private PrintWriter escritor;
	private boolean acesso;
	private Jogadores jogadoresDao;
	
	public void setAcesso(boolean acesso)
	{
		this.acesso = acesso;
	}
	
	public Record(Socket cliente) throws IOException
	{
		System.out.println("Entrou");
		this.escritor = new PrintWriter(cliente.getOutputStream());
	}
	
	public void run()
	{
		try
		{
			while(!acesso)
			{
				this.jogadoresDao = new Jogadores();
				List<Jogador> records = jogadoresDao.getJogadoresRecords();
				String jogadoresRecords ="";
				for(Jogador jo: records)
				{
					jogadoresRecords += jo.getEmail() + "," + jo.getQtdVitoriasMes() + ";"; 
				}
				//System.out.println("Ol� mundo");
				this.escritor.println(jogadoresRecords);
				this.escritor.flush();
				this.sleep(10000);
				
			}
		}catch(Exception ex){}
	}
}
