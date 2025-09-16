package Exercicio3BuscarFilme.entities;

public class Filme {


    private String titulo;
    private String genero;
    private int ano;

    public Filme(String titulo, String genero, int ano) {
        this.titulo = titulo;
        this.genero = genero;
        this.ano = ano;
    }

    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public int getAno() { return ano; }


    @Override
    public String toString() {
        return "Filme{" +
                "título='" + titulo + '\'' +
                ", gênero='" + genero + '\'' +
                ", ano=" + ano +
                '}';
    }

}
