package br.com.bytebank.banco.teste;

public class TesteString {
	public static void main(String[] args) {
		
		String nome = "Alura";
		String nomeEspacos = "   Alura    ";
		String vazio = "       ";
		String outroVazio = vazio.trim();
		System.out.println(vazio.isEmpty());
		System.out.println(outroVazio.isEmpty());
		//String outro = new String("Alura");
		
		//char c = nome.charAt(0);
		//System.out.println(c);
		
		//System.out.println(nome.indexOf("ur"));
		
		//System.out.println(nome.substring(0));
		//System.out.println(nome.length());
		System.out.println(nomeEspacos.contains("Alu"));
		for(int i = 0; i < nome.length(); i++) {
			System.out.println(nome.charAt(i));
		}
		
		//char c = 'A';
		//char d = 'a';
		//String outra = nome.replace(c, d);
		//String outra = nome.toLowerCase();
		//String outra = nome.toUpperCase();
		
		//System.out.println(nome);
		//System.out.println(outra);
	}
}
