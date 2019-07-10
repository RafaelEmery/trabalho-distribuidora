package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class TransacaoCompra extends Transacao {
	private Fornecedor fornecedor;
	
	public TransacaoCompra() {
		super();
	}
	
	public TransacaoCompra(Cerveja produto, int responsavel, int quant, double valor, double desconto) throws Exception {
		super(produto, responsavel, quant, valor, desconto);
		this.setFornecedor(Fornecedor.find(this.getResponsavel()));
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	/**
	 * Pega todos os registros da tabela da classe e retorna eles em uma linked list de objetos pessoa
	 * @param db - banco de dados que esta sendo utilizado
	 * @return LinkedList<Transacao>
	 * @author Cassio Fernandes
	 * @throws Exception - Caso nao seja possivel criar um objeto Cerveja a partir dos dados do banco de dados
	 */
	public static LinkedList<Transacao> all() throws Exception{
		LinkedList<Transacao> lista = new LinkedList<Transacao>();
		ResultSet rs = Transacao.getConnection().select(Transacao.getTableName()).get();
		while(rs.next()) {
			lista.add(Transacao.createFromDatabase(rs));
		}
		return lista;
	}

	@Override
	public void atualizaEstoque(int quantidade, String produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizaCaixa(int quantidade, double valor) {
		// TODO Auto-generated method stub
		
	}	


}
