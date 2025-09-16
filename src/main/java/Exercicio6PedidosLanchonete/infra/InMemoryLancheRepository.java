package Exercicio6PedidosLanchonete.infra;

import Exercicio6PedidosLanchonete.entities.Lanche;
import Exercicio6PedidosLanchonete.repositories.LancheRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryLancheRepository implements LancheRepository {

    private final List<Lanche> lanches = new ArrayList<>();

    @Override
    public void salvar(Lanche lanche) {
        lanches.add(lanche);
    }

    @Override
    public List<Lanche> listarDisponiveis() {

        return lanches.stream()
                .filter(Lanche::isDisponivel)
                .collect(Collectors.toList());

    }
}
