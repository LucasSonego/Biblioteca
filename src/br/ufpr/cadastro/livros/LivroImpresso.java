package br.ufpr.cadastro.livros;

import br.ufpr.cadastro.pessoa.Autor;

public class LivroImpresso extends Livros {
    private String capa;
    private String peso;
    private String dimensoes;

    public LivroImpresso(Autor autor) {
        super(autor);
	}

	public LivroImpresso() {
        super();
	}

	@Override
    public void mostrarInformacoes() {
        System.out.println("\n\n=-=-=-=-=- Livro -=-=-=-=-=");
        super.mostrarInformacoes();
        System.out.println("Tipo de capa: " + this.getCapa());
        System.out.println("Dimensoes: " + this.getDimensoes());
        System.out.println("Peso: " + this.getPeso());
        this.autor.mostrarInformacoes();
    }

    public String getCapa() {
        return this.capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public String getPeso() {
        return this.peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getDimensoes() {
        return this.dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }
    
}