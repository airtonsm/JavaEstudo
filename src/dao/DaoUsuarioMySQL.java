package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionDataBase;
import entidades.Usuario;

public class DaoUsuarioMySQL {
	
	private static Connection connection;
	
	public DaoUsuarioMySQL() {
		connection = ConnectionDataBase.getConnection();
	}
	
	public List<Usuario> getUsuarios() throws Exception{
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "select * from usuario";		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			Usuario usuario = new Usuario();
			usuario.setId(resultSet.getString("id"));
			usuario.setLogin(resultSet.getString("Login"));
			usuario.setSenha(resultSet.getString("senha"));
			
			usuarios.add(usuario);
		}
		
		return usuarios;
		
	}

}
