package transacao;
//enum já guarda o valor fixo de cada estado.
public enum EstadoConservacao {
	 NOVO(50.0),      // Valor fixo para livros novos
	 BOM(30.0),       // Valor fixo para livros em bom estado
	 REGULAR(15.0),   // Valor fixo para livros regulares
	 RUIM(5.0);       // Valor fixo para livros ruins
	
	private final double valorBase;

    EstadoConservacao(double valorBase) {
        this.valorBase = valorBase;
    }

    public double getValorBase() {
        return valorBase;
    }

}