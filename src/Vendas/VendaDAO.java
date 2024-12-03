package Vendas;

import java.util.List;

public interface VendaDAO {
    void registrarVenda(Vendas.Venda venda);
    Vendas.Venda consultarVenda(int id);
    List<Vendas.Venda> listarVendas();
}
