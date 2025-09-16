package Exercicio6PedidosLanchonete.usecases;

import Exercicio6PedidosLanchonete.entities.Lanche;
import Exercicio6PedidosLanchonete.entities.Pedido;
import Exercicio6PedidosLanchonete.repositories.PedidoRepository;

import java.util.List;

public class CriarPedidoUseCase {


    private final PedidoRepository repository;

    public CriarPedidoUseCase(PedidoRepository repository) {
        this.repository = repository;
    }

    public Pedido executar(List<Lanche> lanchesSelecionados) {
        Pedido pedido = new Pedido();
        for (Lanche lanche : lanchesSelecionados) {
            pedido.adicionarLanche(lanche);
        }
        repository.salvar(pedido);
        return pedido;
    }


}
