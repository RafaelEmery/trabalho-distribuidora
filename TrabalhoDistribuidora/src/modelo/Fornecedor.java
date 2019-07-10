package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Fornecedor extends Pessoa {
	private static String tableName = "fornecedor";
	private static String[] fillable = {"nome", "cadastro","tipoPessoa", "telefone", "cidade", "estado", "empresa", "inedito"};
	private static String[] labels = {"Nome", "Numero de Cadastro (CPF/CNPG/RG)","Tipo de Pessoa (Fisica/Juridica)", "Telefone", "Cidade", "Estado", "Empresa", "In�dito"};
	private int id;
	
	private String cidade;
	private String estado;
	private String empresa;
	private int inedito;
	
	//Metodos construtores
	public Fornecedor() {
            super();
	}
	
	public Fornecedor(String nome, String cadastro, String telefone, int tipoPessoa, String cidade, String estado, String empresa, int inedito2) throws Exception {
		super(nome, cadastro, telefone, tipoPessoa);
		this.setCidade(cidade);
		this.setEstado(estado);
		this.setEmpresa(empresa);
		this.setInedito(inedito2);
	}
	
	//Metodos set
	public void setCidade(String cidade) throws Exception {
		if (cidade.isEmpty() == false) {
			this.cidade = cidade;
		}
		else {
			throw new Exception("Cidade invalido");
		}
	}	
	public void setEstado(String estado) throws Exception {
		if (estado.isEmpty() == false) {
			this.estado = estado;
		}
		else {
			throw new Exception("Estado invalido");
		}
	}
	public void setEmpresa(String empresa) throws Exception {
		if (empresa.isEmpty() == false) {
			this.empresa = empresa;
		}
		else {
			throw new Exception("Empresa invalida");
		}
	}
	public void setInedito(int inedito) throws Exception {
		this.inedito = inedito;
	}
	
	//Metodos get
	public String getCidade() {
		return cidade;
	}
	public String getEstado() {
		return estado;
	}
	public String getEmpresa() {
		return empresa;
	}
	public int isInedito() {
		return inedito;
	}
	
	/*
	//Metodo equals
	public boolean equals(Fornecedor fornecedor) {
	
	}
	*/
	
	//Metodo toString
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(", Cidade: ");
		builder.append(this.getCidade());
		builder.append(", Estado: ");
		builder.append(this.getEstado());
		builder.append(", Empresa que representa: ");
		builder.append(this.getEmpresa());
		builder.append(", Primeira vez: ");
		builder.append(this.isInedito());
		return builder.toString();
	}	
	
	/**
	 * Pega todos os registros da tabela da classe e retorna eles em uma linked list de objetos cerveja
	 * @param db - banco de dados que esta sendo utilizado
	 * @return LinkedList<Produto>
	 * @author Cassio Fernandes
	 * @throws Exception - Caso nao seja possivel criar um objeto Fornecedor a partir dos dados do banco de dados
	 */
	public static LinkedList<Pessoa> all() throws Exception{
		LinkedList<Pessoa> lista = new LinkedList<Pessoa>();
		ResultSet rs = Fornecedor.getConnection().select(Fornecedor.getTableName()).get();
		while(rs.next()) {
			lista.add(Fornecedor.createFromDatabase(rs));
		}
		return lista;
	}
	
	private static String getTableName() {
		return Fornecedor.tableName;
	}

	/**
	 * Procura por um elemento especifico no banco de dados e o retorna como objeto Fornecedor
	 * @throws Exception - Caso nao seja possivel criar um objeto Fornecedor a partir dos dados do banco de dados
	 * @author Cassio Fernandes
	 */
	public static Fornecedor find(int id) throws Exception {
		ResultSet rs = Fornecedor.getConnection().select(Fornecedor.getTableName()).where("id", "=", id + "").get();
		rs.next();
		return Fornecedor.createFromDatabase(rs);
	}
	
	/**
	 * Pega os dados necessarios de um ResultSet e cria um objeto Fornecedor a partir destes dados
	 * @param rs
	 * @return Fornecedor
	 * @throws Exception
	 */
	public static Fornecedor createFromDatabase(ResultSet rs) throws Exception {
//		rs.next();
		int id = rs.getInt("id");
        String nome = rs.getString("nome");
        int tipoPessoa = rs.getInt("tipoPessoa");
        String cadastro = rs.getString("cadastro");
        String telefone = rs.getString("telefone");
        String cidade = rs.getString("cidade");
        String estado = rs.getString("estado");
        String empresa = rs.getString("empresa");
        int inedito = rs.getInt("inedito");
        Fornecedor newObject;
		newObject = new Fornecedor(nome, cadastro, telefone, tipoPessoa, cidade, estado, empresa, inedito);
		newObject.id = id;
		return newObject;
	}
	
	public static Fornecedor create( String[] valores) throws Exception {
		ResultSet rs = Fornecedor.getConnection().create(Fornecedor.getTableName(), Fornecedor.fillable, Fornecedor.createLinkedList(valores));
		rs.next();
		return Fornecedor.createFromDatabase(rs);
	}
	
	public void delete() throws SQLException {
		Fornecedor.getConnection().delete(Fornecedor.getTableName()).where("id", "=", this.id + "").executar();
	}
	
	public Fornecedor update(String[] valores) throws SQLException, Exception {
		return Fornecedor.createFromDatabase(Fornecedor.getConnection().update(Fornecedor.getTableName(), this.fillable, Fornecedor.createLinkedList(valores), this.id));
	}

	@Override
	public String[] getFillable() {
		return Fornecedor.fillable;
	}

	@Override
	public String[] getLabels() {
		return labels;
	}

	@Override
	public String[] getValues() {
		String[] values = {this.getNome(), this.getCadastro(), this.getTipoPessoa() + "", this.getTelefone(), this.getCidade(), this.getEstado(), this.getEmpresa(), this.isInedito() + ""};
		return values;
	}
	
}
