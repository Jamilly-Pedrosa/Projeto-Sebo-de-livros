package gerenciamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Livro;
import sistema.TratarErros;
import transacao.EstadoConservacao;

public class GerenciamentoLivros implements Crud<Livro> {
	
	private List<Livro> livros = new ArrayList<>();
	
	@Override
	public void cadastrar(Scanner input) {
        System.out.println("\n・•┈๑⋅⋯┆✦ʚ CADASTRO DE LIVRO ɞ✦┆•┈๑⋅⋯・");
        String titulo = TratarErros.LerOpcaoString(input, ".✦ Título: ");
        String autor = TratarErros.LerOpcaoString(input, ".✦ Autor: ");
        String genero = TratarErros.LerOpcaoString(input, ".✦ Genêro: ");
        String estado = TratarErros.LerOpcaoString(input, ".✦ Estado de conservação (NOVO, BOM, REGULAR, RUIM): ").toUpperCase();

        Livro novoLivro = new Livro(titulo, autor, genero, EstadoConservacao.valueOf(estado));
        livros.add(novoLivro);

        System.out.println("✔ Livro cadastrado com sucesso!");
		
	}

	@Override
	public void listar() {
        System.out.println("\n・•┈๑⋅⋯┆✦ʚ LISTA DE LIVROS ɞ✦┆•┈๑⋅⋯・\"");
        if (livros.isEmpty()) {
            System.out.println("✗ Nenhum livro cadastrado.");
        } else {
        	for (int i = 0; i < livros.size(); i++) {
                System.out.println("[" + i + "] " + livros.get(i));
            }
        }
    }
		

	@Override
	public void editar(String id) {
		try {
            int indice = Integer.parseInt(id);
            Livro livro = buscarLivroPorIndice(indice);

            if (livro == null) {
                System.out.println("❌ Livro não encontrado.");
                return;
            }
		 
	        
	        Scanner input = new Scanner(System.in);
	        System.out.println("\n・•┈๑⋅⋯┆✦ʚ EDITAR LIVRO ɞ✦┆•┈๑⋅⋯・");
	        
	        String novoTitulo = TratarErros.LerOpcaoString(input, ".✦ Novo título: ");
	        String novoAutor =  TratarErros.LerOpcaoString(input, ".✦ Novo autor: ");
	        String novoGenero = TratarErros.LerOpcaoString(input, ".✦ Novo genêro: ");
	        String novoEstado = TratarErros.LerOpcaoString(input, ".✦ Novo estado (NOVO, BOM, REGULAR, RUIM:) ").toUpperCase();
	        
	        Livro novoLivro = new Livro(novoTitulo, novoAutor, novoGenero, EstadoConservacao.valueOf(novoEstado));
	        livros.add(novoLivro);
	  

	        System.out.println("✔ Livro atualizado com sucesso!");
		 } catch (NumberFormatException e) {
	            System.out.println("❌ O índice deve ser um número!");
	        }
	}
	
	@Override
	public void remover(String id) {
		try {
            int indice = Integer.parseInt(id);
            Livro livro = buscarLivroPorIndice(indice);

            if (livro != null) {
                livros.remove(indice);
                System.out.println("✔ Livro removido com sucesso!");
            } else {
                System.out.println("❌ Livro não encontrado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ O índice deve ser um número!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("❌ Índice inválido!");
        }
    }

    // Método auxiliar: busca o livro pelo índice na lista
    private Livro buscarLivroPorIndice(int indice) {
        if (indice >= 0 && indice < livros.size()) {
            return livros.get(indice);
        }
        return null;
    }
    
    public List<Livro> getLivros() {
        return livros;
    }
    
    public Livro getLivro(int indice) {
        if (indice >= 0 && indice < livros.size()) {
            return livros.get(indice);
        } else {
            return null; // ou lançar uma exceção se preferir
        }
    }

}
