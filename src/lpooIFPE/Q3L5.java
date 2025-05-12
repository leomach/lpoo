package lpooIFPE;
import java.util.Scanner;

class Circulo {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double obterArea() {
        return Math.PI * Math.pow(raio, 2);
    }

    public double obterPerimetro() {
        return 2 * Math.PI * raio;
    }
}

public class Q3L5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Circulo circulo = null;
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Círculo");
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
                    System.out.print("Digite o raio do círculo: ");
                    double raio = sc.nextDouble();
                    sc.nextLine();
                    circulo = new Circulo(raio);
                    continue;
                case 2:
                    if (circulo != null) {
                        System.out.println("Área: " + circulo.obterArea());
                    } else {
                        System.out.println("Círculo não cadastrado.");
                    }
                    continue;
                case 3:
                    if (circulo != null) {
                        System.out.println("Perímetro: " + circulo.obterPerimetro());
                    } else {
                        System.out.println("Círculo não cadastrado.");
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
