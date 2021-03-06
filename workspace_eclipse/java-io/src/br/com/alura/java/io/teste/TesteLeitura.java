package br.com.alura.java.io.teste;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class TesteLeitura {

	public static void main(String[] args) throws IOException {

		//fluxo de entrada com Arquivo
		InputStream fis = new FileInputStream("loren.txt");
		Reader ist = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(ist);
		
		String linha = br.readLine();
		
		while(linha != null) {
			System.out.println(linha);
			linha = br.readLine();
		}
		
		
		br.close();
		 
	}

}
