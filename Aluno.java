package package2;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private List<TurmaAluno> turmas;

    public Aluno(String nome) {
        this.nome = nome;
        this.turmas = new ArrayList<>();
    }

    public static Aluno criarAluno(String nome) {
        return new Aluno(nome);
    }

    public void adicionarTurma(TurmaAluno turma) {
        turmas.add(turma);
    }

    public List<TurmaAluno> getTurmas() {
        return turmas;
    }

    public String getNome() {
        return nome;
    }
}
