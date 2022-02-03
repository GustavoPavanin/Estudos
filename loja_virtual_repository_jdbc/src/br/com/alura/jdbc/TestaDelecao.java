package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaDelecao { 
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.conectar();
		
		PreparedStatement stm = con.prepareStatement("DELETE FROM PRODUTO WHERE id > ?");
		stm.setInt(1, 2);
		stm.execute();
		
		Integer linhasModificadas = stm.getUpdateCount();
		System.out.println("Quantidade de linhas modificadas: " + linhasModificadas);
		con.close();
		
		
		
	}
}
