package package2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DisciplinaTest {

    private Disciplina disciplina;
    private Turma turma;
    private Professor professor;
    private Aluno aluno;

    @Before
    public void setUp() {
        disciplina = new Disciplina("Matemática");
        turma = new Turma("Segunda - 8:00 - 10:00", "Sala 101", "T01", null, null);
        professor = new Professor("João");
        aluno = new Aluno("Pedro");
    }

    @Test
    public void testCriarDisciplina() {
        assertEquals("Matemática", disciplina.getNome());
        assertTrue(disciplina.getTurmas().isEmpty());
        assertTrue(disciplina.getProfessores().isEmpty());
    }

    @Test
    public void testAdicionarTurma() {
        disciplina.adicionarTurma(turma);
        List<Turma> turmas = disciplina.getTurmas();
        assertEquals(1, turmas.size());
        assertTrue(turmas.contains(turma));
    }

    @Test
    public void testAdicionarProfessor() {
        disciplina.adicionarProfessor(professor);
        List<Professor> professores = disciplina.getProfessores();
        assertEquals(1, professores.size());
        assertTrue(professores.contains(professor));
    }

    @Test
    public void testAdicionarAluno() {
        TurmaAluno turmaAluno = new TurmaAluno("Segunda - 8:00 - 10:00", "Sala 101", "T01", disciplina, professor);
        disciplina.adicionarTurma(turmaAluno);
        disciplina.adicionarAluno(aluno, turmaAluno);
        assertEquals(1, disciplina.getTotalAlunos());
    }

    @Test
    public void testGetTotalAlunos() {
        assertEquals(0, disciplina.getTotalAlunos());
        TurmaAluno turmaAluno = new TurmaAluno("Segunda - 8:00 - 10:00", "Sala 101", "T01", disciplina, professor);
        disciplina.adicionarTurma(turmaAluno);
        disciplina.adicionarAluno(aluno, turmaAluno);
        assertEquals(1, disciplina.getTotalAlunos());
    }

    @Test
    public void testGetNome() {
        assertEquals("Matemática", disciplina.getNome());
    }
}
