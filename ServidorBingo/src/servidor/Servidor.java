package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import GeradoraCartelaNumeros.GeradoraCartelaNumeros;
import bd.dbos.Jogador;

public class Servidor extends Thread{
	private static List<Integer> listaNumerosSorteados  = new ArrayList<Integer>();
	private static Iterator<Integer> iterator;
	
	private static List<Jogador> listaJogadores = new ArrayList<>();
	private static List<Socket> listaCliente = new ArrayList<>();
	private ServerSocket servidor;
	public Sorteio sorteio;
	private ArrayList<TreeSet<Integer>> cartelas = GeradoraCartelaNumeros.gerarTabelasRodada(5);
	private static int contador = -1;
	
	private static void populaSorteio()
	{
		int cont = 1;
		do
		{
			listaNumerosSorteados.add(cont);
			cont++;
		}while(cont <= 75);
		Collections.shuffle(listaNumerosSorteados);
		iterator = listaNumerosSorteados.iterator();
	}
	
	public Servidor() throws IOException
	{
		this.populaSorteio();
		this.servidor = new ServerSocket(5000);
		this.sorteio = new Sorteio(listaCliente, cartelas, listaNumerosSorteados, iterator);
		this.sorteio.start();
	}
	
	public void run()
	{
		System.out.println("servidor");
		while(true)
		{
			try
			{
				Socket cliente = servidor.accept();
				if(this.contador < 5){
					Record record = new Record(cliente);
					record.start();
					Acesso acesso  = new Acesso(cliente, record, listaJogadores, listaCliente, this.contador);
					acesso.start();
					new Thread(new ServirCliente(cliente, this.sorteio)).start();
				}
				
			}catch(Exception e){}
		}
	}
}