package gerenciamento;

import java.util.Scanner;

public interface Crud<T> {
	void cadastrar(Scanner input);
	void listar();
	void editar(String id);
	void remover(String id);

}
