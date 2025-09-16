package Exercicio6PedidosLanchonete;

import Exercicio6PedidosLanchonete.entities.Lanche;
import Exercicio6PedidosLanchonete.entities.Pedido;
import Exercicio6PedidosLanchonete.entities.StatusLanche;
import Exercicio6PedidosLanchonete.facade.LanchoneteFacade;
import Exercicio6PedidosLanchonete.infra.InMemoryLancheRepository;
import Exercicio6PedidosLanchonete.infra.InMemoryPedidoRepository;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        LanchoneteFacade facade = new LanchoneteFacade(
                new InMemoryLancheRepository(),
                new InMemoryPedidoRepository()
        );


        facade.cadastrarLanche("X-Burguer", 10.0, StatusLanche.DISPONIVEL);
        facade.cadastrarLanche("X-Salada", 12.0, StatusLanche.INDISPONIVEL);
        facade.cadastrarLanche("Batata Frita", 8.0, StatusLanche.DISPONIVEL);

        List<Lanche> lanchesDisponiveis = facade.listarLanchesDisponiveis();
        System.out.println("Lanches disponíveis:");
        lanchesDisponiveis.forEach(System.out::println);

        Pedido pedido = facade.criarPedido(lanchesDisponiveis);
        System.out.println("\nPedido criado:");
        pedido.getLanches().forEach(l -> System.out.println("- " + l.getNome()));
        System.out.println("Valor total: R$" + pedido.getValorTotal());

        facade.finalizarPedido(pedido);
        System.out.println("\nPedido finalizado. Status: " + pedido.getStatusPedido());


        try {
            Lanche novoLanche = new Lanche(StatusLanche.DISPONIVEL, 15.0, "Refrigerante");
            pedido.adicionarLanche(novoLanche);
        } catch (Exception e) {
            System.out.println("\nErro ao adicionar lanche após finalização: " + e.getMessage());
        }


        try {
            List<Lanche> lanchesComIndisponivel = new ArrayList<>(lanchesDisponiveis);
            lanchesComIndisponivel.add(new Lanche(StatusLanche.INDISPONIVEL, 20.0, "Sorvete"));

            Pedido pedidoComErro = facade.criarPedido(lanchesComIndisponivel);
        } catch (Exception e) {
            System.out.println("\nErro ao criar pedido com lanche indisponível: " + e.getMessage());
        }

    }

}
