package modelo;

import java.sql.SQLException;
import java.util.Iterator;
import gui.Home;

public class Uso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MySql mysql = new MySql("jdbc:mysql://127.0.0.1:3306/dist?useTimezone=true&serverTimezone=UTC", "root", "");
		
		Modelo.setConnection(mysql);
		
		Home home = new Home();
                home.setVisible(true);
		
	}

}
