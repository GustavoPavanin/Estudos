
public class TesteSacaNegativo {
	public static void main(String[] args) {
		Conta conta = new Conta(1337,24226);
		System.out.println(conta.saca(200));
		
		System.out.println(conta.getSaldo());
		
		conta.saca(101);
			
	}
}
