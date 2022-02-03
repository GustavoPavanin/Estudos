package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteObject {

	public static void main(String[] args) {
		//System.out.println("x");
		//System.out.println(3);
		//System.out.println(false);
		
		//Referencia expecífica
		ContaCorrente cc = new ContaCorrente(22, 33);
		//Referencia generica (polimorfismo)
		Conta cp = new ContaPoupanca(33, 22);
		//Referencia mais generica (polimorfismo)
		Object Cliente = new Cliente();
		
		System.out.println(cc.toString());
		System.out.println(cp); //toString() implícito;
		
		//println(cc);
		//println(cp);
		//println(Cliente);

	}

	static void println() {}
	static void println(int a) {}
	static void println(boolean valor) {}
	static void println(Object referencia) {}
}
