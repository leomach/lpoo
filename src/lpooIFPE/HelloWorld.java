package lpooIFPE;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(("Digite seu nome:"));
		String nome = sc.nextLine();
		System.out.println("Seu nome é: " + nome);
		
		for(int i=0;i<4;i++) {
			System.out.println(i + 1);
		};
		
		if(nome.equals("leo")) {
			System.out.println("Esse é um apelido");
		} else {
			System.out.println("É uma outra coisa");
		};
		
		while(true) {
			System.out.println("Entrou no while");
			break;
		};
		
		sc.close();

	}

}
