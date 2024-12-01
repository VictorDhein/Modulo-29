package Pessoa;

import DataBase.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public void cadastrar(Cliente cliente) {
        // SQL para verificar se já existe um cliente com o mesmo email
        String checkEmailSql = "SELECT COUNT(*) FROM cliente WHERE email = ?";
        String insertSql = "INSERT INTO cliente (nome, email) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkEmailSql)) {

            // Verifica se o email já está cadastrado
            checkStmt.setString(1, cliente.getEmail());
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next() && rs.getInt(1) == 0) {  // Se não encontrar nenhum registro com o mesmo email
                // Se o email for único, insere o cliente
                try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                    insertStmt.setString(1, cliente.getNome());
                    insertStmt.setString(2, cliente.getEmail());
                    insertStmt.executeUpdate();
                    System.out.println("Cliente cadastrado com sucesso!");
                }
            } else {
                // Caso o email já exista
                System.out.println("Erro: Cliente com o email " + cliente.getEmail() + " já existe.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cliente consultar(int id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void atualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, email = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setInt(3, cliente.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cliente com ID " + id + " excluído com sucesso.");
            } else {
                System.out.println("Nenhum cliente encontrado com o ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cliente> buscarTodos() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clientes.add(new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}
