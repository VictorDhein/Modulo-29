package Estoque;

import java.util.List;

public interface ProdutoDAO {
    void cadastrar(Produto produto);
    Produto consultar(int id);
    void atualizar(Produto produto);
    void excluir(int id);
    List<Produto> buscarTodos();
}
