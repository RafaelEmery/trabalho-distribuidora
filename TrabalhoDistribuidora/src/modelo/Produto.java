package modelo;

public abstract class Produto {
	private double valor;
	private int codigoDeBarra;
	
	//Metodos construtores
	public Produto() throws Exception {
		throw new Exception("Produto invalido");
	}
	public Produto(double valor, int codigoDeBarra) throws Exception {
		this.setValor(valor);
		this.setCodigoDeBarra(codigoDeBarra);
	}
	
	//Metodos set	
	public void setValor(double valor) {
		this.valor = valor;
	}
	public void setCodigoDeBarra(int codigoDeBarra) {
		this.codigoDeBarra = codigoDeBarra;
	}
	
	//Metodos get
	public double getValor() {
		return valor;
	}
	public int getCodigoDeBarra() {
		return codigoDeBarra;
	}
	
	//Metodo toString
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nValor");
		builder.append(this.getValor());
		builder.append(", Codigo de barra");
		builder.append(this.getCodigoDeBarra());	
		return builder.toString();
	}
}
