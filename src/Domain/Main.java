package Domain;

import Estoque.Produto;
import Estoque.ProdutoDAO;
import Estoque.ProdutoDAOImpl;
import Pessoa.Cliente;
import Pessoa.ClienteDAO;
import Pessoa.ClienteDAOImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAOImpl();
        ProdutoDAO produtoDAO = new ProdutoDAOImpl();

        // Testando clientes
        Cliente cliente1 = new Cliente(0, "Mario Heloiso", "MarioHeloiso@email.com", "12345678900", 30);
        clienteDAO.inserir(cliente1);

        List<Cliente> clientes = clienteDAO.listarTodos();
        clientes.forEach(cliente -> System.out.println(cliente.getId() + " - " + cliente.getNome()));

        // Testando produtos
        Produto produto1 = new Produto(0, "Notebook", 3500.00, 10, "Dell");
        produtoDAO.inserir(produto1);

        List<Produto> produtos = produtoDAO.listarTodos();
        produtos.forEach(produto -> System.out.println(produto.getId() + " - " + produto.getNome()));
    }
}
