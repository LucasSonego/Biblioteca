package br.ufpr.cadastro.livros;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.text.NumberFormat;
import br.ufpr.cadastro.pessoa.Autor;

public class CadastroLivros{
    Scanner scan = new Scanner(System.in);

    ArrayList<Livros> livros = new ArrayList<Livros>();
    public Autor autores = new Autor();
    
    static Locale ptBR = new Locale("pt", "BR");
    static NumberFormat numberFormat = NumberFormat.getCurrencyInstance(ptBR);
    
    public void cadastrar(){
        int input;
        boolean inputValido;
        for(inputValido = false; inputValido != true;){
            System.out.println("\n 1: Livro Impresso\n 2: EBook");
            input = this.scan.nextInt();
            scan.nextLine();
            if(input == 1 || input == 2){
                inputValido = true;
                if(input == 1){
                    LivroImpresso livro = new LivroImpresso();
                    inserirCamposLivro(livro);
                    inserirCamposImpresso(livro);
                    inserirCamposAutor(livro);
                    livros.add(livro);
                }else if(input == 2){
                    EBook livro = new EBook();
                    inserirCamposLivro(livro);
                    inserirCamposEBook(livro);
                    inserirCamposAutor(livro);
                    livros.add(livro);
                }
            }else{
                inputInvalido();
            }
        }
    }

    public void cadastrar(String nome, String descricao, String isbn10, String isbn13, double valor, String capa, String dimensoes, String peso, Autor autor){
        LivroImpresso livro = new LivroImpresso(autor);
        livro.setNome(nome);
        livro.setDescricao(descricao);
        livro.setIsbn10(isbn10);
        livro.setIsbn13(isbn13);
        livro.setValor(valor);
        livro.setCapa(capa);
        livro.setDimensoes(dimensoes);
        livro.setPeso(peso);
        livros.add(livro);
    }

    public void cadastrar(String nome, String descricao, String isbn10, String isbn13, double valor, String formato, double tamanho, boolean audio, boolean amostra, Autor autor){
        EBook livro = new EBook(autor);
        livro.setNome(nome);
        livro.setDescricao(descricao);
        livro.setIsbn10(isbn10);
        livro.setIsbn13(isbn13);
        livro.setValor(valor);
        livro.setTamanho(tamanho);
        livro.setFormato(formato);
        livro.setAudio(audio);
        livro.setAmostra(amostra);
        livros.add(livro);
    }

    public Livros buscar(String nome){
        for(Livros l : livros){
            if(l.getNome() != null && l.getNome().equalsIgnoreCase(nome)){
                return l;
            }
        }
        return null;
    }

    public void remover(){
        int input;
        boolean inputValido;
        for(inputValido = false; inputValido != true;){
            listarId();
            System.out.println("Que livro você deseja remover?");
            input = scan.nextInt();
            scan.nextLine();
            if(input>0 && input <= livros.size()+1){
                remover(input-1);
                inputValido = true;
            }
        }
    }

    public void remover(int index){
        livros.remove(index);
        System.out.println("Livro removido com sucesso");
    }

    public void remover(String nome){
        Livros l = buscar(nome);
        livros.remove(l);
    }

    public void listar(){
        if(livros.size() == 0){
            System.out.println("Não há nanhum livro cadastrado...");
        }else{
            for(Livros l : livros){
                System.out.println(l.getNome());
            }
        }  
    }

    public void listarId(){
        int i;
        if(livros.size() == 0){
            System.out.println("Não há nanhum livro cadastrado...");
        }else{
            for(i=0; i < livros.size(); i++){
                System.out.println(i+1 + ": " + livros.get(i).getNome());
            }
        }
        
    }

    public void listarInformacoes(){
        if(livros.size() == 0){
            System.out.println("Não há nanhum livro cadastrado...");
        }else{
            for(Livros l : livros){
                l.mostrarInformacoes();
            }
        }
    }

    public void reajustar(){
        boolean inputValido;
        for(inputValido = false; inputValido != true;){
            System.out.println("1: Aplicar reajuste para todos os livros\n"+
            "2: Aplicar reajuste para um livro");
            int input = scan.nextInt();
            scan.nextLine();
            float limiteDeReajuste = (float)0.3;
            if(input == 1){
                System.out.println("Qual o valor do reajuste? (%)");
                float reajuste = scan.nextFloat();
                for(Livros l: livros){
                    reajustar(l, reajuste/100, limiteDeReajuste);
                }
                inputValido = true;
            }else if(input == 2){   
                boolean inputValido2;
                for(inputValido2 = false; inputValido2 != true;){
                    System.out.println("Qual o livro que você deseja reajustar o valor?");
                    listarId();
                    input = scan.nextInt();
                    scan.nextLine();
                    if(input > 0 && input <= livros.size()+1){
                        System.out.println("Qual o valor do reajuste? (%)");
                        float reajuste = scan.nextFloat();
                        reajustar(livros.get(input-1), reajuste/100, limiteDeReajuste);
                        inputValido2 = true;
                    }
                }
                inputValido = true;
            }else{
                inputInvalido();
            }
        }
    }

    public void reajustar(Livros livro, float reajuste, float limite){
        double valor = livro.getValor();
        System.out.println("\nReajustando o valor do livro " + livro.getNome() + "...\n");
        if(livro.reajustarValor(reajuste, limite) == true){
            System.out.println("Valor reajustado em: "
             + String.format("%.1f", reajuste*100) + "%");
            System.out.println(numberFormat.format(valor)+ " -> " + numberFormat.format(livro.getValor()));
        }else{
            System.out.println("Não foi possivel reajustar o valor");
            System.out.println("O reajuste inserido excedeu o limite de "
             + String.format("%.2f", limite*100) + "% de reajuste");
        }
    }   

    private void inserirCamposLivro(Livros livro){
        inserirNome(livro);
        inserirDescricao(livro);
        inserirIsbn10(livro);
        inserirIsbn13(livro);
        inserirValor(livro);
    }

    private void inserirCamposImpresso(LivroImpresso livro){
        inserirCapa(livro); 
        inserirDimensoes(livro);
        inserirPeso(livro);
    }

    private void inserirCamposEBook(EBook livro){
        inserirTamanho(livro);
        inserirFormato(livro);
        inserirAudiobook(livro);
        inserirAmostra(livro);
    }

    private void inserirCamposAutor(Livros livro){
        boolean inputValido;
        int input;
        
        for(inputValido = false; inputValido != true;){
            System.out.println("1: Inserir dados de autor\n2: Buscar autor já cadastrado");
            input = scan.nextInt();
            scan.nextLine();
            if(input == 1){
                System.out.println("Insira os seguintes dados do autor:");
                livro.setAutor(autores.inserirAutorReturn());
                inputValido = true;
            }else if(input == 2){
                livro.setAutor(autores.selecionarAutor());
                if(livro.getAutor() != null){
                    inputValido = true;
                }
            }else{
                inputInvalido();
            }
        }
    }

    private void inserirNome(Livros livro){
        boolean inputValido;
        for(inputValido = false; inputValido != true;){
            System.out.println("\nNome: ");
            String nome = scan.nextLine();
            livro.setNome(nome);
            if(nome != ""){
                inputValido = true;
                livro.setNome(nome);
            }
        }
    }

    private void inserirDescricao(Livros livro){
        boolean inputValido;
        for(inputValido = false; inputValido != true;){
            System.out.println("\nDescricão: ");
            String descricao = scan.nextLine();
            if(descricao != ""){
                inputValido = true;
                livro.setDescricao(descricao);
            }
        }
    }

    private void inserirIsbn10(Livros livro){
        boolean inputValido;
        for(inputValido = false; inputValido != true;){
            System.out.println("\nISBN-10: ");
            String isbn10 = scan.nextLine();
            if(isbn10 != ""){
                inputValido = true;
                livro.setIsbn10(isbn10);
            }
        }
    }

    private void inserirIsbn13(Livros livro){
        boolean inputValido;
        for(inputValido = false; inputValido != true;){
            System.out.println("\nISBN-13: ");
            String isbn13 = scan.nextLine();
            if(isbn13 != ""){
                inputValido = true;
                livro.setIsbn13(isbn13);
            }
        }
    }

    private void inserirValor(Livros livro){
        boolean inputValido;       
        for(inputValido = false; inputValido != true;){
            System.out.println("\nValor: ");
            double valor = scan.nextDouble();
            scan.nextLine();
            inputValido = true;
            livro.setValor(valor);
        }
    }

    private void inserirCapa(LivroImpresso livro){
        boolean inputValido;
        for(inputValido = false; inputValido != true;){
            System.out.println("\nTipo de capa: ");
            String capa = scan.nextLine();
            if(capa != ""){
                inputValido = true;
                livro.setCapa(capa);
            }
        }
    }

    private void inserirDimensoes(LivroImpresso livro){
        boolean inputValido;
        for(inputValido = false; inputValido != true;){
            System.out.println("\nDimensoes: ");
            String dimensoes = scan.nextLine();
            if(dimensoes != ""){
                inputValido = true;
                livro.setDimensoes(dimensoes);
            }
        }
    }

    private void inserirPeso(LivroImpresso livro){
        boolean inputValido;
        for(inputValido = false; inputValido != true;){
            System.out.println("\nPeso: ");
            String peso = scan.nextLine();
            if(peso != ""){
                inputValido = true;
                livro.setPeso(peso);
            }
        }
    }

    private void inserirTamanho(EBook livro){
        boolean inputValido;
        for(inputValido = false; inputValido != true;){
            System.out.println("\nTamanho: ");
            double tamanho = scan.nextDouble();
            scan.nextLine();
            inputValido = true;
            livro.setTamanho(tamanho);
        }
    }

    private void inserirFormato(EBook livro){
        boolean inputValido;
        for(inputValido = false; inputValido != true;){
            System.out.println("\nFormato: ");
            String formato = scan.nextLine();
            if(formato != ""){
                inputValido = true;
                livro.setFormato(formato);
            }
        }
    }

    private void inserirAudiobook(EBook livro){
        boolean inputValido;
        for(inputValido = false; inputValido != true;){
            System.out.println("\nAudiobook disponivel?\nS: Disponivel\nN: Não disponivel");
            char audio = scan.next().charAt(0);
            if(audio == 's' || audio == 'S'){
                inputValido = true;
                livro.setAudio(true);
            }else if(audio == 'n' || audio == 'N'){
                inputValido = true;
                livro.setAudio(false);
            }else{
                inputInvalido();
            }
            System.out.println(inputValido);
        }
    }

    private void inserirAmostra(EBook livro){
        boolean inputValido;
        for(inputValido = false; inputValido != true;){
            System.out.println("\nAmostra disponivel?\nS: Disponivel\nN: Não disponivel");
            char amostra = scan.next().charAt(0);
            if(amostra == 's' || amostra == 'S'){
                inputValido = true;
                livro.setAmostra(true);
            }else if(amostra == 'n' || amostra == 'N'){
                inputValido = true;
                livro.setAmostra(false);
            }else{
                inputInvalido();
            }
        }
    }

    private void inputInvalido(){
        System.out.println("A opção inserida não existe...");
    }
}