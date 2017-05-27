package servidor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import bd.dbos.Jogador;

public class ServirCliente extends Thread {
	
	private Scanner leitor;
	private Socket socket;
	private Sorteio sorteio;
	private boolean ganhador;
	
	public ServirCliente(Socket socket, Sorteio sorteio)
	{
		this.socket = socket; 
		this.sorteio = sorteio;
		
		try{
			leitor = new Scanner(socket.getInputStream());
		}catch(IOException e){ }
	}
	
	@Override
	public void run() {
		String msg;
		try{
			while((msg = leitor.nextLine()) != null)
			{
				System.out.println(msg);
				if(msg.contains("B:")){
					System.out.println("BINGO!!!!");
					String[] partes = msg.split(";");
					Integer codigo = Integer.parseInt(partes[1]);
					Integer numeros[] = new Integer[25];
					int cont = 0;
					for(String l: partes[2].split(","))
					{
						numeros[cont] = Integer.parseInt(l);
						System.out.print("cont-> " + numeros[cont]);
						cont++;
					}
					this.sorteio.confereJogo(codigo, numeros, this.ganhador);
				}
				
				if(this.ganhador)
				{
					//ganhou o bingo!!!
				}
				
				if(msg.contains("C:")){
					String[] partes = msg.split(";");
					Integer codigo = Integer.parseInt(partes[1]);
					String  email = partes[2];
					String  senha = partes[3];
					
					try
					{
						new Thread(new Cadastro(codigo, email, senha, this.socket)).start();
					}catch(Exception ex){
						
					}
				}
			}
			
		}catch(Exception ex){ }
	}
}
