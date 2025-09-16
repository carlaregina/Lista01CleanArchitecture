package Execicio4ReservasQuarto.facade;

import Execicio4ReservasQuarto.entities.Quarto;
import Execicio4ReservasQuarto.infra.InMemoryQuarto;
import Execicio4ReservasQuarto.usecases.CadastrarQuartoUseCase;
import Execicio4ReservasQuarto.usecases.ListarQuartosUseCase;
import Execicio4ReservasQuarto.usecases.ReservarQuartoUseCase;

import java.util.List;

public class QuartoFacade {


    private final CadastrarQuartoUseCase cadastrar;
    private final ListarQuartosUseCase listar;
    private final ReservarQuartoUseCase reservar;

    public QuartoFacade() {
        InMemoryQuarto repo = new InMemoryQuarto();
        this.cadastrar = new CadastrarQuartoUseCase(repo);
        this.listar = new ListarQuartosUseCase(repo);
        this.reservar = new ReservarQuartoUseCase(repo);
    }

    public void cadastrarQuarto(int numero, String tipo) {
        cadastrar.executar(numero, tipo);
    }

    public List<Quarto> listarQuartos() {
        return listar.executar();
    }

    public void reservarQuarto(int numero) {
        reservar.executar(numero);
    }

}
