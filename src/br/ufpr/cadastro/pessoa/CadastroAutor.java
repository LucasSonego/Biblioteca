package br.ufpr.cadastro.pessoa;

import java.util.ArrayList;

public class CadastroAutor {
    private ArrayList<Autor> autores = new ArrayList<Autor>();
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
}