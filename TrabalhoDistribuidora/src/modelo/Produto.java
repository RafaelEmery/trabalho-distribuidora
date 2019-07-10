package modelo;

import java.sql.SQLException;
import java.util.LinkedList;

public abstract class Produto extends Modelo {
	private static String tableName = "produto";
	private double valor;
	private String codigoDeBarra;
	
//	//Metodos construtores
	public Produto() {
            
	}
	
	public Produto(double valor, String codigoDeBarra) throws Exception {
		this.setValor(valor);
		this.setCodigoDeBarra(codigoDeBarra);
	}
	
	//Metodos set	
	public void setValor(double valor) {
		this.valor = valor;
	}
	public void setCodigoDeBarra(String codigoDeBarra) {
		this.codigoDeBarra = codigoDeBarra;
	}
	
	//Metodos get
	public double getValor() {
		return valor;
	}
	public String getCodigoDeBarra() {
		return codigoDeBarra;
	}
	
	//Metodo toString
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nValor");
		builder.append(this.getValor());
		builder.append(", Codigo de barra");
		builder.append(this.getCodigoDeBarra());	
		return builder.toString();
	}
	
	public static String getTableName() {
		return tableName;
	}
	
//	public static LinkedList<Produto> all(MySql db) throws SQLException{
//		LinkedList<Produto> lista = new LinkedList<Produto>();
//		while(db.select(Produto.getTableName()).get().next()) {
//			int id = rs.getInt("id");
//	        String firstName = rs.getString("first_name");
//	        String lastName = rs.getString("last_name");
//	        Date dateCreated = rs.getDate("date_created");
//	        boolean isAdmin = rs.getBoolean("is_admin");
//	        int numPoints = rs.getInt("num_points");
//		}
//		return null;
//	}
	
	
}
