package lpooIFPE;

import java.util.Scanner;

public class Q6L1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantidade;
        double peso, altura, imc;
        
        System.out.println("Calculadora de IMC!");
        System.out.println("");
        
        System.out.println("Digite a quantidade de pessoas a fazerem o IMC:");
        quantidade = sc.nextInt();
        sc.nextLine();

        double imcs[] = new double[quantidade];

        for (int i=0; i < quantidade; i++){
            System.out.println("Digite o seu peso:");
            peso = sc.nextDouble();
            sc.nextLine();
    
            System.out.println("Digite a sua altura:");
            altura = sc.nextDouble();
            sc.nextLine();
    
            imc = peso / (altura * altura);
            System.out.println("Seu IMC é: " + imc);

            imcs[i] = imc;
        }
        
        int quant_abaixo = 0;
        int quant_dentro = 0;
        int quant_acima = 0;
        
        for (double d : imcs) {
            if (d < 18.5) {
                ++quant_abaixo;
            } else if (18.5 < d && d < 25) {
                ++quant_dentro;
            } else if (d >= 25) {
                ++quant_acima;
            }
        }

        System.out.println("Pessoas abaixo do peso: " + quant_abaixo);
        System.out.println("Pessoas dentro do peso: " + quant_dentro);
        System.out.println("Pessoas acima do peso: " + quant_acima);

        sc.close();
    }
}