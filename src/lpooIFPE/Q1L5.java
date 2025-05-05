package lpooIFPE;

import java.util.Scanner;

class Estudante {
    private String nome;
    private String matricula;
    private String endereco;
    private double[] notas = new double[4];

    public Estudante(String nome, String matricula, String endereco) {
        this.nome = nome;
        this.matricula = matricula;
        this.endereco = endereco;
    }
    
    public void getMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        double media = soma / notas.length;
        System.out.println("Média: " + media);

        if (media >= 7) {
            System.out.println("Aprovado");
        } else if (media >= 5) {
            System.out.println("Recuperação");
        } else {
            System.out.println("Reprovado");
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public String getEndereco(){
        return endereco;
    }

    public String getNome() {
        return nome;
    }
}

public class Q1L5 {
    
    public static void main(String[] args) {
        Estudante estudante = null;
            
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Estudante");
            System.out.println("2. Calcular Média");
            System.out.println("3. Obter número de matrícula");
            System.out.println("4. Obter endereço");
            System.out.println("5. Obter nome");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            Scanner sc = new Scanner(System.in);
            int opcao = sc.nextInt();
            sc.nextLine();
            if (opcao == 0) {
                break;
            }
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do estudante: ");
                    String nome = sc.nextLine();
                    System.out.print("Digite a matrícula do estudante: ");
                    String matricula = sc.nextLine();
                    System.out.print("Digite o endereço do estudante: ");
                    String endereco = sc.nextLine();
                    estudante = new Estudante(nome, matricula, endereco);
                    continue;
                case 2:
                    estudante.getMedia();
                    continue;
                case 3:
                    System.out.println("Matrícula: " + estudante.getMatricula());
                    continue;
                case 4:
                    System.out.println("Endereço: " + estudante.getEndereco());
                    continue;
                case 5:
                    System.out.println("Nome: " + estudante.getNome());
                    continue;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println();
            sc.close();
        }
    }
}
