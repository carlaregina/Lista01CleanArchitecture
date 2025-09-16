package Exercicio1CadastroAluno;

import Exercicio1CadastroAluno.CasoDeUso.CadastrarAluno;
import Exercicio1CadastroAluno.Repositorios.InMemoryAlunoRepositorio;

public class App {

    public static void main(String[] args) {


        InMemoryAlunoRepositorio repo = new InMemoryAlunoRepositorio();
        CadastrarAluno cadastrarAluno = new CadastrarAluno(repo);

        cadastrarAluno.executar("Carla Vasconcellos", "2025001", "Engenharia de Software");
        cadastrarAluno.executar("João Silva", "2025002", "Ciência da Computação");

        System.out.println("Todos os alunos cadastrados:");
        repo.listarTodos().forEach(System.out::println);


    }
}
