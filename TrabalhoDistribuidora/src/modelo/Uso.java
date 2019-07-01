package modelo;

import java.sql.SQLException;
import java.util.Iterator;
import gui.Home;

public class Uso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MySql mysql = new MySql("jdbc:mysql://127.0.0.1:3306/dist?useTimezone=true&serverTimezone=UTC", "root", "root");
		
		Home home = new Home();
                home.setVisible(true);
//		
        String[] valores = {"Arlon Scheidegger", "154.011.727-88", "0", "(027)999770749"};
        try {
			System.out.println(Cliente.create(mysql, valores).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                
//		try {
//			mysql.inserirCliente("Arlon", "154.011.727-88", 1, "(27)9-9977-0749");
//			mysql.inserirFornecedor("Arlon", "154.011.727-88", 1, "(27)9-9977-0749", "Nova Venécia", "ES","Scheidegger", 1);
//			mysql.inserirProduto("Devassa", 8.00, "Puro Malte", 4.2, "1234");
//			mysql.inserirProduto("Skol", 6.00, "Pura Agua", 3.6, "3215");
//			mysql.inserirProduto("Skin", 5.00, "Pura Agua Suja", 2.4, "4458");
//			mysql.inserirCaixa(1, 200.00);
//			mysql.inserirEstoque(1, 100);
//			mysql.inserirTransacao(1, 100, 200, 1, 10);
//			
//			mysql.deletarCliente(4);
//			mysql.deletarCaixa(1);
//			mysql.deletarProduto(1);
//			mysql.deletarFornecedor(1);
//			mysql.deletarEstoque(1);
//			mysql.deletarTransacao(1);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			Iterator i = Cerveja.all(mysql).iterator();
//			while(i.hasNext()) {
//				Cerveja cerveja = (Cerveja) i.next();
//				System.out.println(cerveja.toString());
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
