package Exercicio6Test;

import Exercicio6PedidosLanchonete.entities.Lanche;
import Exercicio6PedidosLanchonete.entities.Pedido;
import Exercicio6PedidosLanchonete.entities.StatusLanche;
import Exercicio6PedidosLanchonete.infra.InMemoryPedidoRepository;
import Exercicio6PedidosLanchonete.usecases.CriarPedidoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CriarPedidoUseCaseTest {

    private InMemoryPedidoRepository pedidoRepository;
    private CriarPedidoUseCase criarPedidoUseCase;

    @BeforeEach
    void setup() {
        pedidoRepository = new InMemoryPedidoRepository();
        criarPedidoUseCase = new CriarPedidoUseCase(pedidoRepository);
    }

    @Test
    void deveCriarPedidoComLanchesDisponiveis() {
        Lanche lanche1 = new Lanche(StatusLanche.DISPONIVEL, 10.0, "X-Burguer");
        Lanche lanche2 = new Lanche(StatusLanche.DISPONIVEL, 8.0, "Batata Frita");

        Pedido pedido = criarPedidoUseCase.executar(List.of(lanche1, lanche2));

        assertNotNull(pedido);
        assertEquals(2, pedido.getLanches().size());
        assertEquals(18.0, pedido.getValorTotal());
    }

    @Test
    void naoDeveCriarPedidoComLancheIndisponivel() {
        Lanche lancheIndisponivel = new Lanche(StatusLanche.INDISPONIVEL, 12.0, "X-Salada");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            criarPedidoUseCase.executar(List.of(lancheIndisponivel));
        });

        assertEquals("Lanche indisponível.", exception.getMessage());
    }

    @Test
    void naoDeveAdicionarLancheAposPedidoFinalizado() {
        Lanche lanche1 = new Lanche(StatusLanche.DISPONIVEL, 10.0, "X-Burguer");
        Pedido pedido = criarPedidoUseCase.executar(List.of(lanche1));

        pedido.finalizar();

        Lanche lanche2 = new Lanche(StatusLanche.DISPONIVEL, 8.0, "Batata Frita");

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            pedido.adicionarLanche(lanche2);
        });

        assertEquals("Pedido já finalizado.", exception.getMessage());
    }

}

