package Execicio4ReservasQuarto;

import Execicio4ReservasQuarto.facade.QuartoFacade;

public class App {


    public static void main(String[] args) {
        QuartoFacade facade = new QuartoFacade();

        facade.cadastrarQuarto(101, "Solteiro");
        facade.cadastrarQuarto(102, "Casal");

        System.out.println("Quartos disponíveis:");
        facade.listarQuartos().forEach(System.out::println);

        facade.reservarQuarto(101);

        System.out.println("\nApós reserva:");
        facade.listarQuartos().forEach(System.out::println);
    }

}
