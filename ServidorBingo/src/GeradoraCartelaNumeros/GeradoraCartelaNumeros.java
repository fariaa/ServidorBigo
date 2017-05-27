package GeradoraCartelaNumeros;

import java.util.*;

public class GeradoraCartelaNumeros {
	
	public static ArrayList<TreeSet<Integer>> gerarTabelasRodada(int qtd)
	{
		ArrayList<TreeSet<Integer>> listaCartela = new ArrayList<TreeSet<Integer>>();
		Random gerador = new Random();
	    do
	    {
	    	TreeSet<Integer> lista = new TreeSet<Integer>();

	    	TreeSet<Integer> b = new TreeSet<Integer>();
	    	TreeSet<Integer> i = new TreeSet<Integer>();
	    	TreeSet<Integer> n = new TreeSet<Integer>();
	    	TreeSet<Integer> g = new TreeSet<Integer>();
	    	TreeSet<Integer> o = new TreeSet<Integer>();
	    	do
	    	{
	    		b.add(gerador.nextInt(15) + 1);
	    	}while(b.size() < 5);
	    	do
	    	{
	    		i.add(gerador.nextInt(15) + 16);
	    	}while(i.size() < 5);
	    	do
	    	{
	    		n.add(gerador.nextInt(15) + 31);
	    	}while(n.size() < 5);
	    	do
	    	{
	    		g.add(gerador.nextInt(15) + 46);
	    	}while(g.size() < 5);
	    	do
	    	{
	    		o.add(gerador.nextInt(15) + 61);
	    	}while(o.size() < 5);
	    	
	    	
	    	/*
	    	do
	    	{
		    	/*Integer b[], i[], n[], g[], o[];
	    		b = new Integer[5];
				i = new Integer[5];
				n = new Integer[5];
				g = new Integer[5];
				o = new Integer[5];
				*/
			/*
	    		if(b.size() < 6)
    				
    			
    			if(i.size() < 6)
    				i.add(gerador.nextInt(15) + 16);
    			
    			if(n.size() < 6)
    				n.add(gerador.nextInt(15) + 31);
    			
    			if(g.size() < 6)
    				g.add(gerador.nextInt(15) + 46);
    			
    			if(o.size() < 6)
    				o.add(gerador.nextInt(15) + 61);
    			
	    	}while(b.size() < 6 && 
	    		   i.size() < 6 && 
	    		   n.size() < 6 && 
	    		   g.size() < 6 && 
	    		   o.size() < 6);
	    	*/
	    	
	    	//System.out.println(b.toString());
	    	//System.out.println(i.toString());
	    	//System.out.println(n.toString());
	    	//System.out.println(g.toString());
	    	//System.out.println(o.toString());
	    	
	    	lista.addAll(b);
	    	lista.addAll(i);
	    	lista.addAll(n);
	    	lista.addAll(g);
	    	lista.addAll(o);
	    	
	    	listaCartela.add(lista);
		}while(listaCartela.size() < qtd);
	    System.out.println(listaCartela.toString());
	    return listaCartela;
	}
}
