package factories;

import java.sql.Connection;

import java.sql.DriverManager;

public class ConnectionFactory {
	
	//atributo static nao precisa criar espaço de memoria
	//final -- valores que nao podem ser modificados
	private static final String HOST = "jdbc:postgresql://localhost:5432/bd_aula05";
	private static final String USER = "postgres";
	private static final String PASS = "coti";
	private static final String DRIVER = "org.postgresql.Driver";
	
	//metodo para abrir conexão com o banco de dados
	public static Connection createConnection() throws Exception{
		
		//carrega o drive de conexão do banco de dados
		Class.forName(DRIVER);
		
	//abrir e retornar uma conexão com o banco de dados
	return DriverManager.getConnection(HOST, USER, PASS);
	}

}
