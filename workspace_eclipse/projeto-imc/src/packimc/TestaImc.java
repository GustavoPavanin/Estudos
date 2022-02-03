package packimc;

import java.util.Locale;
import java.util.Scanner;

import packclass.Imc;

public class TestaImc {

	public static void main(String[] args) {

		Imc imc = new Imc();
		Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
		
		System.out.println("Digite a sua altura (em Metros):");
		imc.setAltura(scanner.nextDouble());
		
		System.out.println("Digite a sua altura (em Metros):");
		imc.setPeso(scanner.nextDouble());
		
		System.out.println(imc.verificaSituacao());

	}

}
