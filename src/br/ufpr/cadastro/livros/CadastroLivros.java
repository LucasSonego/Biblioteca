package br.ufpr.cadastro.livros;

import java.util.ArrayList;
import java.util.Locale;
import java.text.NumberFormat;
import br.ufpr.cadastro.pessoa.CadastroAutor;

public class CadastroLivros{

    static Locale ptBR = new Locale("pt", "BR");
    static NumberFormat numberFormat = NumberFormat.getCurrencyInstance(ptBR);
    public static void main(String[] args) {
        ArrayList<Livros> livros = new ArrayList<Livros>();
        CadastroAutor autores = new CadastroAutor();
        
        autores.cadastrar("Andrew Stuart Tanenbaum", "192.168.115.129-24", "tanenbaum@gmail.com");
        autores.cadastrar("Robert Cecil Martin", "101.001.110.100-01", "refactoring@gmail.com");

        LivroImpresso livro1 = new LivroImpresso(autores.buscar("Andrew Stuart Tanenbaum"));
        livro1.setNome("Sistemas Operacionais Modernos");
        livro1.setDescricao("A 4ª edição de Sistemas operacionais modernos foi extensamente revisada e atualizada para incorporar os últimos desenvolvimentos em tecnologias de sistemas operacionais. Além de tratar do sistema UNIX, o livro traz como novidade a abordagem do Windows 8 e 8.1, assim como um foco maior em Linux e a introdução da plataforma Android.");
        livro1.setIsbn10("8543005671");
        livro1.setIsbn13("978-8543005676");
        livro1.setValor(223.30);
        livro1.setCapa("Comum");
        livro1.setDimensoes("17,9 x 2,9 x 23,4 cm");
        livro1.setPeso("1,7 Kg");
        livros.add(livro1);

        LivroImpresso livro2 = new LivroImpresso(autores.buscar("Andrew Stuart Tanenbaum"));
        livro2.setNome("Organização Estruturada de Computadores");
        livro2.setDescricao("Esta sexta edição traz o que há de mais moderno em termos de organização estruturada de computadores, apresentando as terminologias, tecnologias e tendências mais recentes em organização e arquitetura de computadores. Com novos exemplos e discussões sobre x86, microcontroladores AVR e arquitetura ARM, Organização estruturada de computadores é uma obra indispensável para estudantes de ciência da computação, engenharia da computação, análise e desenvolvimento de sistemas e sistemas de informação, bem como para profissionais da área.");
        livro2.setIsbn10("8581435394");
        livro2.setIsbn13("978-8581435398");
        livro2.setValor(204.90);
        livro2.setCapa("Comum");
        livro2.setDimensoes("27,4 x 20,6 x 3,2 cm");
        livro2.setPeso("1,4 Kg");
        livros.add(livro2);

        EBook livro3 = new EBook(autores.buscar("Robert Cecil Martin"));
        livro3.setNome("Clean Code: A Handbook of Agile Software Craftsmanship");
        livro3.setDescricao("Even bad code can function. But if code isn’t clean, it can bring a development organization to its knees. Every year, countless hours and significant resources are lost because of poorly written code. But it doesn’t have to be that way.");
        livro3.setIsbn10("9780132350884");
        livro3.setIsbn13("978-0132350884");
        livro3.setValor(85.92);
        livro3.setFormato("eBook Kindle");
        livro3.setTamanho(41.903);
        livro3.setAudio(false);
        livro3.setDemo(true);
        livros.add(livro3);

        livros.forEach(l -> l.mostrarInformacoes());

        final float maximo = (float) 0.3;
        float reajuste = (float) 0.25;
        float reajuste2 = (float) 0.35;
        reajustar(livros.get(0), reajuste, maximo);
        reajustar(livros.get(2), reajuste2, maximo);
    }
    
    public static void reajustar(Livros livro, float reajuste, float maximo){
        double valor = livro.getValor();
        System.out.println("\nReajustando o valor do livro " + livro.getNome() + "...\n");
        if(livro.reajustarValor(reajuste, maximo) == true){
            System.out.println("Valor reajustado em: " + String.format("%.1f", reajuste*100) + "%");
            System.out.println(numberFormat.format(valor)+ " -> " + numberFormat.format(livro.getValor()));
        }else{
            System.out.println("Não foi possivel reajustar o valor");
            System.out.println("O reajuste inserido excedeu o limite de " + String.format("%.2f", maximo*100) + "% de reajuste");
        }
    }
}