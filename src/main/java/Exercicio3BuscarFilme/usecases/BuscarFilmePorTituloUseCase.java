package Exercicio3BuscarFilme.usecases;

import Exercicio3BuscarFilme.entities.Filme;
import Exercicio3BuscarFilme.exceptions.FilmeNaoEncontradoException;
import Exercicio3BuscarFilme.repositories.FilmeRepository;

public class BuscarFilmePorTituloUseCase {


    private final FilmeRepository repository;

    public BuscarFilmePorTituloUseCase(FilmeRepository repository) {
        this.repository = repository;
    }

    public Filme executar(String titulo) {
        Filme filme = repository.buscarPorTitulo(titulo);
        if (filme == null) {
            throw new FilmeNaoEncontradoException(titulo);
        }
        return filme;
    }

}
