package Vendas;

import DataBase.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaDAOImpl implements VendaDAO {

    @Override
    public void registrarVenda(Venda venda) {
        String sql = "INSERT INTO vendas (cliente_id, produto_id, quantidade, data_venda) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, venda.getClienteId());
            stmt.setInt(2, venda.getProdutoId());
            stmt.setInt(3, venda.getQuantidade());
            stmt.setDate(4, Date.valueOf(venda.getDataVenda()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Venda consultarVenda(int id) {
        String sql = "SELECT * FROM vendas WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Venda(
                        rs.getInt("id"),
                        rs.getInt("cliente_id"),
                        rs.getInt("produto_id"),
                        rs.getInt("quantidade"),
                        rs.getDate("data_venda").toLocalDate()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Venda> listarVendas() {
        List<Venda> vendas = new ArrayList<>();
        String sql = "SELECT * FROM vendas";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                vendas.add(new Venda(
                        rs.getInt("id"),
                        rs.getInt("cliente_id"),
                        rs.getInt("produto_id"),
                        rs.getInt("quantidade"),
                        rs.getDate("data_venda").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendas;
    }
}
