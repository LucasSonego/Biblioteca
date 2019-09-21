package br.ufpr.cadastro.livros;
import java.util.Locale;
import java.text.NumberFormat;

class EBooks extends Livros{
    private String formato;
    private Boolean audio, demo;
    private double tamanho;    

    Locale ptBR = new Locale("pt", "BR");
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(ptBR);
    
    @Override
    public void mostrarInformacoes() {
        System.out.println("\n\n=-=-=-=Livro (eBook)=-=-=-=");
        
        System.out.println("Nome: " + this.getNome());
        System.out.println("Descrição: " + this.getDescricao());
        System.out.println("ISBN: " + this.getIsbn());
        System.out.println("Valor: " + numberFormat.format(this.getValor()));
        System.out.println("Formato: " + formato);
        System.out.println("Tamanho: " + tamanho + "MB");
        if(audio == true){
            System.out.println("Audiobook: Disonivel");
        }else{
            System.out.println("Audiobook: Não Disonivel");
        }
        if(demo == true){
            System.out.println("Amostra: Disponivel");
        }else{
            System.out.println("Amostra: Não Disponivel");
        }
        this.autor.mostrarInformacoes();
    }

    public String getFormato() {
        return this.formato;
    }
    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Boolean getAudio() {
        return this.audio;
    }
    public void setAudio(Boolean audio) {
        this.audio = audio;
    }
    
    public Boolean getDemo() {
        return this.demo;
    }
    public void setDemo(Boolean demo) {
        this.demo = demo;
    }

    public double getTamanho() {
        return this.tamanho;
    }
    public void setTamanho(double d) {
        this.tamanho = d;
    }

}