package br.ufpr.cadastro.livros;

import br.ufpr.cadastro.pessoa.Autor;
import java.util.Locale;
import java.text.NumberFormat;

public class Livros{
    private String nome;
    private String descricao;
    private String isbn10;
    private String isbn13;
    private double valor;

    Locale ptBR = new Locale("pt", "BR");
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(ptBR);

    /*public*/ Autor autor = new Autor();
    public void mostrarInformacoes(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Descrição: "+ this.descricao);
        System.out.println("ISBN-10: " + this.isbn10);
        System.out.println("ISBN-13: " + this.isbn13);
        System.out.println("Valor: " + numberFormat.format(this.getValor()));
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

    public String getIsbn10() {
        return this.isbn10;
    }
    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return this.isbn13;
    }
    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
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