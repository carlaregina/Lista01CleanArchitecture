package Exercicio3Test;

import Exercicio3BuscarFilme.entities.Filme;
import Exercicio3BuscarFilme.exceptions.FilmeNaoEncontradoException;
import Exercicio3BuscarFilme.infra.InMemoryFilme;
import Exercicio3BuscarFilme.usecases.BuscarFilmePorTituloUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BuscarFilmePorTituloUseCaseTest {


    private InMemoryFilme repo;
    private BuscarFilmePorTituloUseCase buscar;

    @BeforeEach
    void setUp() {
        repo = new InMemoryFilme();
        buscar = new BuscarFilmePorTituloUseCase(repo);
    }

    @Test
    void deveEncontrarFilmeExistente() {
        Filme filme = buscar.executar("Matrix");

        assertNotNull(filme, "O filme 'Matrix' deveria existir no repositório em memória.");
        assertEquals("Matrix", filme.getTitulo());

    }

    @Test
    void deveLancarExcecaoQuandoFilmeNaoExistir() {
        assertThrows(FilmeNaoEncontradoException.class, () -> buscar.executar("Avatar"));
    }

    @Test
    void deveLancarExcecaoParaTituloNuloOuVazio_ComportamentoAtual() {

        assertThrows(FilmeNaoEncontradoException.class, () -> buscar.executar(null));
        assertThrows(FilmeNaoEncontradoException.class, () -> buscar.executar(""));
        assertThrows(FilmeNaoEncontradoException.class, () -> buscar.executar("   "));
    }


}
