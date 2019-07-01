package modelo;

public class TransacaoVenda extends Transacao{
	private Cliente cliente;
	private double desconto;
	
	//Metodos construtores
	public TransacaoVenda() throws Exception {
		super();
	}
	
	public TransacaoVenda(int quantidade, double valorUnitario, String produto, Cliente cliente, double desconto) throws Exception {
		super(quantidade, valorUnitario, produto);
		this.setCliente(cliente);
		this.setDesconto(desconto);
	}
	
	//Metodos set
	public void setCliente(Cliente cliente) throws Exception {
		this.cliente = cliente;
	}

	public void setDesconto(double desconto) throws Exception {
		if (desconto > 0) {
			this.desconto = desconto;
		}
		else {
			throw new Exception("Desconto invalido");
		}
	}
	
	//Metodos get
	public Cliente getCliente() {
		return cliente;
	}
	public double getDesconto() {
		return desconto;
	}
	
	/**
	 * Método equals genérico que confere se os objetos são da mesma classe, caso sejam, chama um método específico
	 * para TransacaoVenda, caso não sejam o mesmo, retorna false. 
	 * @return boolean
	 * @author Cassio Fernandes
	 */
	@Override
	public boolean equals(Object obj) {
		if(this.getClass() == obj.getClass()) {
			return this.equals((TransacaoVenda) obj);
		} 
		
		return false;
	}
	
	/**
	 * Método equals específico para a classe TransacaoVenda, retorna true caso seus attributos sejam iguais.
	 * @return boolean
	 * @author Cassio Fernandes
	 * 
	 * NAO ESTA PRONTO!
	 */
	public boolean equals(TransacaoVenda obj) {
		boolean equal = this.getCliente().equals(obj.getCliente());
		equal = equal && this.getQuantidade() == obj.getQuantidade();
		if(this.getCliente().equals(obj.getCliente()) && this.getQuantidade() == obj.getQuantidade()) {
			return true;
		}
		
		return false;
	}
	
	//Metodo para atualizar o estoque
	public void atualizaEstoque(int quantidade, String produto) {
		
	}
	
	//Metodo para atualizar o caixa
	public void atualizaCaixa(int quantidade, double valor) {
		
	}
	
	//Metodo para calcular o valor
	public double calculaValor(int quantidade, double valorUnitario) {
		return quantidade * valorUnitario;
	}
	
	//Metodo para aplicar desconto
	public double aplicaDesconto(double valorTotal, double desconto) {
		return (valorTotal - (valorTotal * (desconto/100)));
	}

	//Metodo toString
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(", Cliente: ");
		builder.append(this.getCliente());
		builder.append(", Desconto (%): ");
		builder.append(this.getDesconto());
		return builder.toString();
	}
	
	
}
