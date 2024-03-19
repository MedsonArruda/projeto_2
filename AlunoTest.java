package package2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AlunoTest {

    private Aluno aluno;
    private TurmaAluno turma;

    @Before
    public void setUp() {
        aluno = new Aluno("João");
        turma = new TurmaAluno("Segunda - 8:00 - 10:00", "Sala 101", "T01", null, null);
    }

    @Test
    public void testCriarAluno() {
        assertEquals("João", aluno.getNome());
        assertTrue(aluno.getTurmas().isEmpty());
    }

    @Test
    public void testAdicionarTurma() {
        aluno.adicionarTurma(turma);
        List<TurmaAluno> turmas = aluno.getTurmas();
        assertEquals(1, turmas.size());
        assertTrue(turmas.contains(turma));
    }

    @Test
    public void testAdicionarTurmaDuplicada() {
        aluno.adicionarTurma(turma);
        aluno.adicionarTurma(turma); // Adicionando a mesma turma duas vezes
        List<TurmaAluno> turmas = aluno.getTurmas();
        assertEquals(1, turmas.size()); // Deve ter apenas uma turma
    }

    @Test
    public void testGetNome() {
        assertEquals("João", aluno.getNome());
    }
}
