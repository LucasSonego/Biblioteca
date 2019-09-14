package livros;

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

        Livros livro3 = new Livros();
        livro3.setNome("Cacildis Birits Forevis");
        livro3.setDescricao("Mussum Ipsum, cacilds vidis litro abertis. Quem num gosta di mé, boa gentis num é. Mais vale um bebadis conhecidiss, que um alcoolatra anonimis. Todo mundo vê os porris que eu tomo, mas ninguém vê os tombis que eu levo! A ordem dos tratores não altera o pão duris.");
        livro3.setIsbn("051-5151515151");
        livro3.setValor(51.51);
        livro3.autor.setNome("Mussum");
        livro3.autor.setEmail("cacildis@gmail.com");
        livro3.autor.setCpf("1051.051.051.051-51");
        livro3.mostrarInformacoes();
    }
}