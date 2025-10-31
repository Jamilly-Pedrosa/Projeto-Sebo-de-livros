package gerenciamento;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entidades.Cliente;
import entidades.Livro;
import sistema.TratarErros;
import transacao.Transacao;

public class GerenciamentoTransacao implements Crud<Transacao>{
	
	 private List<Transacao> transacoes = new ArrayList<>();
	 private GerenciamentoCliente gerenciamentoClientes;
	 private GerenciamentoLivros gerenciamentoLivros;
	 
	// 🔧 Construtor que inicializa os objetos
	 public GerenciamentoTransacao() {
		 this.gerenciamentoClientes = new GerenciamentoCliente();
	     this.gerenciamentoLivros = new GerenciamentoLivros();
	 }
	 

	@Override
	public void cadastrar(Scanner input) {
		System.out.println("\n・•┈๑⋅⋯┆✦ʚ CADASTRAR TRANSAÇÃO ɞ✦┆•┈๑⋅⋯・");

        // Listar clientes e livros disponíveis
        gerenciamentoClientes.listar();
        String indiceCliente = TratarErros.LerOpcaoString(input, ".✦ Informe o índice do cliente: ");

        gerenciamentoLivros.listar();
        String indiceLivro = TratarErros.LerOpcaoString(input, ".✦ Informe o índice do livro: ");

        try {
            int idCliente = Integer.parseInt(indiceCliente);
            int idLivro = Integer.parseInt(indiceLivro);

            Cliente cliente = gerenciamentoClientes.getClientes().get(idCliente);
            Livro livro = gerenciamentoLivros.getLivro(idLivro);
            
            if (cliente == null || livro == null) {
                System.out.println("❌ Cliente ou livro inválido!");
                return;
            }

            // Criar a nova transação
            Date dataAtual = new Date();
            Transacao novaTransacao = new Transacao(cliente.getNome(), livro, dataAtual);

            transacoes.add(novaTransacao);
            System.out.println("✔ Transação cadastrada com sucesso!");
            System.out.println("📘 Livro: " + livro.getTitulo() + " | 💰 Valor: R$" + livro.calcularPrecoVenda());

        } catch (NumberFormatException e) {
            System.out.println("❌ O índice deve ser um número!");
        }
		
	}

	@Override
	public void listar() {
		System.out.println("\n・•┈๑⋅⋯┆✦ʚ HISTÓRICO DE TRANSAÇÕES ɞ✦┆•┈๑⋅⋯・");
		
		if (transacoes.isEmpty()) {
			System.out.println("✗ Nenhuma transação registrada.");
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	            for (int i = 0; i < transacoes.size(); i++) {
	            	Transacao t = transacoes.get(i);
	                System.out.println("[" + i + "] Cliente: " + t.getNomeCliente() +
	                        " | Livro: " + t.getTituloLivro() +
	                        " | Data: " + sdf.format(t.getDate()) +
	                        " | Valor: R$" + t.getValor());
	            
	        }
	    }
		
	}

	@Override
	public void editar(String id) {
		 System.out.println("✗ Edição de transações não é permitida.");
    }
		

	@Override
	public void remover(String id) {
		System.out.println("✗ Remoção de transações não é permitida.");
    }

    // Getter para lista de transações caso precise em outro menu
    public List<Transacao> getTransacoes() {
        return transacoes;
		
	}

}
