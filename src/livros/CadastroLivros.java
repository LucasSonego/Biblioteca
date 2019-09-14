package livros;

public class CadastroLivros{
    public static void main(String[] args) {
        Livros livro1 = new Livros();
        livro1.nome = "Sistemas Operacionais Modernos";
        livro1.descricao = "A 4ª edição de Sistemas operacionais modernos foi extensamente revisada e atualizada para incorporar os últimos desenvolvimentos em tecnologias de sistemas operacionais. Além de tratar do sistema UNIX, o livro traz como novidade a abordagem do Windows 8 e 8.1, assim como um foco maior em Linux e a introdução da plataforma Android.";
        livro1.isbn = "978-8543005676";
        livro1.valor = 223.30;
        livro1.autor.nome = "Andrew Stuart Tanenbaum";
        livro1.autor.email = "tanenbaun@gmail.com";
        livro1.autor.cpf = "192.168.115.129-24";
        livro1.mostrarInformacoes();

        Livros livro2 = new Livros();
        livro2.nome = "Organização Estruturada de Computadores";
        livro2.descricao = "Esta sexta edição traz o que há de mais moderno em termos de organização estruturada de computadores, apresentando as terminologias, tecnologias e tendências mais recentes em organização e arquitetura de computadores. Com novos exemplos e discussões sobre x86, microcontroladores AVR e arquitetura ARM, Organização estruturada de computadores é uma obra indispensável para estudantes de ciência da computação, engenharia da computação, análise e desenvolvimento de sistemas e sistemas de informação, bem como para profissionais da área.";
        livro2.isbn = "978-8581435398";
        livro2.valor = 204.90;
        livro2.autor.nome = "Andrew Stuart Tanenbaum";
        livro2.autor.email = "tanenbaun@gmail.com";
        livro2.autor.cpf = "192.168.115.129-24";
        livro2.mostrarInformacoes();

        Livros livro3 = new Livros();
        livro3.nome = "Cacildis Birits Forevis";
        livro3.descricao = "Mussum Ipsum, cacilds vidis litro abertis. Quem num gosta di mé, boa gentis num é. Mais vale um bebadis conhecidiss, que um alcoolatra anonimis. Todo mundo vê os porris que eu tomo, mas ninguém vê os tombis que eu levo! A ordem dos tratores não altera o pão duris.";
        livro3.isbn = "051-5151515151";
        livro3.valor = 51.00;
        livro3.autor.nome = "Mussum";
        livro3.autor.email = "cacildis@gmail.com";
        livro3.autor.cpf = "051.051.051.051-51";
        livro3.mostrarInformacoes();
    }
}