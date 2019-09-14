package livros;

public class Livros{
    public String nome,descricao,isbn;
    public double valor;

    /*public*/ Autor autor = new Autor();

    public void mostrarInformacoes(){
        System.out.println("\n\n=-=-=-=Livro=-=-=-=");
        
        System.out.println("Nome: " + this.nome);
        System.out.println("Descrição: "+ this.descricao);
        System.out.println("ISBN: " + this.isbn);
        this.getValor();
        this.autor.mostrarInformacoes();
    }

    public double getValor() {
        return this.valor;
    }
    public void setValor(double valor) {
        this.mostrarInformacoes();
        this.valor = valor;
        this.mostrarInformacoes();
    }
}