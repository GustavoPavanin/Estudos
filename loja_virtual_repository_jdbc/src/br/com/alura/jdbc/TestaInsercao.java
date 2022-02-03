package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao { 

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.conectar();
		
		PreparedStatement stm = con.prepareStatement("insert into PRODUTO (nome, descricao) values ('MOUSE','MOUSE SEM FIO')", Statement.RETURN_GENERATED_KEYS);
		stm.execute();
		
		ResultSet rst = stm.getGeneratedKeys();
		
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);
			
		}
		
		con.close();
		
	}

}
