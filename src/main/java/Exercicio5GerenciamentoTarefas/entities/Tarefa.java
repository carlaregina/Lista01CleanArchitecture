
package Exercicio5GerenciamentoTarefas.entities;

public class Tarefa {


    private String descricao;
    private boolean status;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.status = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean getStatus() {
        return status;
    }

    public void concluir() {
        this.status = true;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "descricao='" + descricao + '\'' +
                ", status=" + (status ? "Concluída" : "Pendente") +
                '}';
    }

}
