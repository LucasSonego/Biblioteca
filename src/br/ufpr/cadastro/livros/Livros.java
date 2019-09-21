package br.ufpr.cadastro.livros;

import br.ufpr.cadastro.pessoa.Autor;
import java.util.Locale;
import java.text.NumberFormat;

public class Livros{
    private String nome,descricao,isbn;
    private double valor;

    Locale ptBR = new Locale("pt", "BR");
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(ptBR);

    /*public*/ Autor autor = new Autor();
    public void mostrarInformacoes(){
        System.out.println("\n\n=-=-=-=Livro=-=-=-=");
        
        System.out.println("Nome: " + this.nome);
        System.out.println("Descrição: "+ this.descricao);
        System.out.println("ISBN: " + this.isbn);
        System.out.println("Valor: " + numberFormat.format(this.getValor()));
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

    public boolean reajustarValor(float reajuste, float maximo){
        if(reajuste <= maximo){
            this.setValor(valor+= valor*reajuste);
            return true;
            
        }else{
            return false;
        }
    }
}