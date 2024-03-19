package package2;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String horario;
    private String sala;
    private String id;
    private Disciplina disciplina;
    private Professor professor;
    private List<Aluno> alunos;

    public Turma(String horario, String sala, String id, Disciplina disciplina, Professor professor) {
        this.horario = horario;
        this.sala = sala;
        this.id = id;
        this.disciplina = disciplina;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }

    public static Turma criarTurma(String horario, String sala, String id, Disciplina disciplina, Professor professor) {
        return new Turma(horario, sala, id, disciplina, professor);
    }

    public String getHorario() {
        return horario;
    }

    public String getSala() {
        return sala;
    }

    public String getId() {
        return id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void adicionarAluno(Aluno aluno) {
        if (!alunos.contains(aluno)) {
            alunos.add(aluno);
        } else {
            System.out.println("O aluno " + aluno.getNome() + " já está matriculado nesta turma.");
        }
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }
}