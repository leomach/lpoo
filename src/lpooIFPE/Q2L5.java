package lpooIFPE;

import java.util.Scanner;

class Retangulo {
    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double obterArea() {
        return base * altura;
    }

    public double obterPerimetro() {
        return 2 * (base + altura);
    }
}

public class Q2L5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Retangulo retangulo = null;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Retângulo");
            System.out.println("2. Calcular Área");
            System.out.println("3. Calcular Perímetro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 0) {
                break;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite a base do retângulo: ");
                    double base = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Digite a altura do retângulo: ");
                    double altura = sc.nextDouble();
                    sc.nextLine();
                    retangulo = new Retangulo(base, altura);
                    continue;
                case 2:
                    if (retangulo != null) {
                        System.out.println("Área: " + retangulo.obterArea());
                    } else {
                        System.out.println("Retângulo não cadastrado.");
                    }
                    continue;
                case 3:
                    if (retangulo != null) {
                        System.out.println("Perímetro: " + retangulo.obterPerimetro());
                    } else {
                        System.out.println("Retângulo não cadastrado.");
                    }
                    continue;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        sc.close();
        System.out.println("Programa encerrado.");
    }
}
