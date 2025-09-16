package Exercicio3BuscarFilme.exceptions;

public class FilmeNaoEncontradoException extends RuntimeException{

    public FilmeNaoEncontradoException(String titulo) {
        super("Filme com título '" + titulo + "' não encontrado.");
    }

}
