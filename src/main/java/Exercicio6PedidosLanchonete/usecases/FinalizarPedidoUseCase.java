package Exercicio6PedidosLanchonete.usecases;

import Exercicio6PedidosLanchonete.entities.Pedido;
import Exercicio6PedidosLanchonete.repositories.PedidoRepository;

public class FinalizarPedidoUseCase {


    private final PedidoRepository repository;

    public FinalizarPedidoUseCase(PedidoRepository repository) {
        this.repository = repository;
    }

    public void executar(Pedido pedido) {
        pedido.finalizar();
        repository.salvar(pedido);
    }

}
