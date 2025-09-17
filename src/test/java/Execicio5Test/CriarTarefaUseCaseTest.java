package Execicio5Test;

import Exercicio5GerenciamentoTarefas.entities.Tarefa;
import Exercicio5GerenciamentoTarefas.infra.InMemoryTarefa;
import Exercicio5GerenciamentoTarefas.usecases.CriarTarefaUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CriarTarefaUseCaseTest {


    private InMemoryTarefa repo;
    private CriarTarefaUseCase criar;

    @BeforeEach
    void setUp() {
        repo = new InMemoryTarefa();
        criar = new CriarTarefaUseCase(repo);
    }

    @Test
    void deveCriarTarefaComDescricaoCorreta() {
        criar.executar("Estudar JUnit");

        Tarefa tarefa = repo.buscarPorDescricao("Estudar JUnit");
        assertNotNull(tarefa, "A tarefa deveria ter sido criada.");
        assertEquals("Estudar JUnit", tarefa.getDescricao());
        assertFalse(tarefa.getStatus(), "A tarefa recém-criada deve estar pendente.");
    }

    @Test
    void devePermitirCriarMultiplasTarefas() {
        criar.executar("Tarefa 1");
        criar.executar("Tarefa 2");

        assertNotNull(repo.buscarPorDescricao("Tarefa 1"));
        assertNotNull(repo.buscarPorDescricao("Tarefa 2"));
        assertEquals(2, repo.listarTodas().size());
    }

    @Test
    void deveCriarTarefaMesmoComDescricaoRepetida() {
        criar.executar("Duplicada");
        criar.executar("Duplicada");

        assertEquals(2, repo.listarTodas().stream()
                .filter(t -> t.getDescricao().equals("Duplicada"))
                .count());
    }

}
