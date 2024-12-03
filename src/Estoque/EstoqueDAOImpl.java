package Estoque;

import DataBase.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAOImpl implements EstoqueDAO {

    @Override
    public void adicionarEstoque(int produtoId, int quantidade) {
        String sql = "INSERT INTO estoque (produto_id, quantidade) VALUES (?, ?) ON DUPLICATE KEY UPDATE quantidade = quantidade + ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, produtoId);
            stmt.setInt(2, quantidade);
            stmt.setInt(3, quantidade);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removerEstoque(int produtoId, int quantidade) {
        String sql = "UPDATE estoque SET quantidade = quantidade - ? WHERE produto_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, quantidade);
            stmt.setInt(2, produtoId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Estoque consultarEstoque(int produtoId) {
        String sql = "SELECT * FROM estoque WHERE produto_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, produtoId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Estoque(rs.getInt("id"), rs.getInt("produto_id"), rs.getInt("quantidade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Estoque> listarTodos() {
        List<Estoque> estoques = new ArrayList<>();
        String sql = "SELECT * FROM estoque";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                estoques.add(new Estoque(rs.getInt("id"), rs.getInt("produto_id"), rs.getInt("quantidade")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estoques;
    }
}
