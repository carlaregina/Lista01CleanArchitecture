package Exercicio5GerenciamentoTarefas.infra;

import Exercicio5GerenciamentoTarefas.entities.Tarefa;
import Exercicio5GerenciamentoTarefas.repositories.TarefaRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTarefa implements TarefaRepository {


    private final List<Tarefa> tarefas = new ArrayList<>();

    @Override
    public void salvar(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    @Override
    public List<Tarefa> listarTodas() {
        return tarefas;
    }

    @Override
    public Tarefa buscarPorDescricao(String descricao) {
        return tarefas.stream()
                .filter(t -> t.getDescricao().equalsIgnoreCase(descricao))
                .findFirst()
                .orElse(null);
    }


}
