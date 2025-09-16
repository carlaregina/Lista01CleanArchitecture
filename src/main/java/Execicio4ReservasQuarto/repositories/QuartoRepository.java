package Execicio4ReservasQuarto.repositories;

import Execicio4ReservasQuarto.entities.Quarto;

import java.util.List;

public interface QuartoRepository {

    void salvar(Quarto quarto);

    List<Quarto> listarTodos();

    Quarto buscarPorNumero(int numero);

}
