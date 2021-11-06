public class TesteIR {

    public static void main(String[] args) {

        double salario = 3300.0;

        
        if (salario >= 1900   && salario <= 2800) {
        	System.out.println("A sua aliquota é de 7%");
            System.out.println("Você pode deduzir até R$ 142");
        } else if(salario > 2800 && salario <= 3751){
        	System.out.println("A sua aliquota é de 15%");
            System.out.println("Você pode deduzir até R$ 350");
        } else if(salario > 3751 && salario <= 4664) {
        	System.out.println("A sua aliquota é de 22.5%");
            System.out.println("Você pode deduzir até R$ 636");
        }
        
    }
}