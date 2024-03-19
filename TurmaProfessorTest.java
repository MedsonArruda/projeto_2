package package2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class TurmaProfessorTest {

    private TurmaProfessor turmaProfessor;
    private Professor professor;
    private Disciplina disciplina;

    @Before
    public void setUp() {
        professor = new Professor("João");
        disciplina = new Disciplina("Matemática");
        turmaProfessor = new TurmaProfessor("Segunda - 8:00 - 10:00", "Sala 101", "T01", professor, disciplina);
    }

    @Test
    public void testCriarTurmaProfessor() {
        assertEquals("Segunda - 8:00 - 10:00", turmaProfessor.getHorario());
        assertEquals("Sala 101", turmaProfessor.getSala());
        assertEquals("T01", turmaProfessor.getId());
        assertEquals(professor, turmaProfessor.getProfessor());
        assertEquals(disciplina, turmaProfessor.getDisciplina());
    }

    @Test
    public void testAdicionarProfessor() {
        Professor novoProfessor = new Professor("Maria");
        turmaProfessor.adicionarProfessor(novoProfessor);
        assertEquals(novoProfessor, turmaProfessor.getProfessor());
    }

    @Test
    public void testRemoverProfessor() {
        turmaProfessor.removerProfessor();
        assertNull(turmaProfessor.getProfessor());
    }
}

