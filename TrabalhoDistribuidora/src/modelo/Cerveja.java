package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Cerveja extends Produto {
	
	private static String tableName = "produto";
	private static String[] fillable = {"nome", "porcentagemAlcool","tipoCerveja", "valor", "codigoBarra"};
	private static String[] labels = {"Nome", "Porcentagem de Álcool","Tipo de Cerveja", "Valor", "Codigo de Barra"};
	private int id;
	
	private String nome;
	private String tipoCerveja;
	private double porcentagemAlcool;
	
	//Metodos construtores
	public Cerveja() {
            
	}
	
	/**
	 * 
	 * @param nome
	 * @param tipoCerveja
	 * @param porcentagemAlcool
	 * @param valor
	 * @param codigoDeBarra
	 * @throws Exception
	 */
	public Cerveja(String nome, String tipoCerveja, double porcentagemAlcool, double valor, String codigoDeBarra) throws Exception {
		super(valor, codigoDeBarra);
		this.setNome(nome);
		this.setTipoCerveja(tipoCerveja);
		this.setPorcentagemAlcool(porcentagemAlcool);
	}
	
	//Metodos set
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setTipoCerveja(String tipoCerveja) {
		this.tipoCerveja = tipoCerveja;
	}
	public void setPorcentagemAlcool(double porcentagemAlcool) {
		this.porcentagemAlcool = porcentagemAlcool;
	}
	
	//Metodos get
	public String getNome() {
		return nome;
	}
	public String getTipoCerveja() {
		return tipoCerveja;
	}
	public double getPorcentagemAlcool() {
		return porcentagemAlcool;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("\n Nome: ");
		builder.append(this.getNome());
		builder.append(", Tipo de cerveja: ");
		builder.append(this.getTipoCerveja());
		builder.append(", Porcentagem de alcool: ");
		builder.append(this.getPorcentagemAlcool());
		return builder.toString();
	}
	
	/**
	 * Pega todos os registros da tabela da classe e retorna eles em uma linked list de objetos cerveja
	 * @param db - banco de dados que esta sendo utilizado
	 * @return LinkedList<Produto>
	 * @author Cassio Fernandes
	 * @throws Exception - Caso nao seja possivel criar um objeto Cerveja a partir dos dados do banco de dados
	 */
	public static LinkedList<Produto> all() throws Exception{
		LinkedList<Produto> lista = new LinkedList<Produto>();
		ResultSet rs = Cerveja.getConnection().select(Produto.getTableName()).get();
		while(rs.next()) {
			lista.add(Cerveja.createFromDatabase(rs));
		}
		return lista;
	}
	
	/**
	 * Procura por um elemento especifico no banco de dados e o retorna como objeto Cerveja
	 * @throws Exception - Caso nao seja possivel criar um objeto Cerveja a partir dos dados do banco de dados
	 * @author Cassio Fernandes
	 */
	public static Cerveja find(int id) throws Exception {
		ResultSet rs = Cerveja.getConnection().select(Produto.getTableName()).where("id", "=", id + "").get();
		return Cerveja.createFromDatabase(rs);
	}
	
	/**
	 * Pega os dados necessarios de um ResultSet e cria um objeto Cerveja a partir destes dados
	 * @param rs
	 * @return Cerveja
	 * @throws Exception
	 */
	public static Cerveja createFromDatabase(ResultSet rs) throws Exception {
		rs.next();
		int id = rs.getInt("id");
        String nome = rs.getString("nome");
        double porcentagemAlcool = rs.getDouble("porcentagemAlcool");
        String tipo = rs.getString("tipoCerveja");
        double valor = rs.getDouble("valor");
        String codigoBarra = rs.getString("codigoBarra");
        Cerveja newCerveja;
		newCerveja = new Cerveja(nome, tipo, porcentagemAlcool, valor, codigoBarra);
		newCerveja.id = id;
		return newCerveja;
	}
	
	public static Cerveja create(String[] valores) throws Exception {
		return Cerveja.createFromDatabase(Cerveja.getConnection().create(Cerveja.getTableName(), Cerveja.fillable, Cerveja.createLinkedList(valores)));
	}
	
	public void delete() throws SQLException {
		Cerveja.getConnection().delete(Cerveja.getTableName()).where("id", "=", this.id + "").executar();
	}
	
	public Cerveja update(String[] valores) throws SQLException, Exception {
		return Cerveja.createFromDatabase(Cerveja.getConnection().update(Cerveja.getTableName(), this.fillable, Cerveja.createLinkedList(valores), this.id));
	}

	@Override
	public String[] getFillable() {
		return Cerveja.fillable;
	}

	@Override
	public String[] getLabels() {
		return labels;
	}

	@Override
	public String[] getValues() {
		String[] values = {this.getNome(), this.getPorcentagemAlcool() + "", this.getTipoCerveja() + "", this.getValor() + "", this.getCodigoDeBarra()};
		return values;
	}
	
	public int getId() {
		return this.id;
	}
	
}
