package Pessoa;

public class Cliente {
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private int idade;

    public Cliente(int id, String nome, String email, String cpf, int idade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.idade = idade;
    }

    // Getters e Setters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getCpf() { return cpf; }
    public int getIdade() { return idade; }
}
