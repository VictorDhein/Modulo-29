package Pessoa;

import java.util.List;

public interface ClienteDAO {
    void cadastrar(Cliente cliente);
    Cliente consultar(int id);
    void atualizar(Cliente cliente);
    void excluir(int id);
    List<Cliente> buscarTodos();
}

