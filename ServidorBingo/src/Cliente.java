import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
	
	PrintWriter escritor;
	public Cliente(String nome) {
		try{
			Socket socket = new Socket("192.168.0.11", 5000);
			escritor = new PrintWriter(socket.getOutputStream());
			escritor.println(nome);
			escritor.flush();
			
		}catch(Exception ex){}
	}
	
	public static void main(String[] args) {
		new Cliente("Lucas");
		new Cliente("Maria");
	}

}
