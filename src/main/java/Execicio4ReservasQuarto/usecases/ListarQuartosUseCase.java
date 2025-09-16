package Execicio4ReservasQuarto.usecases;

import Execicio4ReservasQuarto.entities.Quarto;
import Execicio4ReservasQuarto.repositories.QuartoRepository;

import java.util.List;

public class ListarQuartosUseCase {

    private final QuartoRepository repository;

    public ListarQuartosUseCase(QuartoRepository repository) {
        this.repository = repository;
    }

    public List<Quarto> executar() {
        return repository.listarTodos();
    }

}
