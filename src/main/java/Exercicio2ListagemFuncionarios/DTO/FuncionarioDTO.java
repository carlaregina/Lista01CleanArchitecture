package Exercicio2ListagemFuncionarios.DTO;


public class FuncionarioDTO {
    private String nome;
    private String cargo;
    private double salario;

    public FuncionarioDTO(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "FuncionarioDTO{" +
                "nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                '}';
    }
}

