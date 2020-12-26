package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Realiza conexão com banco de dados
 * 
 * 
  */
public class ConnectionDataBase {
	
	private static String banco = "jdbc:postgreslq://localhost:5432/curso-jsp?autoReconnect=true";
	private static String password = "admin";
	private static String user = "admin";
	private static Connection connection = null;
	
	static {
		conectar();
	}
	
	public ConnectionDataBase() {
		conectar();
	}
	
	public static conectar() {
		
		try {
			if(connection == null)	{
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(banco, user, password);
			}	
		}catch (Exception exception) {
			throw new RuntimeException("Erro ao conectar ao banco de dados" + exception.getMessage());
		}
	}
}
