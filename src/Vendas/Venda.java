package Vendas;

import java.time.LocalDate;

public class Venda {
    private int id;
    private int clienteId;
    private int produtoId;
    private int quantidade;
    private LocalDate dataVenda;

    public Venda() {}

    public Venda(int id, int clienteId, int produtoId, int quantidade, LocalDate dataVenda) {
        this.id = id;
        this.clienteId = clienteId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.dataVenda = dataVenda;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getClienteId() { return clienteId; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }
    public int getProdutoId() { return produtoId; }
    public void setProdutoId(int produtoId) { this.produtoId = produtoId; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public LocalDate getDataVenda() { return dataVenda; }
    public void setDataVenda(LocalDate dataVenda) { this.dataVenda = dataVenda; }
}
