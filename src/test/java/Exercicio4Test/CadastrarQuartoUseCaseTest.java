package Exercicio4Test;

import Execicio4ReservasQuarto.entities.Quarto;
import Execicio4ReservasQuarto.infra.InMemoryQuarto;
import Execicio4ReservasQuarto.usecases.CadastrarQuartoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CadastrarQuartoUseCaseTest {


    private InMemoryQuarto repo;
    private CadastrarQuartoUseCase cadastrar;

    @BeforeEach
    void setUp() {
        repo = new InMemoryQuarto();
        cadastrar = new CadastrarQuartoUseCase(repo);
    }

    @Test
    void deveCadastrarQuartoComNumeroETipo() {
        cadastrar.executar(101, "Solteiro");

        Quarto quarto = repo.buscarPorNumero(101);
        assertNotNull(quarto);
        assertEquals(101, quarto.getNumero());
        assertEquals("Solteiro", quarto.getTipo());
        assertTrue(quarto.isDisponivel());
    }

    @Test
    void deveCadastrarMultiplosQuartos() {
        cadastrar.executar(101, "Solteiro");
        cadastrar.executar(102, "Casal");

        assertEquals(2, repo.listarTodos().size());
    }

}
