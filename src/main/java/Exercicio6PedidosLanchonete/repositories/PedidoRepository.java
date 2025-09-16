package Exercicio6PedidosLanchonete.repositories;

import Exercicio6PedidosLanchonete.entities.Pedido;

import java.util.List;

public interface PedidoRepository {

    void salvar(Pedido pedido);

    List<Pedido> listar();

}
