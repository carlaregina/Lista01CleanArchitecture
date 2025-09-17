package Exercicio4Test;

import Execicio4ReservasQuarto.entities.Quarto;
import Execicio4ReservasQuarto.infra.InMemoryQuarto;
import Execicio4ReservasQuarto.usecases.CadastrarQuartoUseCase;
import Execicio4ReservasQuarto.usecases.ListarQuartosUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListarQuartosUseCaseTest {


    private InMemoryQuarto repo;
    private CadastrarQuartoUseCase cadastrar;
    private ListarQuartosUseCase listar;

    @BeforeEach
    void setUp() {
        repo = new InMemoryQuarto();
        cadastrar = new CadastrarQuartoUseCase(repo);
        listar = new ListarQuartosUseCase(repo);
    }

    @Test
    void deveListarTodosOsQuartosCadastrados() {
        cadastrar.executar(101, "Solteiro");
        cadastrar.executar(102, "Casal");

        List<Quarto> quartos = listar.executar();
        assertEquals(2, quartos.size());
    }

}
