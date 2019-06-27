package modelo;

import java.sql.SQLException;

public class Uso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MySql mysql = new MySql("jdbc:mysql://localhost:3306/dist", "root", "");
		
		try {
			mysql.inserirCliente("Arlon", "154.011.727-88", 1, "(27)9-9977-0749");
			mysql.inserirFornecedor("Arlon", "154.011.727-88", 1, "(27)9-9977-0749", "Nova Venécia", "ES","Scheidegger", 1);
			mysql.inserirProduto("Devassa", 8.00, "Puro Malte", 4.2, "algumcodigo");
			mysql.inserirCaixa(1, 200.00);
			mysql.inserirEstoque(1, 100);
			mysql.inserirTransacao(1, 100, 200, 1, 10);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
