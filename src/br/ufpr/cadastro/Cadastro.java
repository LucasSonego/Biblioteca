package br.ufpr.cadastro;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;

import br.ufpr.cadastro.livros.CadastroLivros;

public class Cadastro {
    static CadastroLivros livros = new CadastroLivros();

    public static void main(String[] args) {
        
        exemplos(livros);
        menu(livros);
        livros.cadastrar();
        
        livros.listarInformacoes();

        System.out.println("\n");
        livros.autores.listarId();
    }

    static void exibirOpcoes(){
        dataEHora();
        System.out.println("\n"+
        "==================================\n"+
        "1: Listar Livros\n"+
        "2: Listar Autores\n"+
        "3: Cadastrar um livro\n"+
        "4: Cadastrar um autor\n"+
        "5: Reajustar preços\n"+
        "6: Sair\n"+
        "==================================\n");
    }

    static void menu(CadastroLivros livros){
        while(true){
            exibirOpcoes();
            int escolha = 0;
            boolean inputValido = false;
            for(inputValido = false; inputValido != true;){
                Scanner scan = new Scanner(System.in);
                escolha = scan.nextInt();
                scan.nextLine();
                if(escolha > 0 && escolha <= 6){
                    inputValido = true;
                }else{
                    inputInvalido();
                    exibirOpcoes();
                }
            }
            
            switch(escolha){
                case 1:
                    livros.listar();
                    break;
                case 2:
                    livros.autores.listar();
                    break;
                case 3:
                    livros.cadastrar();
                    break;
                case 4:
                    livros.autores.cadastrar();
                    break;
                case 5:
                    livros.reajustar();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.err.println("Há algo de errado que não está certo");
                    menu(livros);
            }
            hold();
        }
    }

    static void hold(){
        System.out.println("\nPressione qualquer tecla para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {}
    }

    static void dataEHora(){
        Calendar horaAtual = Calendar.getInstance(TimeZone.getTimeZone("Brazil/East"));
        SimpleDateFormat formatoDeHoras = new SimpleDateFormat("hh:mm:ss");
        String hora = formatoDeHoras.format(horaAtual.getTime());
        
        Locale ptBR = new Locale("pt", "BR");
        DateFormat formatoDeData = DateFormat.getDateInstance(DateFormat.FULL, ptBR);
        String data = formatoDeData.format(new Date());
        
        System.out.println(data + "\n" + hora);
    }

    static void exemplos(CadastroLivros livros){
        livros.autores.cadastrar("Andrew Stuart Tanenbaum", "192.168.115.129-24", "tanenbaum@gmail.com");
        livros.autores.cadastrar("Robert Cecil Martin", "101.001.110.100-01", "refactoring@gmail.com");

        livros.cadastrar(
            "Sistemas Operacionais Modernos", 
            "A 4ª edição de Sistemas operacionais modernos foi extensamente revisada e atualizada para incorporar os últimos desenvolvimentos em tecnologias de sistemas operacionais.", 
            "8543005671", 
            "978-8543005676", 
            223.30, 
            "Comum", 
            "17,9 x 2,9 x 23,4 cm", 
            "1,7 Kg", 
            livros.autores.buscar("Andrew Stuart Tanenbaum")
        );

        livros.cadastrar(
            "Clean Code: A Handbook of Agile Software Craftsmanship", 
            "Even bad code can function. But if code isn’t clean, it can bring a development organization to its knees. Every year, countless hours and significant resources are lost because of poorly written code. But it doesn’t have to be that way.",
            "9780132350884", 
            "978-0132350884", 
            85.92, 
            "eBook Kindle", 
            41.903, 
            false, 
            true, 
            livros.autores.buscar("Robert Cecil Martin")
        );
    }

    static void inputInvalido(){
        System.out.println("A opção inserida não existe...");
    }
}