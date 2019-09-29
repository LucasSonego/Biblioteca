package br.ufpr.cadastro.livros;
import br.ufpr.cadastro.pessoa.Autor;
import java.util.Locale;
import java.text.NumberFormat;

class EBook extends Livros{
    private String formato;
    private Boolean audio, amostra;
    private double tamanho;    

    public EBook(Autor autor){
        super(autor);
    }

    public EBook() {
        super();
	}

	Locale ptBR = new Locale("pt", "BR");
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(ptBR);

	@Override
    public void mostrarInformacoes() {
        System.out.println("\n\n=-=-=- Livro (eBook) -=-=-=");
        super.mostrarInformacoes();
        System.out.println("Formato: " + this.formato);
        System.out.println("Tamanho: " + this.tamanho + "MB");
        if(this.audio == true){
            System.out.println("Audiobook: Disonivel");
        }else{
            System.out.println("Audiobook: Não Disonivel");
        }
        if(this.amostra == true){
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
        return this.amostra;
    }
    public void setAmostra(Boolean amostra) {
        this.amostra = amostra;
    }

    public double getTamanho() {
        return this.tamanho;
    }
    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

}