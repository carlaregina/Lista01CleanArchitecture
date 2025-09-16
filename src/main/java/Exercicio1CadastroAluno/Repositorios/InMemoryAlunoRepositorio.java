package Exercicio1CadastroAluno.Repositorios;

import Exercicio1CadastroAluno.Model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAlunoRepositorio implements AlunoRepository{


    private final List<Aluno> alunos = new ArrayList<>();

    @Override
    public void salvar(Aluno aluno) {
        alunos.add(aluno);
        System.out.println("Aluno salvo: " + aluno);
    }

    public List<Aluno> listarTodos() {
        return alunos;
    }

}
