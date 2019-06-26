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
	
	//Metodo equals 
	
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
