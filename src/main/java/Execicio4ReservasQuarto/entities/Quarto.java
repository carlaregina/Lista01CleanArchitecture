package Execicio4ReservasQuarto.entities;

public class Quarto {

    private int numero;
    private String tipo;
    private boolean disponivel;

    public Quarto(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.disponivel = true;
    }

    public int getNumero() { return numero; }
    public String getTipo() { return tipo; }
    public boolean isDisponivel() { return disponivel; }

    public void reservar() {
        this.disponivel = false;
    }

    @Override
    public String toString() {
        return "Quarto{" +
                "numero=" + numero +
                ", tipo='" + tipo + '\'' +
                ", status=" + (disponivel ? "Disponível" : "Ocupado") +
                '}';
    }

}
