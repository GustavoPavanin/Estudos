package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro { 
	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection con = connectionFactory.conectar()) {
			con.setAutoCommit(false);

			try (PreparedStatement stm = con.prepareStatement("insert into PRODUTO (nome, descricao) values (?,?)",
					Statement.RETURN_GENERATED_KEYS)) {

				adicionarVariavel("SmartTV", "TV 45 Polegadas", stm);
				adicionarVariavel("Radio", "Radio de bateria", stm);

				con.commit();

				stm.close();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Rollback Executado");
				con.rollback();
			}

		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		stm.execute();

		/*
		 * TESTE DO ROLLBACK if(nome.equals("Radio")) { throw new
		 * RuntimeException("Não foi possível adicionar o produto"); }
		 */
		try (ResultSet rst = stm.getGeneratedKeys()) {
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi: " + id);

			}
		}

	}

}
