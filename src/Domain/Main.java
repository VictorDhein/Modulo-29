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
        // Instâncias dos DAOs
        ClienteDAO clienteDAO = new ClienteDAOImpl();
        ProdutoDAO produtoDAO = new ProdutoDAOImpl();

        // Teste com Clientes
        System.out.println("==== CLIENTES ====");
        Cliente cliente1 = new Cliente(0, "Mario Heloiso", "MarioHeloiso@email.com");
        clienteDAO.cadastrar(cliente1);

        Cliente cliente2 = new Cliente(0, "Maria Heloisa", "MariaHeloisa@email.com");
        clienteDAO.cadastrar(cliente2);

        System.out.println("Clientes cadastrados:");
        List<Cliente> clientes = clienteDAO.buscarTodos();
        clientes.forEach(cliente -> System.out.println(cliente.getId() + " - " + cliente.getNome() + " - " + cliente.getEmail()));

        System.out.println("\nConsultando cliente com ID 1:");
        Cliente clienteConsultado = clienteDAO.consultar(1);

        if (clienteConsultado != null) {
            System.out.println(clienteConsultado.getId() + " - " + clienteConsultado.getNome() + " - " + clienteConsultado.getEmail());

            System.out.println("\nAtualizando cliente com ID 1:");
            clienteConsultado.setNome("João Atualizado");
            clienteDAO.atualizar(clienteConsultado);

            Cliente clienteAtualizado = clienteDAO.consultar(1);
            System.out.println(clienteAtualizado.getId() + " - " + clienteAtualizado.getNome() + " - " + clienteAtualizado.getEmail());
        } else {
            System.out.println("Cliente com ID 1 não encontrado, não é possível atualizar.");
        }

        System.out.println("\nExcluindo cliente com ID 2:");
        clienteDAO.excluir(2);

        System.out.println("Clientes restantes:");
        clientes = clienteDAO.buscarTodos();
        clientes.forEach(cliente -> System.out.println(cliente.getId() + " - " + cliente.getNome() + " - " + cliente.getEmail()));

        // Teste com Produtos
        System.out.println("\n==== PRODUTOS ====");
        Produto produto1 = new Produto(0, "Notebook", 3500.00);
        produtoDAO.cadastrar(produto1);

        Produto produto2 = new Produto(0, "Smartphone", 2000.00);
        produtoDAO.cadastrar(produto2);

        System.out.println("Produtos cadastrados:");
        List<Produto> produtos = produtoDAO.buscarTodos();
        produtos.forEach(produto -> System.out.println(produto.getId() + " - " + produto.getNome() + " - R$" + produto.getPreco()));

        System.out.println("\nConsultando produto com ID 1:");
        Produto produtoConsultado = produtoDAO.consultar(1);

        if (produtoConsultado != null) {
            System.out.println(produtoConsultado.getId() + " - " + produtoConsultado.getNome() + " - R$" + produtoConsultado.getPreco());

            System.out.println("\nAtualizando produto com ID 1:");
            produtoConsultado.setPreco(3200.00);
            produtoDAO.atualizar(produtoConsultado);

            Produto produtoAtualizado = produtoDAO.consultar(1);
            System.out.println(produtoAtualizado.getId() + " - " + produtoAtualizado.getNome() + " - R$" + produtoAtualizado.getPreco());
        } else {
            System.out.println("Produto com ID 1 não encontrado, não é possível atualizar.");
        }

        System.out.println("\nExcluindo produto com ID 2:");
        produtoDAO.excluir(2);

        System.out.println("Produtos restantes:");
        produtos = produtoDAO.buscarTodos();
        produtos.forEach(produto -> System.out.println(produto.getId() + " - " + produto.getNome() + " - R$" + produto.getPreco()));
    }
}
