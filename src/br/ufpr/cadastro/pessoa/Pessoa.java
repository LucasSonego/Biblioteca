package br.ufpr.cadastro.pessoa;

public class Pessoa {
    private String nome;
    private String email;
    private String cpf;
    private String idade;
    private String endereço;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdade() {
        return this.idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getEndereçO() {
        return this.endereço;
    }

    public void setEndereçO(String endereço) {
        this.endereço = endereço;
    }      
}