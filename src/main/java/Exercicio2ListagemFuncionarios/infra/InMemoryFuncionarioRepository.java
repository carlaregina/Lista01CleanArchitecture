package Exercicio2ListagemFuncionarios.infra;

import Exercicio2ListagemFuncionarios.Repositorios.FuncionarioRepository;
import Exercicio2ListagemFuncionarios.entities.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class InMemoryFuncionarioRepository implements FuncionarioRepository {



    private final List<Funcionario> funcionarios = new ArrayList<>();

    public InMemoryFuncionarioRepository() {
        funcionarios.add(new Funcionario("Ana Costa", "Gerente", 8500.00));
        funcionarios.add(new Funcionario("Carlos Lima", "Desenvolvedor", 6500.00));
        funcionarios.add(new Funcionario("Fernanda Souza", "Analista", 7000.00));
    }

    @Override
    public List<Funcionario> listarTodos() {
        return funcionarios;
    }

}
