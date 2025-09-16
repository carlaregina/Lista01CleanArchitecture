package Exercicio5GerenciamentoTarefas.usecases;

import Exercicio5GerenciamentoTarefas.entities.Tarefa;
import Exercicio5GerenciamentoTarefas.repositories.TarefaRepository;

public class CriarTarefaUseCase {

    private final TarefaRepository repository;

    public CriarTarefaUseCase(TarefaRepository repository) {
        this.repository = repository;
    }

    public void executar(String descricao) {
        Tarefa tarefa = new Tarefa(descricao);
        repository.salvar(tarefa);
    }


}
