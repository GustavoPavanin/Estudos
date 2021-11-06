
public class TestaConversao {
	public static void main(String[] args) {
		double salario = 1270.50;
		int valor = (int) salario;
		System.out.println(valor);
		
		//int i guarda até 200000000, 32 bits
		//long l ocupa 64bits, para números muito maiores
		//short s valor pequeno 16 bits
		//byte b 8 bits
		
		double valor1 = 0.2;
		double valor2 = 0.1;
		double total = valor1 + valor2;
		System.out.println(total);
	}
}
