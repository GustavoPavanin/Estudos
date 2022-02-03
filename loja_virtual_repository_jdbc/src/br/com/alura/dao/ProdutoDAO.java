package br.com.alura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.ConnectionFactory;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Produto produto) throws SQLException {
		try (Connection connection = new ConnectionFactory().conectar()) {
			String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES(?,?)";
			try (PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				pst.setString(1, produto.getNome());
				pst.setString(2, produto.getDescricao());

				pst.execute();

				try (ResultSet rst = pst.getGeneratedKeys()) {
					while (rst.next()) {
						produto.setId(rst.getInt(1));
					}
				}
			}

		}
	}

	public List<Produto> listar() throws SQLException {
		List<Produto> produtos = new ArrayList<>();

		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";
		try (PreparedStatement stm = connection.prepareStatement(sql)) {
			stm.execute();

			try (ResultSet rts = stm.getResultSet()) {
				while (rts.next()) {
					Produto produto = new Produto(rts.getInt(1), rts.getString(2), rts.getString(3));
					produtos.add(produto);
				}
			}

		}
		return produtos;

	}

	public List<Produto> buscar(Categoria ct) throws SQLException {
		List<Produto> produtos = new ArrayList<>();

		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO WHERE CATEGORIA_ID = ?";
		try (PreparedStatement stm = connection.prepareStatement(sql)) {
			stm.setInt(1, ct.getId());
			stm.execute();

			try (ResultSet rts = stm.getResultSet()) {
				while (rts.next()) {
					Produto produto = new Produto(rts.getInt(1), rts.getString(2), rts.getString(3));
					produtos.add(produto);
				}
			}

		}
		return produtos;
	}
}
