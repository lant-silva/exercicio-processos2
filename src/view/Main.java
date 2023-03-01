//Exercicio 2
package view;

import controller.KillController;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		KillController controle = new KillController();
		String sistema="";
		Scanner input = new Scanner(System.in);
		int escolha=0;
		
		//Escolhi fazer um switch case para que a 
		//execução dos métodos ficassem mais organizadas, 
		//e que todas as classes pudessem ser observadas
		//ao mesmo tempo na hora de executar.
		
		String menu = "Escolha um método para ser executado\n1- Nome do sistema\n2- Lista de Processos\n3- Matar um processo(pid)\n4- Matar um processo(nome)\n9- Sair";
		System.out.println(menu);
		while(escolha!=9) {
			escolha = input.nextInt();
			switch(escolha) {
				case 1: sistema = controle.os();
					System.out.println(sistema);
					System.out.println(menu);
					break;
				case 2: controle.listaProcessos();
					System.out.println(menu);
					break;
				case 3:	System.out.println("Escolha um processo para ser finalizado(pid)");
					String pid = input.next();
					controle.mataPid(pid);
					System.out.println(menu);
					break;
				case 4: System.out.println("Escolha um processo para ser finalizado(nome)");
					String nome = input.next();
					controle.mataNome(nome);
					System.out.println(menu);
					break;
				case 9: System.out.println("Programa finalizado.");
					break;
			}
		}	
	}
}
