package Exercicio5GerenciamentoTarefas.usecases;

import Exercicio5GerenciamentoTarefas.entities.Tarefa;
import Exercicio5GerenciamentoTarefas.repositories.TarefaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ListarTarefasPendentesUseCase {

    private final TarefaRepository repository;

    public ListarTarefasPendentesUseCase(TarefaRepository repository) {
        this.repository = repository;
    }

    public List<Tarefa> executar() {
        return repository.listarTodas().stream()
                .filter(t -> !t.getStatus())
                .collect(Collectors.toList());
    }


}
