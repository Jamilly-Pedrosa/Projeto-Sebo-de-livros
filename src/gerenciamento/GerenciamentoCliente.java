package gerenciamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Cliente;
import sistema.TratarErros;

public class GerenciamentoCliente implements Crud<Cliente>{
	
	private List<Cliente> clientes = new ArrayList<>();

	@Override
	public void cadastrar(Scanner input) {
		 System.out.println("\n・•┈๑⋅⋯┆✦ʚ CADASTRO DE CLIENTE ɞ✦┆•┈๑⋅⋯・");
	        String nome = TratarErros.LerOpcaoString(input, ".✦ Nome: ");
	        String email = TratarErros.LerOpcaoString(input, ".✦ Email: ");
	        String cpf = TratarErros.LerOpcaoString(input, ".✦ CPF: ");

	        Cliente novoCliente = new Cliente(nome, email, cpf);
	        clientes.add(novoCliente);

	        System.out.println("✔ Cliente cadastrado com sucesso!");
	}

	@Override
	public void listar() {
		System.out.println("\n・•┈๑⋅⋯┆✦ʚ LISTA DE CLIENTES ɞ✦┆•┈๑⋅⋯・");
        if (clientes.isEmpty()) {
            System.out.println("✗ Nenhum cliente cadastrado.");
        } else {
            for (int i = 0; i < clientes.size(); i++) {
                System.out.println("[" + i + "] " + clientes.get(i));
            }
        }
		
	}

	@Override
	public void editar(String id) {
		 try {
	            int indice = Integer.parseInt(id);
	            Cliente cliente = buscarClientePorIndice(indice);

	            if (cliente == null) {
	                System.out.println("❌ Cliente não encontrado.");
	                return;
	            }

	            Scanner input = new Scanner(System.in);
	            System.out.println("\n・•┈๑⋅⋯┆✦ʚ EDITAR CLIENTE ɞ✦┆•┈๑⋅⋯・");

	            String novoNome = TratarErros.LerOpcaoString(input, ".✦ Novo nome: ");
	            String novoEmail = TratarErros.LerOpcaoString(input, ".✦ Novo email: ");
	            String novoCpf = TratarErros.LerOpcaoString(input, ".✦ Novo CPF: ");

	            Cliente novoCliente = new Cliente(novoNome, novoEmail, novoCpf);
		        clientes.add(novoCliente);
		        
	            System.out.println("✔ Cliente atualizado com sucesso!");
	        } catch (NumberFormatException e) {
	            System.out.println("❌ O índice deve ser um número!");
	        }
		
	}

	@Override
	public void remover(String id) {
		try {
            int indice = Integer.parseInt(id);
            Cliente cliente = buscarClientePorIndice(indice);

            if (cliente != null) {
                clientes.remove(indice);
                System.out.println("✔ Cliente removido com sucesso!");
            } else {
                System.out.println("❌ Cliente não encontrado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ O índice deve ser um número!");
        }
    }

    // Método auxiliar para buscar cliente pelo índice
    private Cliente buscarClientePorIndice(int indice) {
        if (indice >= 0 && indice < clientes.size()) {
            return clientes.get(indice);
        }
        return null;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
		

}
