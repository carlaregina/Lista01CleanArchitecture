package Exercicio6PedidosLanchonete.usecases;

import Exercicio6PedidosLanchonete.entities.Lanche;
import Exercicio6PedidosLanchonete.entities.StatusLanche;
import Exercicio6PedidosLanchonete.entities.StatusPedido;
import Exercicio6PedidosLanchonete.repositories.LancheRepository;

public class CadastrarLancheUseCase {

    private final LancheRepository repository;

    public CadastrarLancheUseCase(LancheRepository repository) {
        this.repository = repository;
    }

    public void executar(String nome, double preco, StatusLanche status) {
        Lanche lanche = new Lanche(status, preco, nome);
        repository.salvar(lanche);
    }

}
