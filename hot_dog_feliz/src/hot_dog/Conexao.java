package hot_dog;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
 private static final String USUARIO = "SeuLogin";
 private static final String SENHA = "SuaSenha";
 private static final String URL = "jdbc:mysql://127.0.0.1:3306/hot_dog_feliz";
 private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
 
 
 public static Connection abrir () throws Exception{
	// Registra o driver
	 Class.forName(DRIVER);
	// Abre a conexão
	 Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
	 return conexao;
 }
 

 
 
}
