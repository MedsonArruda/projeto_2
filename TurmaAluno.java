package package2;

import java.util.ArrayList;
import java.util.List;

public class TurmaAluno extends Turma {
    private List<Aluno> alunos;

    public TurmaAluno(String horario, String sala, String id, Disciplina disciplina, Professor professor) {
        super(horario, sala, id, disciplina, professor);
        this.alunos = new ArrayList<>();
    }

    public static TurmaAluno criarTurmaAluno(String horario, String sala, String id, Disciplina disciplina, Professor professor) {
        return new TurmaAluno(horario, sala, id, disciplina, professor);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void adicionarAluno(Aluno aluno) {
        if (!alunos.contains(aluno)) {
            alunos.add(aluno);
        } else {
            System.out.println("O aluno " + aluno.getNome() + " já está matriculado nesta turma.");
        }
    }

    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }
}
