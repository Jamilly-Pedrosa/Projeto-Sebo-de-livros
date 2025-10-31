package sistema;

import java.util.Scanner;

import gerenciamento.GerenciamentoCliente;
import gerenciamento.GerenciamentoLivros;
import gerenciamento.GerenciamentoTransacao;

public class MenuAdm {
	public void menuAdm(Scanner input) {;
        int opcao;
        do {
            System.out.println("\n======꒰ ୨🕮୧ MENU ADMINISTRADOR ꒱======");
            System.out.println(".✦ [1] Gerenciamento de Livros");
            System.out.println(".✦ [2] Gerenciamento de Clientes");
            System.out.println(".✦ [3] Gerenciamento de Transações");
            System.out.println("➤ [0] Voltar");

            opcao = TratarErros.LerOpcaoInteira(input, ".✦ Sua opção: ");
            
            switch (opcao) {
			case 1:
				gerenciamentoLivros(input);
				break;
			case 2: 
				gerenciamentoClientes(input); 
				break;
			case 3: 
				gerenciamentoTransacao(input); 
				break;
			case 0: 
				System.out.println(".✦ Voltando ao menu principal...");
				break;
			default:
				System.out.println("✗ Opção invalida! ");
			}

        } while (opcao != 0);
    }
	
	public void gerenciamentoLivros(Scanner input) {
		int opcao;
		GerenciamentoLivros livroCrud = new GerenciamentoLivros(); //Instância da classe para chamar os métodos do crud
		 
		do{
			System.out.println("\n======꒰ ୨🕮୧ GERENCIAR LIVROS ꒱======");
			System.out.println(".✦ [1] Cadastrar ");
			System.out.println(".✦ [2] Listar ");
			System.out.println(".✦ [3] Editar ");
			System.out.println(".✦ [4] Remover ");
			System.out.println("➤ [0] Voltar ao menu principal ");
			
			// Usa a função da classe TratarErros para ler a opção do usuário com segurança
			opcao = TratarErros.LerOpcaoInteira(input, ".✦ Sua opção: ");
			
			switch (opcao) {
			case 1:
				livroCrud.cadastrar(input);
				break;
			case 2: 
				livroCrud.listar();
				break;
			case 3: 
				livroCrud.listar(); // Mostrar os livros numerados
				livroCrud.editar(TratarErros.LerOpcaoString(input, "✎ Digite o número do livro a editar:"));
				break;
			case 4: 
				livroCrud.listar();
				livroCrud.remover(TratarErros.LerOpcaoString(input, "✎ Digite o número do livro a remover:")); 
				break;
			case 0: 
				System.out.println(".✦ Voltando ao menu principal...");
				break;
			default:
				System.out.println("✗ Opção invalida! ");
			}
			
		}while(opcao != 0);
		
	}
		
	public void gerenciamentoClientes(Scanner input) {
		int opcao;
		GerenciamentoCliente clienteCrud = new GerenciamentoCliente();
		do{
			System.out.println("\n======꒰ ୨🕮୧ GERENCIAR CLIENTES ꒱======");
			System.out.println(".✦ [1] Cadastrar ");
			System.out.println(".✦ [2] Listar ");
			System.out.println(".✦ [3] Editar ");
			System.out.println(".✦ [4] Remover ");
			System.out.println("➤ [0] Voltar ao menu principal ");
			
			// Usa a função da classe TratarErros para ler a opção do usuário com segurança
			opcao = TratarErros.LerOpcaoInteira(input, ".✦ Sua opção: ");
			
			switch (opcao) {
			case 1:
				clienteCrud.cadastrar(input);
				break;
			case 2: 
				clienteCrud.listar();
				break;
			case 3: 
				clienteCrud.listar(); // Mostrar os livros numerados
				clienteCrud.editar(TratarErros.LerOpcaoString(input, "✎ Digite o número do cliente a editar:"));
				break;
			case 4: 
				clienteCrud.listar();
				clienteCrud.remover(TratarErros.LerOpcaoString(input, "✎ Digite o número do cliente a remover:")); 
				break;
			case 0: 
				System.out.println(".✦ Voltando ao menu principal...");
				break;
			default:
				System.out.println("✗ Opção invalida! ");
			}
			
		}while(opcao != 0);	
	}

	public void gerenciamentoTransacao(Scanner input) {
		int opcao;
		GerenciamentoTransacao transacaoCrud = new GerenciamentoTransacao();
		do{
			System.out.println("\n======꒰ ୨🕮୧ GERENCIAR TRANSAÇÃO ꒱======");
			System.out.println(".✦ [1] Cadastrar ");
			System.out.println(".✦ [2] Listar ");
			System.out.println("➤ [0] Voltar ao menu principal ");
			
			// Usa a função da classe TratarErros para ler a opção do usuário com segurança
			opcao = TratarErros.LerOpcaoInteira(input, ".✦ Sua opção: ");
			
			switch (opcao) {
			case 1:
				transacaoCrud.cadastrar(input);
				break;
			case 2: 
				transacaoCrud.listar();
				break;
			case 0: 
				System.out.println(".✦ Voltando ao menu principal...");
				break;
			default:
				System.out.println("✗ Opção invalida! ");
			}
			
		}while(opcao != 0);	
	}

}
