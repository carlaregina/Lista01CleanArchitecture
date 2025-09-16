package Exercicio5GerenciamentoTarefas.repositories;

import Exercicio5GerenciamentoTarefas.entities.Tarefa;

import java.util.List;

public interface TarefaRepository {


    void salvar(Tarefa tarefa);

    List<Tarefa> listarTodas();

    Tarefa buscarPorDescricao(String descricao);

}
