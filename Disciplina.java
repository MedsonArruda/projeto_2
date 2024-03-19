package package2;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private List<Turma> turmas;
    private List<Professor> professores;

    public Disciplina(String nome) {
        this.nome = nome;
        this.turmas = new ArrayList<>();
        this.professores = new ArrayList<>();
    }

    public static Disciplina criarDisciplina(String nome) {
        return new Disciplina(nome);
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

    public int getTotalAlunos() {
        int totalAlunos = 0;
        for (Turma turma : turmas) {
            if (turma instanceof TurmaAluno) {
                totalAlunos += ((TurmaAluno) turma).getAlunos().size();
            }
        }
        return totalAlunos;
    }

    public void adicionarAluno(Aluno aluno, TurmaAluno turma) {
        for (Turma t : turmas) {
            if (t.getId().equals(turma.getId())) {
                t.adicionarAluno(aluno);
                aluno.adicionarTurma(turma);
                return;
            }
        }
    }

    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
    }

    public List<Professor> getProfessores() {
        return professores;
    }
}
