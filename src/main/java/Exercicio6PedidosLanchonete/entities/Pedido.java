package Exercicio6PedidosLanchonete.entities;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<Lanche> lanches = new ArrayList<>();
    private double valorTotal = 0.0;
    private StatusPedido statusPedido = StatusPedido.ABERTO;

    public Pedido(double valorTotal, List<Lanche> lanches, StatusPedido statusPedido) {
        this.valorTotal = valorTotal;
        this.lanches = lanches;
        this.statusPedido = statusPedido;
    }

    public Pedido() {

    }

    public double getValorTotal() {
        return valorTotal;
    }

    public List<Lanche> getLanches() {
        return lanches;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void adicionarLanche(Lanche lanche) {
        if (statusPedido == StatusPedido.FINALIZADO)
            throw new IllegalStateException("Pedido já finalizado.");

        if (!lanche.isDisponivel())
            throw new IllegalArgumentException("Lanche indisponível.");

        lanches.add(lanche);
        valorTotal += lanche.getPreco();
    }

    public void finalizar() {
        statusPedido = StatusPedido.FINALIZADO;
    }
}
