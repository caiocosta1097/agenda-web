package br.senai.sp.jandira.dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

private static Connection con;
	
	public static Connection getConexao(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost/agenda?useSSL=false";
			String usuario = "root";
			String senha = "caio61066229";
			con = DriverManager.getConnection(dbUrl, usuario, senha);
			System.out.println("Banco conectado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ocorreu um erro na conexão com o banco!");
		}
		
		return con;
	}
}
