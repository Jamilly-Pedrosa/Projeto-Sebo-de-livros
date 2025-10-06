package entidades;

public class Cliente extends Usuario{

	public Cliente(String nome, String email, String cpf) {
		super(nome, email, cpf);
	}
	
	@Override //Método toString() sobrescrito para facilitar a gravação dos dados
	public String toString() {
		return getNome() + ";" + getEmail() + ";" + getCpf();
	}
}
