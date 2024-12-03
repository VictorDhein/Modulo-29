package Estoque;

import DataBase.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAOImpl implements ProdutoDAO {

    @Override
    public void inserir(Produto produto) {
        String sql = "INSERT INTO produtos (nome, preco, quantidade, fabricante) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setString(4, produto.getFabricante());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Produto consultar(int id) {
        String sql = "SELECT * FROM produtos WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade"),
                        rs.getString("fabricante")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM produtos WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Produto> buscarTodos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                produtos.add(new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade"),
                        rs.getString("fabricante")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    @Override
    public Produto consultarPorId(int id) {
        return consultar(id); // O método consultarPorId é basicamente o mesmo que consultar
    }

    @Override
    public void atualizar(Produto produto) {
        String sql = "UPDATE produtos SET nome = ?, preco = ?, quantidade = ?, fabricante = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setString(4, produto.getFabricante());
            stmt.setInt(5, produto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cadastrar(Produto produto) {
        inserir(produto); // O método cadastrar pode ser simplesmente um alias para inserir
    }

    @Override
    public List<Produto> listarTodos() {
        return buscarTodos(); // Implementação básica, já que buscarTodos já implementa isso
    }
}
