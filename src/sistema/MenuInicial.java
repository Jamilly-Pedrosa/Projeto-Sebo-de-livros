package sistema;

import java.util.Scanner;

public class MenuInicial {
	public void menuInicial(Scanner input) {
        int opcao;
        do {
            System.out.println("\n======꒰ ୨🕮୧ SEBO DE LIVROS ꒱======");
            System.out.println(".✦ [1] Menu Administrador");
            System.out.println(".✦ [2] Menu Cliente");
            System.out.println(".✦ [0] Sair");

            opcao = TratarErros.LerOpcaoInteira(input, ".✦ Sua opção: ");

            switch (opcao) {
                case 1:
                    new MenuAdm().menuAdm(input);
                    break;
                case 2:
                    new MenuCliente().menuCliente(input);
                    break;
                case 0:
                    System.out.println(".✦ Você saiu do programa. Volte sempre!");
                    break;
                default:
                    System.out.println("✗ Opção inválida!");
            }
        } while (opcao != 0);
    }
	
}
