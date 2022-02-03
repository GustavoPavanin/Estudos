package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayListEquals {

	public static void main(String[] args) {

		//Generics <>
		ArrayList<Conta> lista = new ArrayList<Conta>();
//		
//		Conta cc = new ContaCorrente(22, 22);
//        Conta cc2 = new ContaCorrente(22, 22);
//        
//        boolean igual = cc.ehIgual(cc2);
//        System.out.println(igual);
        
        Conta cc = new ContaCorrente(22, 11);
        Conta cc2 = new ContaCorrente(22, 22);
        lista.add(cc);
        lista.add(cc2);
        
        Conta cc3 = new ContaCorrente(22, 22);
        
       boolean existe = lista.contains(cc3);
        
       System.out.println("Já existe? "+ existe); 

        for(Conta oRef : lista) {
        	System.out.println(oRef);
        }
        
        

	}

}
