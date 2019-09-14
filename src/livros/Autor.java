package livros;

public class Autor {
    public String nome,email,cpf;

    public void mostrarInformacoes(){
        System.out.println("\n=-=-=Autor=-=-=-=");
        System.out.println("Nome: " + this.nome);
        System.out.println("Email: " + this.email);
        System.out.println("CPF: " + this.cpf);
    }
}