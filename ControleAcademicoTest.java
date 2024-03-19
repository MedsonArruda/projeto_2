package package2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class ControleAcademicoTest {

    @Test
    public void testAssociacaoProfessorDisciplina() {
        // Arrange
        Professor professor = Professor.criarProfessor("João");
        Disciplina disciplina = Disciplina.criarDisciplina("Matemática");

        // Act
        professor.adicionarDisciplina(disciplina);

        // Assert
        List<Disciplina> disciplinas = professor.getDisciplinas();
        assertTrue(disciplinas.contains(disciplina));
    }

    @Test
    public void testAdicaoTurmaDisciplina() {
        // Arrange
        Disciplina disciplina = Disciplina.criarDisciplina("Matemática");
        TurmaAluno turma = TurmaAluno.criarTurmaAluno("Segunda - 8:00 - 10:00", "Sala 101", "T01", disciplina,
                Professor.criarProfessor("João"));

        // Act
        disciplina.adicionarTurma(turma);

        // Assert
        List<Turma> turmas = disciplina.getTurmas();
        assertTrue(turmas.contains(turma));
    }

    @Test
    public void testMatriculaAlunoTurma() {
        // Arrange
        Aluno aluno = Aluno.criarAluno("Pedro");
        Disciplina disciplina = Disciplina.criarDisciplina("Matemática");
        TurmaAluno turma = TurmaAluno.criarTurmaAluno("Segunda - 8:00 - 10:00", "Sala 101", "T01", disciplina,
                Professor.criarProfessor("João"));

        // Act
        disciplina.adicionarAluno(aluno, turma);

        // Assert
        List<TurmaAluno> turmasAluno = aluno.getTurmas();
        assertTrue(turmasAluno.contains(turma));
    }

    @Test
    public void testTotalAlunosDisciplina() {
        // Arrange
        Aluno aluno1 = Aluno.criarAluno("Pedro");
        Aluno aluno2 = Aluno.criarAluno("Ana");
        Disciplina disciplina = Disciplina.criarDisciplina("Matemática");
        TurmaAluno turma1 = TurmaAluno.criarTurmaAluno("Segunda - 8:00 - 10:00", "Sala 101", "T01", disciplina,
                Professor.criarProfessor("João"));
        TurmaAluno turma2 = TurmaAluno.criarTurmaAluno("Quarta - 10:00 - 12:00", "Sala 102", "T02", disciplina,
                Professor.criarProfessor("Maria"));
        disciplina.adicionarAluno(aluno1, turma1);
        disciplina.adicionarAluno(aluno2, turma2);

        // Act
        int totalAlunos = disciplina.getTotalAlunos();

        // Assert
        assertEquals(2, totalAlunos);
    }
}

