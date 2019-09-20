package br.ufpr.cadastro.livros;

import br.ufpr.cadastro.pessoa.Autor;

public class Livros{
    private String nome,descricao,isbn;
    private double valor;

    /*public*/ Autor autor = new Autor();
    public void mostrarInformacoes(){
        System.out.println("\n\n=-=-=-=Livro=-=-=-=");
        
        System.out.println("Nome: " + this.nome);
        System.out.println("Descrição: "+ this.descricao);
        System.out.println("ISBN: " + this.isbn);
        System.out.println("Valor: " + String.format("%.2f", this.valor));
        this.autor.mostrarInformacoes();
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIsbn() {
        return this.isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getValor() {
        return this.valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public void reajustarValor(float reajuste){
        if(reajuste < .3){
            this.setValor(valor+= valor*reajuste);
            System.out.println("Valor reajustado em:" + String.format("%.1f", reajuste*100) + "%");
        }else{
            System.out.println("Não foi possivel reajustar o valor");
            System.out.println("O reajuste inserido excedeu o limite de 30% de reajuste");
        }
    }
}