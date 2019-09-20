package br.ufpr.cadastro.livros;

public class CadastroLivros{
    public static void main(String[] args) {
        Livros livro1 = new Livros();
        livro1.setNome("Sistemas Operacionais Modernos");
        livro1.setDescricao("A 4ª edição de Sistemas operacionais modernos foi extensamente revisada e atualizada para incorporar os últimos desenvolvimentos em tecnologias de sistemas operacionais. Além de tratar do sistema UNIX, o livro traz como novidade a abordagem do Windows 8 e 8.1, assim como um foco maior em Linux e a introdução da plataforma Android.");
        livro1.setIsbn("978-8543005676");
        livro1.setValor(223.30);
        livro1.autor.setNome("Andrew Stuart Tanenbaum");
        livro1.autor.setEmail("tanenbaum@gmail.com");
        livro1.autor.setCpf("192.168.115.129-24");
        livro1.mostrarInformacoes();

        Livros livro2 = new Livros();
        livro2.setNome("Organização Estruturada de Computadores");
        livro2.setDescricao("Esta sexta edição traz o que há de mais moderno em termos de organização estruturada de computadores, apresentando as terminologias, tecnologias e tendências mais recentes em organização e arquitetura de computadores. Com novos exemplos e discussões sobre x86, microcontroladores AVR e arquitetura ARM, Organização estruturada de computadores é uma obra indispensável para estudantes de ciência da computação, engenharia da computação, análise e desenvolvimento de sistemas e sistemas de informação, bem como para profissionais da área.");
        livro2.setIsbn("978-8581435398");
        livro2.setValor(204.90);
        livro2.autor.setNome("Andrew Stuart Tanenbaum");
        livro2.autor.setEmail("tanenbaum@gmail.com");
        livro2.autor.setCpf("192.168.115.129-24");
        livro2.mostrarInformacoes();

        EBooks livro3 = new EBooks();
        livro3.setNome("Clean Code: A Handbook of Agile Software Craftsmanship");
        livro3.setDescricao("Even bad code can function. But if code isn’t clean, it can bring a development organization to its knees. Every year, countless hours and significant resources are lost because of poorly written code. But it doesn’t have to be that way.");
        livro3.setIsbn("9780132350884");
        livro3.setValor(85.92);
        livro3.setFormato("eBook Kindle");
        livro3.setTamanho(41.903);
        livro3.setAudio(false);
        livro3.setDemo(true);
        livro3.autor.setNome("Robert C. Martin Series");
        livro3.autor.setEmail("refactoring@gmail.com");
        livro3.autor.setCpf("101.001.110.100-01");
        
        livro3.mostrarInformacoes();

        final float maximo = (float) 0.3;
        float reajuste = (float) 0.25;
        if(livro1.reajustarValor(reajuste, maximo) == true){
            System.out.println("Valor reajustado em:" + String.format("%.1f", reajuste*100) + "%");
        }else{
            System.out.println("Não foi possivel reajustar o valor");
            System.out.println("O reajuste inserido excedeu o limite de 30% de reajuste");
        }
    }
}