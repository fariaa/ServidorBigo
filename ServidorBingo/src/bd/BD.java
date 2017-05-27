package bd;

import bd.core.*;
import bd.daos.*;
import bd.dbos.*;

public class BD
{
    public static final MeuPreparedStatement comando;
    public static final  Jogadores jogadores; //um como esse para cada classe DAO

    static
    {
    	MeuPreparedStatement _comando = null;
    	Jogadores            _jogadores  = null; //um como esse para cada classe DAO

    	try
        {
           /* _comando =
            new MeuPreparedStatement (
            "com.microsoft.sqlserver.jdbc.SQLServerDriver",
            "jdbc:sqlserver://fs5:1433;databasename=bdsqlac17",
            "bdsqlac17", "Xoufa4");
            System.out.println ("Conectado ao BD");
			*/
    		_comando =
    	            new MeuPreparedStatement (
    	            "com.mysql.jdbc.Driver",
    	            "jdbc:mysql://127.0.0.1:3307/bingo",
    	            "root", "usbw");
    		 System.out.println ("Conectado ao BD");
    		
            _jogadores = new Jogadores (); //um como esse para cada classe DAO
        }
        catch (Exception erro)
        {
            System.err.println ("Problemas de conexao com o BD");
            System.exit(0); // aborta o programa
        }
        
        comando = _comando;
        jogadores  = _jogadores; //um como esse para cada classe DAO
    }
}