package modelo;

public class TransacaoVenda extends Transacao{
	private Cliente cliente;
	
	//Metodos construtores
	public TransacaoVenda(){
		super();
	}
	
	public TransacaoVenda(Cerveja cerveja, double valor){
		super(cerveja, valor);
	}
	
	public TransacaoVenda(Cerveja produto, int responsavel, int quant, double valor, double desconto) throws Exception {
		super(produto, responsavel, quant, valor, desconto);
		this.setCliente(Cliente.find(this.getResponsavel()));
	}
	
	//Metodos set
	public void setCliente(Cliente cliente) throws Exception {
		this.cliente = cliente;
	}
	
	//Metodos get
	public Cliente getCliente() {
		return cliente;
	}
	
	/**
	 * M�todo equals gen�rico que confere se os objetos s�o da mesma classe, caso sejam, chama um m�todo espec�fico
	 * para TransacaoVenda, caso n�o sejam o mesmo, retorna false. 
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
	 * M�todo equals espec�fico para a classe TransacaoVenda, retorna true caso seus attributos sejam iguais.
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
