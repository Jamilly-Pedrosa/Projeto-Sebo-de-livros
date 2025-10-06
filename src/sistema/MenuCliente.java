package sistema;

import java.util.Scanner;

public class MenuCliente {
	public void menuCliente(Scanner input) {
        int opcao;
        do {
            System.out.println("\n======꒰ 🎬 MENU Cliente ꒱======");
            System.out.println(".✦ [1] Consultar livros");
            System.out.println(".✦ [2] Comprar livro");
            System.out.println(".✦ [3] Vender livro");
            System.out.println("➤ [0] Voltar");

            opcao = TratarErros.LerOpcaoInteira(input, ".✦ Sua opção: ");

            switch (opcao) {
                case 1:
                    // chamar método para listar livros
                    break;
                case 2:
                    // chamar método para comprar livro
                    break;
                case 3:
                    // chamar método para vender livro
                    break;
                case 0:
                    System.out.println(".✦ Voltando ao menu inicial...");
                    break;
                default:
                    System.out.println("✗ Opção inválida!");
            }
        } while (opcao != 0);
    }

}
