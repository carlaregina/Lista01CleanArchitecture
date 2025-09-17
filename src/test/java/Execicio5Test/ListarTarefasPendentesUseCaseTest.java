package Execicio5Test;


import Exercicio5GerenciamentoTarefas.entities.Tarefa;
import Exercicio5GerenciamentoTarefas.infra.InMemoryTarefa;
import Exercicio5GerenciamentoTarefas.usecases.ConcluirTarefaUseCase;
import Exercicio5GerenciamentoTarefas.usecases.CriarTarefaUseCase;
import Exercicio5GerenciamentoTarefas.usecases.ListarTarefasPendentesUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListarTarefasPendentesUseCaseTest {

    private InMemoryTarefa repo;
    private CriarTarefaUseCase criar;
    private ConcluirTarefaUseCase concluir;
    private ListarTarefasPendentesUseCase listar;

    @BeforeEach
    void setUp() {
        repo = new InMemoryTarefa();
        criar = new CriarTarefaUseCase(repo);
        concluir = new ConcluirTarefaUseCase(repo);
        listar = new ListarTarefasPendentesUseCase(repo);
    }

    @Test
    void deveListarApenasTarefasPendentes() {
        criar.executar("Estudar Clean Architecture");
        criar.executar("Fazer exercício");
        concluir.executar("Fazer exercício");

        List<Tarefa> pendentes = listar.executar();

        assertEquals(1, pendentes.size());
        assertEquals("Estudar Clean Architecture", pendentes.get(0).getDescricao());
    }
}

