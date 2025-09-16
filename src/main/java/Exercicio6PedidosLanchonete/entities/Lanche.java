package Exercicio6PedidosLanchonete.entities;

public class Lanche {

    private String nome;
    private double preco;
    private StatusLanche disponivel;

    public Lanche(StatusLanche disponivel, double preco, String nome) {
        this.disponivel = disponivel;
        this.preco = preco;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public boolean isDisponivel() {
        return disponivel == StatusLanche.DISPONIVEL;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Lanche{" +
                "nome='" + nome + '\'' +
                ", disponibilidade='" + disponivel + '\'' +
                ", preco=" + preco +
                '}';
    }
}
