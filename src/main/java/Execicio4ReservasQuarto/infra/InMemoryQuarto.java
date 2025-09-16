package Execicio4ReservasQuarto.infra;

import Execicio4ReservasQuarto.entities.Quarto;
import Execicio4ReservasQuarto.repositories.QuartoRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryQuarto implements QuartoRepository {

    private final List<Quarto> quartos = new ArrayList<>();

    @Override
    public void salvar(Quarto quarto) {
        quartos.add(quarto);
    }

    @Override
    public List<Quarto> listarTodos() {
        return quartos;
    }

    @Override
    public Quarto buscarPorNumero(int numero) {
        return quartos.stream()
                .filter(q -> q.getNumero() == numero)
                .findFirst()
                .orElse(null);
    }

}
