package Exercicio2ListagemFuncionarios.CasosDeUso;


import Exercicio2ListagemFuncionarios.DTO.FuncionarioDTO;
import Exercicio2ListagemFuncionarios.Repositorios.FuncionarioRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ListarFuncionariosUseCase {
    private final FuncionarioRepository repository;

    public ListarFuncionariosUseCase(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public List<FuncionarioDTO> executar() {
        return repository.listarTodos().stream()
                .map(f -> new FuncionarioDTO(f.getNome(), f.getCargo(), f.getSalario()))
                .collect(Collectors.toList());
    }
}

