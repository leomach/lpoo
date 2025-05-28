package lpooIFPE;
import java.util.Scanner;

class Banco {
    private String numeroAgencia;
    private String nomeAgencia;

    public Banco(String numeroAgencia, String nomeAgencia) {
        this.numeroAgencia = numeroAgencia;
        this.nomeAgencia = nomeAgencia;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public String getNomeAgencia() {
        return nomeAgencia;
    }

    public void setNomeAgencia(String nomeAgencia) {
        this.nomeAgencia = nomeAgencia;
    }
}

class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}

class Conta {
    protected String numeroConta;
    protected Banco banco;
    protected Cliente cliente;
    protected double saldo;

    public Conta(String numeroConta, Banco banco, Cliente cliente) {
        this.numeroConta = numeroConta;
        this.banco = banco;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public String getCpf() {
        return cliente.getCpf();
    }

    public String getNomeCliente() {
        return cliente.getNome();
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void exibirAgencia() {
        System.out.println("Agência: " + banco.getNumeroAgencia() + " - " + banco.getNomeAgencia());
        System.out.println("Cliente: " + cliente.getNome() + " - CPF: " + cliente.getCpf());
    }

    public void alterarAgencia(String novoNumero, String novoNome) {
        banco.setNumeroAgencia(novoNumero);
        banco.setNomeAgencia(novoNome);
    }

    public boolean isPoupanca() {
        return false;
    }
}

class Poupanca extends Conta {
    private double juros;

    public Poupanca(String numeroConta, Banco banco, Cliente cliente, double juros) {
        super(numeroConta, banco, cliente);
        this.juros = juros;
    }

    public void renderJuros() {
        saldo += saldo * (juros / 100);
        System.out.println("Juros aplicados com sucesso. Novo saldo: " + saldo);
    }

    @Override
    public boolean isPoupanca() {
        return true;
    }
}

public class SistemaBanco {
    private static Conta[] contas = new Conta[10];
    private static int totalContas = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = scanner.nextInt();
        scanner.nextLine();
        while (opcao != 0) {
            System.out.println("\n---- Menu Banco ----");
            System.out.println("1. Cadastrar Conta ou Poupança");
            System.out.println("2. Realizar Depósito");
            System.out.println("3. Render Juros");
            System.out.println("4. Consultar Número e Nome da Agência");
            System.out.println("5. Alterar o Número e Nome da Agência");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarConta();
                    continue;
                case 2:
                    realizarDeposito();
                    continue;
                case 3:
                    aplicarJuros();
                    continue;
                case 4:
                    consultarAgencia();
                    continue;
                case 5:
                    alterarAgencia();
                    continue;
                case 0:
                    System.out.println("Encerrando o sistema.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    continue;
            }
        };
    }

    private static void cadastrarConta() {
        if (totalContas >= 10) {
            System.out.println("Limite de contas atingido.");
            return;
        }

        System.out.print("Tipo de conta (1 - Conta Corrente, 2 - Poupança): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Número da Conta: ");
        String numeroConta = scanner.nextLine();

        System.out.print("Número da Agência: ");
        String numeroAgencia = scanner.nextLine();

        System.out.print("Nome da Agência: ");
        String nomeAgencia = scanner.nextLine();

        System.out.print("Nome do Cliente: ");
        String nomeCliente = scanner.nextLine();

        System.out.print("CPF do Cliente: ");
        String cpf = scanner.nextLine();

        Banco banco = new Banco(numeroAgencia, nomeAgencia);
        Cliente cliente = new Cliente(nomeCliente, cpf);

        if (tipo == 2) {
            System.out.print("Taxa de juros (%): ");
            double juros = scanner.nextDouble();
            scanner.nextLine();
            contas[totalContas] = new Poupanca(numeroConta, banco, cliente, juros);
        } else {
            contas[totalContas] = new Conta(numeroConta, banco, cliente);
        }

        totalContas++;
        System.out.println("Conta cadastrada com sucesso!");
    }

    private static void realizarDeposito() {
        System.out.print("Informe o CPF do cliente: ");
        String cpf = scanner.nextLine();
        Conta conta = null;
        for (int i = 0; i < totalContas; i++) {
            if (contas[i].getCpf().equals(cpf)) {
                conta = contas[i];
            }
        }
        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        System.out.print("Valor do depósito: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        conta.depositar(valor);
        System.out.println("Depósito realizado com sucesso.");
    }

    private static void aplicarJuros() {
        System.out.print("Informe o CPF do cliente: ");
        String cpf = scanner.nextLine();
        Conta conta = null;
        for (int i = 0; i < totalContas; i++) {
            if (contas[i].getCpf().equals(cpf)) {
                conta = contas[i];
            }
        }
        if (conta == null || !conta.isPoupanca()) {
            System.out.println("Poupança não encontrada para o CPF informado.");
            return;
        }

        if (conta instanceof Poupanca){
            Poupanca p = (Poupanca) conta;
            p.renderJuros();
        }
    }

    private static void consultarAgencia() {
        for (int i = 0; i < totalContas; i++) {
            contas[i].exibirAgencia();
        }
    }

    private static void alterarAgencia() {
        System.out.print("Informe o nome do cliente: ");
        String nome = scanner.nextLine();
        for (int i = 0; i < totalContas; i++) {
            if (contas[i].getNomeCliente().equalsIgnoreCase(nome)) {
                System.out.print("Novo número da agência: ");
                String novoNumero = scanner.nextLine();
                System.out.print("Novo nome da agência: ");
                String novoNome = scanner.nextLine();
                contas[i].alterarAgencia(novoNumero, novoNome);
                System.out.println("Agência alterada com sucesso.");
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }
}
