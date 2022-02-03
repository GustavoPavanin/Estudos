package packclass;

public class Imc {
	private double altura;
	private double peso;
	
	public double calculaImc() {
		return this.peso / (this.altura*this.altura);
	}
	
	
	/*Setters*/
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	/*Getters*/
	public double getAltura() {
		return altura;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public String verificaSituacao() {
		double imc = calculaImc();
		String situacao = "";
		
		if(imc < 18.5) {
			situacao = ("Abaixo do Peso, IMC: "+imc);
		}else if(imc <= 24.9) {
			situacao=("Peso Ideal, IMC: "+imc);
		}else if(imc <=29.9){
            situacao=("Levemente acima do Peso, IMC: "+imc);
            }
		
		return situacao;
	}
}
