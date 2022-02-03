package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class TestaListagem { 
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.conectar();
		
		PreparedStatement stm = con.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		stm.execute();
		
		ResultSet rts = stm.getResultSet();
				
		while(rts.next()) {
			Integer id = rts.getInt("ID");
			String nome = rts.getString("NOME");
			String descricao = rts.getString("DESCRICAO");
			
			System.out.println("Id: " + id + " | Nome: " + nome + " | Descrição: " + descricao);
		}
		
		con.close();
		
	}
}
