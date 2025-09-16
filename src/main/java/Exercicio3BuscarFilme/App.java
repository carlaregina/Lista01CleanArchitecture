package Exercicio3BuscarFilme;

import Exercicio3BuscarFilme.entities.Filme;
import Exercicio3BuscarFilme.exceptions.FilmeNaoEncontradoException;
import Exercicio3BuscarFilme.infra.InMemoryFilme;
import Exercicio3BuscarFilme.usecases.BuscarFilmePorTituloUseCase;

public class App {

    public static void main(String[] args) {
        BuscarFilmePorTituloUseCase buscarFilme = new BuscarFilmePorTituloUseCase(new InMemoryFilme());

        try {
            Filme filme = buscarFilme.executar("Matrix");
            System.out.println("Filme encontrado: " + filme);
        } catch (FilmeNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        try {
            Filme filme = buscarFilme.executar("Avatar");
            System.out.println("Filme encontrado: " + filme);
        } catch (FilmeNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

}
