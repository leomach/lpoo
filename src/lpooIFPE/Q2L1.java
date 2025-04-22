package lpooIFPE;

import java.util.Scanner;

public class Q2L1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a quantidade de pessoas:");
        int quantidade = sc.nextInt();
        sc.nextLine();
        double soma = 0;

        for (int i=1; i <= quantidade; i++){
            System.out.println("Digite a altura da pessoa " + i + ":");
            double altura = sc.nextDouble();
            sc.nextLine();
            soma += altura;
        }
        
        double media = soma / quantidade;
        System.out.println("A altura média das " + quantidade + " pessoas é: " + media);
        sc.close();
    }
}
