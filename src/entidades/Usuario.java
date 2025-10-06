package entidades;
//Classe abstrata usada como base não pode ser instanciada diretamente
public abstract class Usuario {
	private String nome;
	private String email;
	private String cpf;
	
	//construtor
	public Usuario(String nome, String email, String cpf){
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	

}
