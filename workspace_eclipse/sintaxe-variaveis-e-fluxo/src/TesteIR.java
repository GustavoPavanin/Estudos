public class TesteIR {

    public static void main(String[] args) {

        double salario = 3300.0;

        
        if (salario >= 1900   && salario <= 2800) {
        	System.out.println("A sua aliquota � de 7%");
            System.out.println("Voc� pode deduzir at� R$ 142");
        } else if(salario > 2800 && salario <= 3751){
        	System.out.println("A sua aliquota � de 15%");
            System.out.println("Voc� pode deduzir at� R$ 350");
        } else if(salario > 3751 && salario <= 4664) {
        	System.out.println("A sua aliquota � de 22.5%");
            System.out.println("Voc� pode deduzir at� R$ 636");
        }
        
    }
}