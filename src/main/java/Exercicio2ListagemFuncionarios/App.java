package Exercicio2ListagemFuncionarios;

import Exercicio2ListagemFuncionarios.CasosDeUso.ListarFuncionariosUseCase;
import Exercicio2ListagemFuncionarios.DTO.FuncionarioDTO;
import Exercicio2ListagemFuncionarios.infra.InMemoryFuncionarioRepository;


import java.util.List;

public class App {
    public static void main(String[] args) {



        ListarFuncionariosUseCase useCase = new ListarFuncionariosUseCase(new InMemoryFuncionarioRepository());

        System.out.println("Funcionários:");
        List<FuncionarioDTO> funcionarios = useCase.executar();
        System.out.println("Total de funcionários retornados: " + funcionarios.size());
        funcionarios.forEach(System.out::println);
    }



}

