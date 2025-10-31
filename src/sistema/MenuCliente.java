package sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuCliente {
	// Lista simulada de livros disponíveis (sem depender de GerenciamentoLivros)
    private List<String> livrosDisponiveis = new ArrayList<>();
    
    // Construtor para popular alguns livros fictícios
    public MenuCliente() {
        livrosDisponiveis.add("O Pequeno Príncipe");
        livrosDisponiveis.add("Dom Casmurro");
        livrosDisponiveis.add("Harry Potter e a Pedra Filosofal");
        livrosDisponiveis.add("A Culpa é das Estrelas");
    }
    
	public void menuCliente(Scanner input) {
        int opcao;
        do {
            System.out.println("\n======꒰ ୨🕮୧ MENU CLIENTE ꒱======");
            System.out.println(".✦ [1] Consultar livros");
            System.out.println(".✦ [2] Comprar livro");
            System.out.println(".✦ [3] Vender livro");
            System.out.println("➤ [0] Voltar");

            opcao = TratarErros.LerOpcaoInteira(input, ".✦ Sua opção: ");

            switch (opcao) {
                case 1:
                	listarLivros();
                    break;
                case 2:
                	comprarLivro(input);
                    break;
                case 3:
                	venderLivro(input);
                    break;
                case 0:
                    System.out.println(".✦ Voltando ao menu inicial...");
                    break;
                default:
                    System.out.println("✗ Opção inválida!");
            }
        } while (opcao != 0);
    }
	
	// Método para listar livros
    private void listarLivros() {
        System.out.println("\n📚 Livros disponíveis para compra:");
        for (int i = 0; i < livrosDisponiveis.size(); i++) {
            System.out.println("[" + i + "] " + livrosDisponiveis.get(i));
        }
    }
    
    // Método para comprar livro
    private void comprarLivro(Scanner input) {
        listarLivros();
        int indice = TratarErros.LerOpcaoInteira(input, ".✦ Informe o índice do livro que deseja comprar: ");
        if (indice >= 0 && indice < livrosDisponiveis.size()) {
            String livroComprado = livrosDisponiveis.get(indice);
            System.out.println("✔ Você comprou o livro: " + livroComprado);
        } else {
            System.out.println("❌ Índice inválido!");
        }
    }
    
    // Método para vender livro
    private void venderLivro(Scanner input) {
        System.out.print(".✦ Informe o título do livro que deseja vender: ");
        String titulo = input.nextLine();
        livrosDisponiveis.add(titulo);
        System.out.println("✔ Livro \"" + titulo + "\" adicionado à lista de disponíveis!");
    }
   
}



