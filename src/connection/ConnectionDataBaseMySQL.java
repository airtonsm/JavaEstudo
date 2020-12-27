package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Realiza conexão com banco de dados
 * Conexão MySQL para o banco testes
 * @author Airton
  */
public class ConnectionDataBaseMySQL {
	
	private static String banco = "jdbc:mysql://localhost:3306/testes?autoReconnect=true";
	private static String user = "root";
	private static String password = "admin";
	private static Connection connection = null;
	
	static {
		conectar();
	}
	
	public ConnectionDataBaseMySQL() {
		conectar();
	}
	
	private static void conectar() {
		
		try {
			if(connection == null)	{
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(banco, user, password);
			}	
		}catch (Exception exception) {
			throw new RuntimeException("Erro ao conectar ao banco de dados" + exception.getMessage());
		}
	}
	/*
	 * Retorna a conexão do banco de dados
	 * @return Connection SQL
	 */
	public static Connection getConnection() {
		return connection;
	}
	
	
}
