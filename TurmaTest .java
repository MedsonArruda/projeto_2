package package2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TurmaTest {

    private Turma turma;
    private Disciplina disciplina;
    private Professor professor;
    private Aluno aluno;

    @Before
    public void setUp() {
        disciplina = new Disciplina("Matemática");
        professor = new Professor("João");
        aluno = new Aluno("Pedro");
        turma = new Turma("Segunda - 8:00 - 10:00", "Sala 101", "T01", disciplina, professor);
    }

    @Test
    public void testCriarTurma() {
        assertEquals("Segunda - 8:00 - 10:00", turma.getHorario());
        assertEquals("Sala 101", turma.getSala());
        assertEquals("T01", turma.getId());
        assertEquals(disciplina, turma.getDisciplina());
        assertEquals(professor, turma.getProfessor());
        assertTrue(turma.getAlunos().isEmpty());
    }

    @Test
    public void testAdicionarAluno() {
        turma.adicionarAluno(aluno);
        assertTrue(turma.getAlunos().contains(aluno));
    }
}
