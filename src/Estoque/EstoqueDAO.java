package Estoque;

import java.util.List;

public interface EstoqueDAO {
    void adicionarEstoque(int produtoId, int quantidade);
    void removerEstoque(int produtoId, int quantidade);
    Estoque consultarEstoque(int produtoId);
    List<Estoque> listarTodos();
}
