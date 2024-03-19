package package2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TurmaAlunoTest {

    private TurmaAluno turmaAluno;
    private Aluno aluno;
    private Disciplina disciplina;
    private Professor professor;

    @Before
    public void setUp() {
        professor = new Professor("João");
        disciplina = new Disciplina("Matemática");
        turmaAluno = new TurmaAluno("Segunda - 8:00 - 10:00", "Sala 101", "T01", disciplina, professor);
        aluno = new Aluno("Pedro");
    }

    @Test
    public void testCriarTurmaAluno() {
        assertEquals("Segunda - 8:00 - 10:00", turmaAluno.getHorario());
        assertEquals("Sala 101", turmaAluno.getSala());
        assertEquals("T01", turmaAluno.getId());
        assertEquals(disciplina, turmaAluno.getDisciplina());
        assertEquals(professor, turmaAluno.getProfessor());
    }

    @Test
    public void testAdicionarAluno() {
        turmaAluno.adicionarAluno(aluno);
        assertTrue(turmaAluno.getAlunos().contains(aluno));
    }

    @Test
    public void testAdicionarAlunoRepetido() {
        turmaAluno.adicionarAluno(aluno);
        turmaAluno.adicionarAluno(aluno);
        assertEquals(1, turmaAluno.getAlunos().size());
    }

    @Test
    public void testRemoverAluno() {
        turmaAluno.adicionarAluno(aluno);
        turmaAluno.removerAluno(aluno);
        assertFalse(turmaAluno.getAlunos().contains(aluno));
    }
}

