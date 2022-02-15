package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	
	static {
		Empresa empresa = new Empresa("Alura");
		Empresa empresa2 = new Empresa("Caelum");
		lista.add(empresa);
		lista.add(empresa2);
	}
	
	
	public void adiciona(Empresa empresa) {
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}
	
	
}
