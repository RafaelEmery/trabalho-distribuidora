package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Cliente extends Pessoa {
	
	private static String tableName = "cliente";
	private static String[] fillable = {"nome", "cadastro","tipoPessoa", "telefone"};
	private int id;
	
	public Cliente(String nome, String cadastro, String telefone, int tipoPessoa) throws Exception {
		super(nome, cadastro, telefone, tipoPessoa);
	}
	
	public static String getTableName() {
		return tableName;
	}

	public static void setTableName(String tableName) {
		Cliente.tableName = tableName;
	}

	/**
	 * Pega todos os registros da tabela da classe e retorna eles em uma linked list de objetos pessoa
	 * @param db - banco de dados que esta sendo utilizado
	 * @return LinkedList<Pessoa>
	 * @author Cassio Fernandes
	 * @throws Exception - Caso nao seja possivel criar um objeto Cerveja a partir dos dados do banco de dados
	 */
	public static LinkedList<Pessoa> all(MySql db) throws Exception{
		LinkedList<Pessoa> lista = new LinkedList<Pessoa>();
		ResultSet rs = db.select(Cliente.getTableName()).get();
		while(rs.next()) {
			lista.add(Cliente.createFromDatabase(rs));
		}
		return lista;
	}
	
	/**
	 * Procura por um elemento especifico no banco de dados e o retorna como objeto Cliente
	 * @throws Exception - Caso nao seja possivel criar um objeto Cerveja a partir dos dados do banco de dados
	 * @author Cassio Fernandes
	 */
	public static Cliente find(MySql db, int id) throws Exception {
		ResultSet rs = db.select(Cliente.getTableName()).where("id", "=", id + "").get();
		return Cliente.createFromDatabase(rs);
	}
	
	/**
	 * Pega os dados necessarios de um ResultSet e cria um objeto Cliente a partir destes dados
	 * @param rs
	 * @return Cliente
	 * @throws Exception
	 */
	public static Cliente createFromDatabase(ResultSet rs) throws Exception {
		rs.next();
		int id = rs.getInt("id");
        String nome = rs.getString("nome");
        int tipoPessoa = rs.getInt("tipoPessoa");
        String cadastro = rs.getString("cadastro");
        String telefone = rs.getString("telefone");
        Cliente newCliente;
		newCliente = new Cliente(nome, cadastro, telefone, tipoPessoa);
		newCliente.id = id;
		return newCliente;
	}
	
	public static Cliente create(MySql db, String[] valores) throws Exception {
		return Cliente.createFromDatabase(db.create(Cliente.getTableName(), Cliente.fillable, Cliente.createLinkedList(valores)));
	}
	
	public static LinkedList<String> createLinkedList(String[] valores) throws Exception {
		LinkedList<String> list = new LinkedList<String>();
		for(String valor: valores) {
			list.add(valor);
		}
		return list;
	}
	
}
