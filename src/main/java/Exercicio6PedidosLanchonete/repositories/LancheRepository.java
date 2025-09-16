package Exercicio6PedidosLanchonete.repositories;

import Exercicio6PedidosLanchonete.entities.Lanche;

import java.util.List;

public interface LancheRepository {

    void salvar(Lanche lanche);

    List<Lanche> listarDisponiveis();

}
