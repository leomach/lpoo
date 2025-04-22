package lpooIFPE;

import java.util.Scanner;

public class Q4L1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int quantidade = 0;
        int soma = 0;
        
        while (true) {
            System.out.println("Digite uma idade ou 0 para sair");
            int resposta = sc.nextInt();
            sc.nextLine();
            soma += resposta;
            if (resposta == 0) {
                System.out.println("Bye Bye, my lord");
                break;
            }
            ++quantidade;
        }

        double media = soma / quantidade;
        System.out.println("A média das " + quantidade + " pessoas é: " + media);

        sc.close();
    }
}
