package entidades;

import transacao.EstadoConservacao;

public class Livro {
	private String titulo;
	private String autor;
	private String genero;
	private EstadoConservacao estado;
    
	public Livro(String titulo, String autor, String genero, EstadoConservacao estado) {
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.estado = estado;
	}
	
	//Livro pode consultar diretamente esse valor fixo
	public double calcularPrecoVenda() {
	    return this.estado.getValorBase();
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public EstadoConservacao getEstado() {
		return estado;
	}
	public void setEstado(EstadoConservacao estado) {
		this.estado = estado;
	}

	public String toString() {
		return titulo + ";" + autor + ";" + genero + ";" + estado;
	}
}

