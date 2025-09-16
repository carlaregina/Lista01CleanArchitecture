package Exercicio6PedidosLanchonete.infra;

import Exercicio6PedidosLanchonete.entities.Pedido;
import Exercicio6PedidosLanchonete.repositories.PedidoRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPedidoRepository implements PedidoRepository {

    private final List<Pedido> pedidos = new ArrayList<>();

    @Override
    public void salvar(Pedido pedido) {

        if (!pedidos.contains(pedido)) {
            pedidos.add(pedido);
        }
    }

    @Override
    public List<Pedido> listar() {
        return new ArrayList<>(pedidos);
    }

}
