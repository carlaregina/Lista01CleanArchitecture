package Exercicio3BuscarFilme.infra;

import Exercicio3BuscarFilme.entities.Filme;
import Exercicio3BuscarFilme.repositories.FilmeRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryFilme implements FilmeRepository {


    private final List<Filme> filmes = new ArrayList<>();

    public InMemoryFilme() {
        filmes.add(new Filme("Matrix", "Ficção Científica", 1999));
        filmes.add(new Filme("O Poderoso Chefão", "Drama", 1972));
        filmes.add(new Filme("Interestelar", "Ficção Científica", 2014));
    }

    @Override
    public Filme buscarPorTitulo(String titulo) {
        return filmes.stream()
                .filter(f -> f.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

}
