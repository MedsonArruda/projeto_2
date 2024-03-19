package package2;

public class TurmaProfessor extends Turma {
    private Professor professor;

    public TurmaProfessor(String horario, String sala, String id, Professor professor, Disciplina disciplina) {
        super(horario, sala, id, disciplina, professor);
        this.professor = professor;
    }

    // Método creator para criar turmas de professores
    public static TurmaProfessor criarTurmaProfessor(String horario, String sala, String id, Professor professor, Disciplina disciplina) {
        return new TurmaProfessor(horario, sala, id, professor, disciplina);
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void adicionarProfessor(Professor novoProfessor) {
        if (this.professor == null) {
            this.professor = novoProfessor;
        } else {
            System.out.println("Já existe um professor associado a esta turma.");
        }
    }

    public void removerProfessor() {
        this.professor = null;
    }
}
