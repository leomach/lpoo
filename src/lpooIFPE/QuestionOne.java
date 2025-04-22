package lpooIFPE;

import java.util.Scanner;

public class QuestionOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite seu ano de nascimento (No formato: AAAA)");
        int year_of_birth = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite seu ano atual (No formato: AAAA)");
        int year_now = sc.nextInt();
        sc.nextLine();
        int diference = year_now - year_of_birth;
        System.out.println("Sua idade é " + diference);
        sc.close();
    }
}
