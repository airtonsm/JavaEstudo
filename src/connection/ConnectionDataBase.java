package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Realiza conex�o com banco de dados
 * 
 * 
  */
public class ConnectionDataBase {
	
	private static String banco = "jdbc:postgresql://localhost:5432/testes?autoReconnect=true";
	private static String user = "postgres";
	private static String password = "admin";
	private static Connection connection = null;
	
	static {
		conectar();
	}
	
	public ConnectionDataBase() {
		conectar();
	}
	
	private static void conectar() {
		
		try {
			if(connection == null)	{
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(banco, user, password);
			}	
		}catch (Exception exception) {
			throw new RuntimeException("Erro ao conectar ao banco de dados" + exception.getMessage());
		}
	}
	/*
	 * Retorna a conex�o do banco de dados
	 * @return Connection SQL
	 */
	public static Connection getConnection() {
		return connection;
	}
	
	
}
