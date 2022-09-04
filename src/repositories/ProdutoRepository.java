package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Produto;
import factories.ConnectionFactory;
import interfaces.IProdutoRepository;

public class ProdutoRepository implements IProdutoRepository {

	private double preco;

	@Override
	public void create(Produto obj) throws Exception {
		Connection connection = ConnectionFactory.createConnection();

		PreparedStatement statement = connection
				.prepareStatement("insert into produto(nome, preco, quantidade) values(?, ?, ?)");
		statement.setString(1, obj.getNome());
		statement.setDouble(2, obj.getPreco());
		statement.setInt(3, obj.getQuantidade());
		statement.execute();

		connection.close();
	}

	@Override
	public void update(Produto obj) throws Exception {
		Connection connection = ConnectionFactory.createConnection();

		PreparedStatement statement = connection
				.prepareStatement("update produto set nome=?, cnpj=?, quantidade=? where idfornecedor=?");
		statement.setString(1, obj.getNome());
		statement.setDouble(2, obj.getPreco());
		statement.setInt(3, obj.getQuantidade());
		statement.setInt(4, obj.getIdProduto());
		statement.execute();

		connection.close();
	}

	@Override
	public void delete(Produto obj) throws Exception {
		Connection connection = ConnectionFactory.createConnection();

		PreparedStatement statement = connection.prepareStatement("delete from produto where idproduto=?");
		statement.setInt(1, obj.getIdProduto());
		statement.execute();

		connection.close();
	}

	@Override
	public List<Produto> findAll() throws Exception {
		Connection connection = ConnectionFactory.createConnection();

		PreparedStatement statement = connection.prepareStatement("select * from produto");
		ResultSet resultSet = statement.executeQuery();

		List<Produto> lista = new ArrayList<Produto>();

		while (resultSet.next()) {

			Produto produto = new Produto();
			produto.setIdProduto(resultSet.getInt("Idproduto"));
			produto.setNome(resultSet.getString("nome"));
			produto.setPreco(resultSet.getDouble("preco"));
			produto.setQuantidade(resultSet.getInt("quantidade"));

			lista.add(produto);
		}

		connection.close();
		return lista;

	}

	@Override
	public Produto findById(Integer id) throws Exception {
		Connection connection = ConnectionFactory.createConnection();

		PreparedStatement statement = connection.prepareStatement("select * from produto where idproduto=?");
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();

		Produto produto = null;

		if (resultSet.next()) {

			produto = new Produto();
			produto.setIdProduto(resultSet.getInt("idproduto"));
			produto.setNome(resultSet.getString("nome"));
			produto.setPreco(resultSet.getDouble("preco"));
			produto.setQuantidade(resultSet.getInt("quantidade"));

		}

		connection.close();
		return produto;
	}

	@Override
	public List<Produto> findByPreco(Double precoMin, Double precoMax) throws Exception {
		Connection connection = ConnectionFactory.createConnection();

		PreparedStatement statement = connection.prepareStatement("select * from Produto where preco=?");
		statement.setDouble(1, preco);
		ResultSet resultSet = statement.executeQuery();

		List<Produto> lista = new ArrayList<Produto>();

		while (resultSet.next()) {

			Produto produto = new Produto();

			produto.setIdProduto(resultSet.getInt("idproduto"));
			produto.setNome(resultSet.getString("nome"));
			produto.setPreco(resultSet.getDouble("preco"));
			produto.setQuantidade(resultSet.getInt("quantidade"));

			lista.add(produto);
		}

		connection.close();
		return lista;
	}
}
