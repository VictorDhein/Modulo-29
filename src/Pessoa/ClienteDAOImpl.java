package Pessoa;

import java.util.List;
import java.util.ArrayList;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public void inserir(Cliente cliente) {
        // Implementação do método inserir
        System.out.println("Inserindo cliente: " + cliente.getNome());
    }

    @Override
    public void cadastrar(Cliente cliente) {
        // Implementação do método cadastrar
        System.out.println("Cadastrando cliente: " + cliente.getNome());
    }

    @Override
    public Cliente consultar(int id) {
        // Implementação do método consultar
        return new Cliente(id, "Cliente Exemplo", "cliente@exemplo.com", "123456789", 30); // Retorna um exemplo
    }

    @Override
    public void atualizar(Cliente cliente) {
        // Implementação do método atualizar
        System.out.println("Atualizando cliente: " + cliente.getNome());
    }

    @Override
    public void excluir(int id) {
        // Implementação do método excluir
        System.out.println("Excluindo cliente com ID: " + id);
    }

    @Override
    public List<Cliente> buscarTodos() {
        // Implementação do método buscarTodos
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Cliente A", "a@exemplo.com", "111222333", 25));
        clientes.add(new Cliente(2, "Cliente B", "b@exemplo.com", "444555666", 30));
        return clientes;
    }

    @Override
    public List<Cliente> listarTodos() {
        // Implementação do método listarTodos
        return buscarTodos();  // Retorna todos os clientes cadastrados
    }
}
