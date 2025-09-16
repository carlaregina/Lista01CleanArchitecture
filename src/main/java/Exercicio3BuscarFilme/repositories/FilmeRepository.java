package Exercicio3BuscarFilme.repositories;

import Exercicio3BuscarFilme.entities.Filme;

public interface FilmeRepository {

    Filme buscarPorTitulo(String titulo);

}
