package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;

	static {
		Empresa empresa = new Empresa();
		Empresa empresa2 = new Empresa();
		Empresa empresa3 = new Empresa();
		Empresa empresa4 = new Empresa();
		empresa.setNome("Alura");
		empresa.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		empresa2.setId(chaveSequencial++);
		empresa3.setNome("GoldSystem");
		empresa3.setId(chaveSequencial++);
		empresa4.setNome("Google");
		empresa4.setId(chaveSequencial++);
		lista.add(empresa);
		lista.add(empresa2);
		lista.add(empresa3);
		lista.add(empresa4);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}

	public void removeEmpresa(Integer id) {

		Iterator<Empresa> it = lista.iterator();

		while (it.hasNext()) {
			Empresa emp = it.next();

			if (emp.getId() == id) {
				it.remove();
			}
		}

	}

	public Empresa buscaEmpresaPorId(Integer id) {

		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

}
