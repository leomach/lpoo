package lpooIFPE;

import java.util.Scanner;

public class Q5L1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um numero:");
        int primeiroNumero = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite uma operação aritimética (/, *, +, -)");
        String op = sc.nextLine();
        System.out.println("Digite um numero:");
        int segundoNumero = sc.nextInt();
        sc.nextLine();
        
        if (op.equals("/")) {
            double resultado = primeiroNumero / segundoNumero;
            System.out.println("Resultado: " + resultado);
        } else if (op.equals("*")) {
            double resultado = primeiroNumero * segundoNumero;
            System.out.println("Resultado: " + resultado);
        } else if (op.equals("+")) {
            double resultado = primeiroNumero + segundoNumero;
            System.out.println("Resultado: " + resultado);
        } else if (op.equals("-")) {
            double resultado = primeiroNumero - segundoNumero;
            System.out.println("Resultado: " + resultado);
        } else {
            System.out.println("A operação é inválida.");
        }

        sc.close();
    }
}
