package modelo;

public abstract class Transacao {
	private int quantidade;
	private double valorUnitario;
	private Produto produto;
	
	//Metodos construtores
	public Transacao() throws Exception {
		throw new Exception("Transacao invalida");
	}
	
	public Transacao(int quantidade, double valorUnitario, String produto) throws Exception {
		this.setQuantidade(quantidade);
		this.setValor(valorUnitario);
		this.setProduto(produto);
	}
	
	//Metodos set
	public void setQuantidade(int quantidade) throws Exception {
		if (quantidade > 0) {
			this.quantidade = quantidade;
		}
		else {
			throw new Exception("Quantidade invalida");
		}
	}
	
	public void setValor(double valorUnitario) throws Exception {
		if (valorUnitario > 0) {
			this.valorUnitario = valorUnitario;
		}
		else {
			throw new Exception("Valor unitario invalido");
		}
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public void setProduto(String produto) throws Exception {
		if (produto.isEmpty() == false) {
//			if()
//			this.produto = produto;
		}
		else {
			throw new Exception("Produto invalido");
		}
	}
	
	//Metodos get
	public int getQuantidade() {
		return quantidade;
	}
	public double getValorUnitario() {
		return valorUnitario;
	}
	public Produto getProduto() {
		return produto;
	}
	
	//Metodo equals
	
	//Metodo para atualizar o estoque
	public abstract void atualizaEstoque(int quantidade, String produto);
	
	//Metodo que atualiza o caixa 
	public abstract void atualizaCaixa(int quantidade, double valor);
	
	//Metodo que calcula o valor da transacao
	public abstract double calculaValor(int quantidade, double valorUnitario);
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nQuantidade: ");
		builder.append(this.getQuantidade());
		builder.append(", Valor unitario: ");
		builder.append(this.getValorUnitario());
		builder.append(", Produto: ");
		builder.append(this.getProduto());
		return builder.toString();
	}
	
	
}
