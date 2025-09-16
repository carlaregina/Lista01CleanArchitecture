package Exercicio5GerenciamentoTarefas.usecases;

import Exercicio5GerenciamentoTarefas.entities.Tarefa;
import Exercicio5GerenciamentoTarefas.repositories.TarefaRepository;

public class ConcluirTarefaUseCase {

    private final TarefaRepository repository;

    public ConcluirTarefaUseCase(TarefaRepository repository) {
        this.repository = repository;
    }

    public void executar(String descricao) {
        Tarefa tarefa = repository.buscarPorDescricao(descricao);
        if (tarefa == null || tarefa.getStatus()) {
            throw new RuntimeException("Tarefa não encontrada ou já concluída.");
        }
        tarefa.concluir();
    }

}
