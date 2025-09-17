package Exercicio6Test;

import Exercicio6PedidosLanchonete.entities.Lanche;
import Exercicio6PedidosLanchonete.entities.StatusLanche;
import Exercicio6PedidosLanchonete.infra.InMemoryLancheRepository;
import Exercicio6PedidosLanchonete.usecases.CadastrarLancheUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CadastrarLancheUseCaseTest {


    private InMemoryLancheRepository repository;
    private CadastrarLancheUseCase cadastrarLancheUseCase;

    @BeforeEach
    void setup() {
        repository = new InMemoryLancheRepository();
        cadastrarLancheUseCase = new CadastrarLancheUseCase(repository);
    }

    @Test
    void deveCadastrarLancheComSucesso() {
        cadastrarLancheUseCase.executar("X-Burguer", 10.0, StatusLanche.DISPONIVEL);

        List<Lanche> lanches = repository.listarDisponiveis();
        assertEquals(1, lanches.size());
        assertEquals("X-Burguer", lanches.get(0).getNome());
        assertEquals(10.0, lanches.get(0).getPreco());
        assertTrue(lanches.get(0).isDisponivel());
    }

    @Test
    void naoDeveCadastrarLancheComNomeVazio() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cadastrarLancheUseCase.executar("", 10.0, StatusLanche.DISPONIVEL);
        });

        assertEquals("Nome do lanche não pode ser vazio", exception.getMessage());
    }

}
