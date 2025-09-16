package Exercicio5GerenciamentoTarefas;

import Exercicio5GerenciamentoTarefas.infra.InMemoryTarefa;
import Exercicio5GerenciamentoTarefas.usecases.ConcluirTarefaUseCase;
import Exercicio5GerenciamentoTarefas.usecases.CriarTarefaUseCase;
import Exercicio5GerenciamentoTarefas.usecases.ListarTarefasPendentesUseCase;

public class App {


    public static void main(String[] args) {

        InMemoryTarefa repo = new InMemoryTarefa();

        CriarTarefaUseCase criar = new CriarTarefaUseCase(repo);
        ListarTarefasPendentesUseCase listar = new ListarTarefasPendentesUseCase(repo);
        ConcluirTarefaUseCase concluir = new ConcluirTarefaUseCase(repo);

        criar.executar("Estudar Clean Architecture");
        criar.executar("Fazer exercício de Tarefas");
        criar.executar("Enviar projeto no GitHub");

        System.out.println("Tarefas pendentes:");
        listar.executar().forEach(System.out::println);

        concluir.executar("Fazer exercício de Tarefas");

        System.out.println("\nTarefas pendentes após conclusão:");
        listar.executar().forEach(System.out::println);

    }

}
