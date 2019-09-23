package br.ufpr.cadastro.pessoa;

public class Autor extends Pessoa {

    public void mostrarInformacoes(){
        System.out.println("\n=-=-= Autor =-=-=-=");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Email: " + this.getEmail());
        System.out.println("CPF: " + this.getCpf());
    }
    
}