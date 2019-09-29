package br.ufpr.cadastro.pessoa;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastroAutor {
    private ArrayList<Autor> autores = new ArrayList<Autor>();
    Scanner scan = new Scanner(System.in);

    public void inserirAutor(){
        Autor autor = new Autor();
        inserirNome(autor);
        inserirEmail(autor);
        inserirCpf(autor);
        autores.add(autor);
    }

    public Autor inserirAutorReturn(){
        Autor autor = new Autor();
        inserirNome(autor);
        inserirEmail(autor);
        inserirCpf(autor);
        autores.add(autor);
        return autor;
    }
    
    private void inserirNome(Autor autor){
        boolean inputValido;
        for(inputValido = false; inputValido != true;){
            System.out.println("Nome: ");
            String nome = scan.nextLine();
            if(nome != ""){
                inputValido = true;
                autor.setNome(nome);
            }
        }
    }

    private void inserirEmail(Autor autor){
        boolean inputValido;
        for(inputValido = false; inputValido != true;){
            System.out.println("Email: ");
            String email = scan.nextLine();
            if(email != ""){
                inputValido = true;
                autor.setEmail(email);
            }
        }
    }

    private void inserirCpf(Autor autor){
        boolean inputValido;
        for(inputValido = false; inputValido != true;){
            System.out.println("CPF: ");
            String cpf = scan.nextLine();
            if(cpf != ""){
                inputValido = true;
                autor.setCpf(cpf);
            }
        }
    }
    
    public Autor selecionarAutor(){
        listarId();
        int index = 0;
        boolean inputValido;
        for(inputValido = false; inputValido != true;){
            index = scan.nextInt();
            scan.nextLine();
            if(index > 0 && index <= autores.size()){
                inputValido = true;
            }else{
                listarId();
                System.out.println("Insira uma opção válida");
            }
        }
        return autores.get(index - 1);
    }

    public void cadastrar(String nome, String cpf, String email){
        Autor novoAutor = new Autor();
        novoAutor.setNome(nome);
        novoAutor.setCpf(cpf);
        novoAutor.setEmail(email);
        autores.add(novoAutor);
    }

    public Autor buscar(String nome){
        for(Autor a : autores){
            if(a.getNome() != null && a.getNome().contains(nome)){
                return a;
            }
        }
        return null;
    }

    public void remover(String nome){
        Autor r = buscar(nome);
        autores.remove(r);
    }

    public void listar(){
        for(Autor a : autores){
            System.out.println(a.getNome());
        }
    }

    public void listarId(){
        int i;
        for(i=0; i < autores.size(); i++){
            System.out.println(i+1 + ": " + autores.get(i).getNome());
        }
    }
}