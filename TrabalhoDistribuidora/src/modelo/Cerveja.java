package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Cerveja extends Produto {
	private int id;
	private String nome;
	private String tipoCerveja;
	private double porcentagemAlcool;
	
	//Metodos construtores
//	public Cerveja() throws Exception {
//		super();
//	}
	
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
	public static LinkedList<Produto> all(MySql db) throws Exception{
		LinkedList<Produto> lista = new LinkedList<Produto>();
		ResultSet rs = db.select(Produto.getTableName()).get();
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
	public static Cerveja find(MySql db, int id) throws Exception {
		ResultSet rs = db.select(Produto.getTableName()).where("id", "=", id + "").get();
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
	
}
