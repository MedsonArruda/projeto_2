package package2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class ProfessorTest {

    private Professor professor;
    private Turma turma;
    private Disciplina disciplina;

    @Before
    public void setUp() {
        professor = new Professor("Maria");
        turma = new Turma("Segunda - 8:00 - 10:00", "Sala 101", "T01", null, null);
        disciplina = new Disciplina("Matemática");
    }

    @Test
    public void testCriarProfessor() {
        assertEquals("Maria", professor.getNome());
        assertTrue(professor.getTurmas().isEmpty());
        assertTrue(professor.getDisciplinas().isEmpty());
    }

    @Test
    public void testAdicionarTurma() {
        professor.adicionarTurma(turma);
        List<Turma> turmas = professor.getTurmas();
        assertEquals(1, turmas.size());
        assertTrue(turmas.contains(turma));
    }

    @Test
    public void testAdicionarDisciplina() {
        professor.adicionarDisciplina(disciplina);
        List<Disciplina> disciplinas = professor.getDisciplinas();
        assertEquals(1, disciplinas.size());
        assertTrue(disciplinas.contains(disciplina));
    }

    @Test
    public void testAdicionarDisciplinaComProfessor() {
        assertEquals(0, disciplina.getProfessores().size());
        professor.adicionarDisciplina(disciplina);
        assertEquals(1, disciplina.getProfessores().size());
        assertTrue(disciplina.getProfessores().contains(professor));
    }

    @Test
    public void testGetNome() {
        assertEquals("Maria", professor.getNome());
    }
}

