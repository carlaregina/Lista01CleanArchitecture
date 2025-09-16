package Execicio4ReservasQuarto.usecases;

import Execicio4ReservasQuarto.entities.Quarto;
import Execicio4ReservasQuarto.repositories.QuartoRepository;

public class ReservarQuartoUseCase {


    private final QuartoRepository repository;

    public ReservarQuartoUseCase(QuartoRepository repository) {
        this.repository = repository;
    }

    public void executar(int numero) {
        Quarto quarto = repository.buscarPorNumero(numero);
        if (quarto == null || !quarto.isDisponivel()) {
            throw new RuntimeException("Quarto não disponível ou inexistente.");
        }
        quarto.reservar();
    }


}
