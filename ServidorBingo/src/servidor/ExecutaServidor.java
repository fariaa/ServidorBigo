package servidor;

public class ExecutaServidor {
	
	public static void main(String[] args) {
		try
		{
			Servidor servidor =  new Servidor();
			servidor.start();
			
		}catch(Exception e) {}
	}

}
