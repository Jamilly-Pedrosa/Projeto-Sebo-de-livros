package transacao;

import java.text.SimpleDateFormat;
import java.util.Date;

import entidades.Livro;

public class Transacao {
	private String nomeCliente; 
	private String tituloLivro; 
	private Date date; 
	private double valor; 
	
	/*public Transacao(String nomeCliente, String tituloLivro, Date date, double valor) { 
		super(); 
		this.nomeCliente = nomeCliente; 
		this.tituloLivro = tituloLivro; 
		this.date = date; 
		this.valor = valor; 
	} */
	
	public Transacao(String nomeCliente, Livro livro, Date date) {
	        this.nomeCliente = nomeCliente;
	        this.tituloLivro = livro.getTitulo();
	        this.date = date;
	        this.valor = livro.calcularPrecoVenda(); // pega valor fixo do estado
	}
	
	public String getNomeCliente() { 
		return nomeCliente; 
	}
	
	public void setNomeCliente(String nomeCliente) { 
		this.nomeCliente = nomeCliente; 
	} 
	
	public String getTituloLivro() { 
		return tituloLivro; 	
	} 
	
	public void setTituloLivro(String tituloLivro) { 
		this.tituloLivro = tituloLivro; 
	} 
	
	public Date getDate() { 
		return date; 
	} 
	
	public void setDate(Date date) {
		this.date = date; 
	} 
	
	public double getValor() { 
		return valor; 
	} 
	public void setValor(double valor) { 
		this.valor = valor; 
	} 
	
	@Override public String toString() { 
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return nomeCliente + ";" + tituloLivro + ";" + sdf.format(date) + ";" + valor; 
		}
	
}