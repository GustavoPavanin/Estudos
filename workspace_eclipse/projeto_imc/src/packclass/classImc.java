/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packclass;

/**
 *
 * @author Administrador
 */
public class classImc {

    /**
     * @return the Altura
     */
    public double getAltura() {
        return Altura;
    }

    /**
     * @param Altura the Altura to set
     */
    public void setAltura(double Altura) {
        this.Altura = Altura;
    }

    /**
     * @return the Peso
     */
    public double getPeso() {
        return Peso;
    }

    /**
     * @param Peso the Peso to set
     */
    public void setPeso(double Peso) {
        this.Peso = Peso;
    }
    
    private double Altura;
    private double Peso;
    
    public double calculaImc(){
    double imc = this.Peso/(this.Altura*this.Altura);
    
    return imc;
    
    
    }
    
    public String verificaSituacao(){
        double imc = calculaImc();
        String situacao="";
        
        if(imc <= 18.5){
            situacao=("Abaixo do Peso");
        }
            else if(imc <= 24.9){
                situacao=("Peso Ideal");
            }
                else if(imc <=29.9){
                situacao=("Levemente acima do Peso");
                }
                else{
                    situacao=("Obesidade");
                }
        return situacao;
    }
}
