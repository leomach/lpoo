package lpooIFPE;

import java.util.Scanner;

public class Q1L2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantidade;

        System.out.println("Digite a quantidade de números: ");
        quantidade = sc.nextInt();
        sc.nextLine();

        int nums[] = new int[quantidade];
        
        for (int i=0; i<quantidade; i++) {
            System.out.println("Digite um número: ");
            int num = sc.nextInt();
            sc.nextLine();
            nums[i] = num;
        }

        int sum = 0;
        for (int element : nums) {
            sum += element;
        }
        
        System.out.println(sum);


        sc.close();
    }
}
