package Exercicio6PedidosLanchonete.usecases;

import Exercicio6PedidosLanchonete.entities.Lanche;
import Exercicio6PedidosLanchonete.repositories.LancheRepository;

import java.util.List;

public class ListarLanchesUseCase {

    private final LancheRepository repository;

    public ListarLanchesUseCase(LancheRepository repository) {
        this.repository = repository;
    }

    public List<Lanche> executar() {
        return repository.listarDisponiveis();
    }

}
