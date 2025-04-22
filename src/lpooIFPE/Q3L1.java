package lpooIFPE;

import java.util.Scanner;

public class Q3L1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um número máximo");
        int quantidade = sc.nextInt();
        sc.nextLine();

        for (int i=0; i <= quantidade; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " é par");
            }
        }

        sc.close();
    }
}
