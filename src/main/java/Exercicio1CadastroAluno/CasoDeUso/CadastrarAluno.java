package Exercicio1CadastroAluno.CasoDeUso;


import Exercicio1CadastroAluno.Model.Aluno;
import Exercicio1CadastroAluno.Repositorios.AlunoRepository;

public class CadastrarAluno {
    private final AlunoRepository repository;

    public CadastrarAluno(AlunoRepository repository) {
        this.repository = repository;
    }


    public void executar(String nome, String matricula, String curso) {
        Aluno aluno = new Aluno(nome, matricula, curso);
        repository.salvar(aluno);
    }

}

