package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Transacao extends Modelo {
	private static String tableName = "transacao";
	private static String[] fillable = {"idProduto", "idResponsavel","quant", "valor", "desconto"};
	private static String[] labels = {"Produto", "Responsavel","Quantidade","Despesa/Receita (-1/1)", "Desconto"};
	private int id;
	
	private int quantidade;
	private double valor;
	private double desconto;
	private Cerveja produto;
	private int responsavel;
	
	
	//Metodos construtores
	public Transacao(){
		this.quantidade = 0;
		this.valor = 0;
		this.produto = new Cerveja();
		this.responsavel = 0;
	}
	
	public Transacao(Cerveja cerveja, double valor){
		this.quantidade = 0;
		this.valor = valor;
		this.produto = cerveja;
		this.responsavel = 0;
	}
	
	public Transacao(Cerveja produto, int responsavel,int quantidade, double valor, double desconto) throws Exception {
		this.setQuantidade(quantidade);
		this.setValor(valor);
		this.setProduto(produto);
		this.setDesconto(desconto);
		this.setResponsavel(responsavel);
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
//		if (valorUnitario > 0) {
			this.valor = valorUnitario * this.quantidade;
//		}
//		else {
//			throw new Exception("Valor unitario invalido");
//		}
	}
	
	public void setProduto(Cerveja produto) {
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
	public double getValor() {
		return valor;
	}
	public Cerveja getProduto() {
		return produto;
	}
	
	//Metodo equals
	
	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public int getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(int responsavel) {
		this.responsavel = responsavel;
	}

	//Metodo para atualizar o estoque
	public abstract void atualizaEstoque(int quantidade, String produto);
	
	//Metodo que atualiza o caixa 
	public abstract void atualizaCaixa(int quantidade, double valor);
	
	//Metodo que calcula o valor da transacao
	public double calculaValor(int quantidade, double valorUnitario) {
		return quantidade * valorUnitario;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nQuantidade: ");
		builder.append(this.getQuantidade());
		builder.append(", Valor unitario: ");
		builder.append(this.getValor());
		builder.append(", Produto: ");
		builder.append(this.getProduto());
		return builder.toString();
	}
	
	/**
	 * Procura por um elemento especifico no banco de dados e o retorna como objeto Transacao
	 * @throws Exception - Caso nao seja possivel criar um objeto Cerveja a partir dos dados do banco de dados
	 * @author Cassio Fernandes
	 */
	public static Transacao find(int id) throws Exception {
		ResultSet rs = Transacao.getConnection().select(Transacao.getTableName()).where("id", "=", id + "").get();
		return Transacao.createFromDatabase(rs);
	}
	
	public static String getTableName() {
		return Transacao.tableName;
	}

	/**
	 * Pega os dados necessarios de um ResultSet e cria um objeto Transacao a partir destes dados
	 * @param rs
	 * @return Transacao
	 * @throws Exception
	 */
	public static Transacao createFromDatabase(ResultSet rs) throws Exception {
		rs.next();
		int id = rs.getInt("id");
        int idProduto = rs.getInt("idProduto");
        int idResponsavel = rs.getInt("idResponsavel");
        int quant = rs.getInt("quant");
        double valor = rs.getDouble("valor");
        double desconto = rs.getDouble("desconto");
        Transacao newObject;
        if(valor < 0) {
        	newObject = new TransacaoCompra(Cerveja.find(idProduto), idResponsavel, quant, valor, desconto);
        } else {
        	newObject = new TransacaoVenda(Cerveja.find(idProduto), idResponsavel, quant, valor, desconto);
        }
		newObject.id = id;
		return newObject;
	}
	
	public static Transacao create(String[] valores) throws Exception {
		if(Integer.parseInt(valores[2]) > 0) {
			//Corrigi estoque com Transacao Venda
		} else {
			//Corrige estoque com Transacao Compra
		}
		return Transacao.createFromDatabase(Transacao.getConnection().create(Transacao.getTableName(), Transacao.fillable, Transacao.createLinkedList(valores)));
	}
	
	public void delete() throws SQLException {
		Transacao.getConnection().delete(Transacao.getTableName()).where("id", "=", this.id + "").executar();
	}
	
	@Override
	public String[] getFillable() {
		return Transacao.fillable;
	}

	@Override
	public String[] getLabels() {
		return labels;
	}
	
	public Transacao update(String[] valores) throws SQLException, Exception {
        return Transacao.createFromDatabase(Transacao.getConnection().update(Transacao.getTableName(), Transacao.fillable, Transacao.createLinkedList(valores), this.id));
    }

	@Override
	public String[] getValues() {
		String[] values = { this.getProduto().getId() + "", this.getResponsavel() + "", this.getQuantidade() + "", this.getValor() + "", this.getDesconto() + ""};
		return values;
	}
	
}
