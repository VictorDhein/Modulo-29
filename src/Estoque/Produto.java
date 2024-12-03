package Estoque;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private int quantidade;
    private String fabricante;

    public Produto(int id, String nome, double preco, int quantidade, String fabricante) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.fabricante = fabricante;
    }

    // Getters e Setters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }
    public String getFabricante() { return fabricante; }
}
