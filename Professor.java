package package2;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String nome;
    private List<Turma> turmas;
    private List<Disciplina> disciplinas;

    public Professor(String nome) {
        this.nome = nome;
        this.turmas = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
    }

    public static Professor criarProfessor(String nome) {
        return new Professor(nome);
    }

    public void adicionarTurma(Turma turma) {
        turmas.add(turma);
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
        disciplina.adicionarProfessor(this); // Adiciona o professor à disciplina
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
}
