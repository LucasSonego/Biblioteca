package br.ufpr.cadastro.pessoa;

import java.util.ArrayList;
import java.util.Scanner;

public class Autor extends Pessoa {

    private ArrayList<Autor> autores = new ArrayList<Autor>();
    Scanner scan = new Scanner(System.in);

    public void mostrarInformacoes(){
        System.out.println("\n=-=-= Autor =-=-=-=");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Email: " + this.getEmail());
        System.out.println("CPF: " + this.getCpf());
    }

    public void cadastrar(){
        Autor autor = new Autor();
        inserirNome(autor);
        inserirEmail(autor);
        inserirCpf(autor);
        autores.add(autor);
    }

    public void cadastrar(String nome, String email, String cpf){
        Autor novoAutor = new Autor();
        novoAutor.setNome(nome);
        novoAutor.setCpf(cpf);
        novoAutor.setEmail(email);
        autores.add(novoAutor);
    }

    public Autor inserirAutorReturn(){
        Autor autor = new Autor();
        inserirNome(autor);
        inserirEmail(autor);
        inserirCpf(autor);
        autores.add(autor);
        return autor;
    }
    
    public void inserirNome(Autor autor){
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

    public void inserirEmail(Autor autor){
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

    public void inserirCpf(Autor autor){
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
                inputInvalido();
            }
        }
        return autores.get(index - 1);
    }

    public Autor buscar(String nome){
        for(Autor a : autores){
            if(a.getNome() != null && a.getNome().contains(nome)){
                return a;
            }
        }
        return null;
    }

    public void remover(){
        int input;
        boolean inputValido;
        for(inputValido = false; inputValido != true;){
            listarId();
            System.out.println("Que autor você deseja remover?");
            input = scan.nextInt();
            scan.nextLine();
            if(input>0 && input <= autores.size()+1){
                remover(input-1);
                inputValido = true;
            }else{
                inputInvalido();
            }
        }
    }

    public void remover(int index){
        autores.remove(index);
        System.out.println("Autor removido com sucesso");
    }

    public void remover(String nome){
        Autor r = buscar(nome);
        autores.remove(r);
    }

    public void listar(){
        if(autores.size() == 0){
            System.out.println("Não há nanhum autor cadastrado...");
        }else{
            for(Autor a : autores){
                System.out.println(a.getNome());
            }
        }
    }

    public void listarId(){
        if(autores.size() == 0){
            System.out.println("Não há nanhum autor cadastrado...");
        }else{
            int i;
            for(i=0; i < autores.size(); i++){
                System.out.println(i+1 + ": " + autores.get(i).getNome());
            }
        }
    }

    public void listarInformacoes(){
        if(autores.size() == 0){
            System.out.println("Não há nanhum autor cadastrado...");
        }else{
            for(Autor a: autores){
                a.mostrarInformacoes();
            }
        }
    }

    private void inputInvalido(){
        System.out.println("A opção inserida não existe...");
    }

}