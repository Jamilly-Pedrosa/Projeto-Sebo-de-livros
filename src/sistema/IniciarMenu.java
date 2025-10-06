package sistema;

import java.util.Scanner;

public class IniciarMenu {

	public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
		 
		 MenuInicial sebolivros = new MenuInicial();
	     sebolivros.menuInicial(input);

	     input.close(); // fecha o scanner no final da aplicação
		
	}
}
