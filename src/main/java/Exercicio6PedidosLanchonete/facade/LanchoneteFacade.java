package Exercicio6PedidosLanchonete.facade;

import Exercicio6PedidosLanchonete.entities.Lanche;
import Exercicio6PedidosLanchonete.entities.Pedido;
import Exercicio6PedidosLanchonete.entities.StatusLanche;
import Exercicio6PedidosLanchonete.entities.StatusPedido;
import Exercicio6PedidosLanchonete.repositories.LancheRepository;
import Exercicio6PedidosLanchonete.repositories.PedidoRepository;
import Exercicio6PedidosLanchonete.usecases.CadastrarLancheUseCase;
import Exercicio6PedidosLanchonete.usecases.CriarPedidoUseCase;
import Exercicio6PedidosLanchonete.usecases.FinalizarPedidoUseCase;
import Exercicio6PedidosLanchonete.usecases.ListarLanchesUseCase;

import java.util.List;

public class LanchoneteFacade {


    private final CadastrarLancheUseCase cadastrarLancheUseCase;
    private final ListarLanchesUseCase listarLanchesUseCase;
    private final CriarPedidoUseCase criarPedidoUseCase;
    private final FinalizarPedidoUseCase finalizarPedidoUseCase;

    public LanchoneteFacade(LancheRepository lancheRepo, PedidoRepository pedidoRepo) {
        this.cadastrarLancheUseCase = new CadastrarLancheUseCase(lancheRepo);
        this.listarLanchesUseCase = new ListarLanchesUseCase(lancheRepo);
        this.criarPedidoUseCase = new CriarPedidoUseCase(pedidoRepo);
        this.finalizarPedidoUseCase = new FinalizarPedidoUseCase(pedidoRepo);
    }

    public void cadastrarLanche(String nome, double preco, StatusLanche status) {
        cadastrarLancheUseCase.executar(nome, preco, status);
    }

    public List<Lanche> listarLanchesDisponiveis() {
        return listarLanchesUseCase.executar();
    }


    public Pedido criarPedido(List<Lanche> lanchesSelecionados) {
        for (Lanche lanche : lanchesSelecionados) {
            if (!lanche.isDisponivel()) {
                throw new IllegalArgumentException("Lanche '" + lanche.getNome() + "' está indisponível.");
            }
        }

        return criarPedidoUseCase.executar(lanchesSelecionados);
    }

    public void finalizarPedido(Pedido pedido) {
        finalizarPedidoUseCase.executar(pedido);
    }

}
