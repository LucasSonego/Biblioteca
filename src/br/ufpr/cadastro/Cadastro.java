package br.ufpr.cadastro;

import br.ufpr.cadastro.livros.CadastroLivros;

public class Cadastro {
    public static void main(String[] args) {
        CadastroLivros livros = new CadastroLivros();
        
        livros.autores.cadastrar("Andrew Stuart Tanenbaum", "192.168.115.129-24", "tanenbaum@gmail.com");
        livros.autores.cadastrar("Robert Cecil Martin", "101.001.110.100-01", "refactoring@gmail.com");

        livros.cadastrar(
            "Sistemas Operacionais Modernos", 
            "A 4ª edição de Sistemas operacionais modernos foi extensamente revisada e atualizada para incorporar os últimos desenvolvimentos em tecnologias de sistemas operacionais.", "8543005671", 
            "978-8543005676", 
            223.30, 
            "Comum", 
            "17,9 x 2,9 x 23,4 cm", 
            "1,7 Kg", 
            livros.autores.buscar("Andrew Stuart Tanenbaum")
        );

        livros.cadastrar(
            "Clean Code: A Handbook of Agile Software Craftsmanship", 
            "Even bad code can function. But if code isn’t clean, it can bring a development organization to its knees. Every year, countless hours and significant resources are lost because of poorly written code. But it doesn’t have to be that way.",
            "9780132350884", 
            "978-0132350884", 
            85.92, 
            "eBook Kindle", 
            41.903, 
            false, 
            true, 
            livros.autores.buscar("Robert Cecil Martin")
        );

        livros.cadastrar();
        
        livros.listarInformacoes();

        System.out.println("\n");
        livros.autores.listarId();
    }
}