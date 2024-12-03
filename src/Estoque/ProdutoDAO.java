package Estoque;

import java.util.List;

public interface ProdutoDAO {
    void inserir(Produto produto);

    void cadastrar(Produto produto);
    Produto consultar(int id);
    void atualizar(Produto produto);
    void excluir(int id);
    List<Produto> buscarTodos();

    Produto consultarPorId(int id);

    List<Produto> listarTodos();
}
