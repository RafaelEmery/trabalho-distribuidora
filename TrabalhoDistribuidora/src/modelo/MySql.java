package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySql {
	
	Connection conn;
	
	public MySql(String url, String user, String password) {
		  
	    try {
	    	this.conn = DriverManager.getConnection(url, user, password);
	        if (conn != null) {
	        	MySql.criarTables(this.conn);
	            System.out.println("Conectado no banco de dados");
	        }
	    } catch (SQLException ex) {
	        System.out.println("Um erro ocorreu. Usuário ou senha podem estar errados.");
	        ex.printStackTrace();
	    }
	}
	
	public static void criarTables (Connection conn) {
		
		
		String cliente = "CREATE TABLE IF NOT EXISTS `cliente` (\n" + 
				"  `id` int(11) NOT NULL,\n" + 
				"  `nome` varchar(45) DEFAULT NULL,\n" + 
				"  `cadastro` varchar(45) DEFAULT NULL,\n" + 
				"  `tipoPessoa` int(11) DEFAULT NULL,\n" + 
				"  `telefone` varchar(45) DEFAULT NULL,\n" + 
				"  PRIMARY KEY (`id`)\n" + 
				") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
		String fornecedor = "CREATE TABLE IF NOT EXISTS `fornecedor` (\n" + 
				"  `id` int(11) NOT NULL,\n" + 
				"  `nome` varchar(45) NOT NULL,\n" + 
				"  `cadastro` varchar(45) NOT NULL,\n" + 
				"  `tipoPessoa` int(11) NOT NULL,\n" + 
				"  `telefone` varchar(45) NOT NULL,\n" + 
				"  `cidade` varchar(45) NOT NULL,\n" + 
				"  `estado` varchar(45) NOT NULL,\n" + 
				"  `empresa` varchar(45) NOT NULL,\n" + 
				"  `inedito` tinyint(4) DEFAULT NULL,\n" + 
				"  PRIMARY KEY (`id`)\n" + 
				") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
		String estoque = "CREATE TABLE IF NOT EXISTS `estoque` (\n" + 
				"  `id` int(11) NOT NULL,\n" + 
				"  `idProduto` int(11) NOT NULL,\n" + 
				"  `quant` int(11) NOT NULL,\n" + 
				"  PRIMARY KEY (`id`)\n" + 
				") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n";
		String produto = "CREATE TABLE IF NOT EXISTS `produto` (\n" + 
				"  `id` int(11) NOT NULL,\n" + 
				"  `nome` varchar(45) NOT NULL,\n" + 
				"  `valor` double NOT NULL,\n" + 
				"  `tipoCerveja` varchar(45) NOT NULL,\n" + 
				"  `porcentagemAlcool` double NOT NULL,\n" + 
				"  `codigoBarra` varchar(45) NOT NULL,\n" + 
				"  PRIMARY KEY (`id`)\n" + 
				") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
		String transacao = "CREATE TABLE IF NOT EXISTS `transacao` (\n" + 
				"  `id` int(11) NOT NULL,\n" + 
				"  `idResponsavel` int(11) NOT NULL,\n" + 
				"  `quant` int(11) NOT NULL,\n" + 
				"  `valor` double NOT NULL,\n" + 
				"  `idProduto` int(11) NOT NULL,\n" + 
				"  `desconto` int(11) DEFAULT NULL,\n" + 
				"  PRIMARY KEY (`id`)\n" + 
				") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" + 
				"";
		String caixa = "CREATE TABLE IF NOT EXISTS `caixa` (\n" + 
				"  `id` int(11) NOT NULL,\n" + 
				"  `idTransacao` int(11) NOT NULL,\n" + 
				"  `valorCaixa` double NOT NULL,\n" + 
				"  PRIMARY KEY (`id`)\n" + 
				") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" + 
				"";
		
		
		
//		String teste2 = new StringBuilder().append("CREATE TABLE IF NOT EXISTS tasks (").
//				append("task_id INT AUTO_INCREMENT,").
//				append("title VARCHAR(255) NOT NULL,").
//				append("start_date DATE,").
//				append("due_date DATE,").
//			    append("status TINYINT NOT NULL,").
//			    append("priority TINYINT NOT NULL,").
//			    append("description TEXT,").
//			    append("PRIMARY KEY (task_id)").
//			append(  ")ENGINE=INN\" ").toString();
		
		try {
			conn.createStatement().execute(fornecedor);
			conn.createStatement().execute(cliente);
			conn.createStatement().execute(produto);
			conn.createStatement().execute(estoque);
			conn.createStatement().execute(transacao);
			conn.createStatement().execute(caixa);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

//		try {
			
//			System.out.println("DB criada");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
		
}
