package Execicio4ReservasQuarto.usecases;

import Execicio4ReservasQuarto.entities.Quarto;
import Execicio4ReservasQuarto.repositories.QuartoRepository;

public class CadastrarQuartoUseCase {

    private final QuartoRepository repository;

    public CadastrarQuartoUseCase(QuartoRepository repository) {
        this.repository = repository;
    }

    public void executar(int numero, String tipo) {
        Quarto quarto = new Quarto(numero, tipo);
        repository.salvar(quarto);
    }

}
