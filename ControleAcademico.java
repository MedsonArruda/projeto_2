package package2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ControleAcademico {
    public static void main(String[] args) {
        // Criando professores
        Professor professor1 = Professor.criarProfessor("João");
        Professor professor2 = Professor.criarProfessor("Maria");
        Professor professor3 = Professor.criarProfessor("Carlos");
        Professor professor4 = Professor.criarProfessor("Isaac");

        // Criando alunos
        Aluno aluno1 = Aluno.criarAluno("Pedro");
        Aluno aluno2 = Aluno.criarAluno("Ana");
        Aluno aluno3 = Aluno.criarAluno("Lucas");

        // Criando disciplinas
        Disciplina disciplina1 = Disciplina.criarDisciplina("Matemática");
        Disciplina disciplina2 = Disciplina.criarDisciplina("História");
        Disciplina disciplina3 = Disciplina.criarDisciplina("Física");
        Disciplina disciplina4 = Disciplina.criarDisciplina("Quimica");

        // Associando uma disciplina para cada professor
        professor1.adicionarDisciplina(disciplina1);
        professor2.adicionarDisciplina(disciplina2);
        professor3.adicionarDisciplina(disciplina3);
        professor1.adicionarDisciplina(disciplina4);
        professor4.adicionarDisciplina(disciplina1);

        // Adicionando disciplinas às turmas
        TurmaAluno turma01 = TurmaAluno.criarTurmaAluno("Segunda - 8:00 - 10:00", "Sala 101", "T01", disciplina1, professor1);
        disciplina1.adicionarTurma(turma01);
        professor1.adicionarTurma(turma01); // Adicionando a turma ao professor

        TurmaAluno turma02 = TurmaAluno.criarTurmaAluno("Quarta - 10:00 - 12:00", "Sala 102", "T02", disciplina2, professor2);
        disciplina2.adicionarTurma(turma02);
        professor2.adicionarTurma(turma02); // Adicionando a turma ao professor

        TurmaAluno turma03 = TurmaAluno.criarTurmaAluno("Sexta - 14:00 - 16:00", "Sala 103", "T03", disciplina3, professor3);
        disciplina3.adicionarTurma(turma03);
        professor3.adicionarTurma(turma03); // Adicionando a turma ao professor

        //Testes para dar erro.
        TurmaAluno turma04 = TurmaAluno.criarTurmaAluno("Segunda - 8:00 - 10:00", "Sala 101", "T01", disciplina4, professor1);
        disciplina4.adicionarTurma(turma01);
        professor1.adicionarTurma(turma01); // Adicionando a turma ao professor

        TurmaAluno turma05 = TurmaAluno.criarTurmaAluno("Segunda - 8:00 - 10:00", "Sala 101", "T01", disciplina4, professor1);
        disciplina1.adicionarTurma(turma05);
        professor4.adicionarTurma(turma05); // Adicionando a turma ao professor

        // Adicionando alunos às turmas
        disciplina1.adicionarAluno(aluno1, turma01);
        disciplina1.adicionarAluno(aluno2, turma01);
        disciplina2.adicionarAluno(aluno2, turma02);
        disciplina2.adicionarAluno(aluno3, turma02);
        disciplina3.adicionarAluno(aluno3, turma03);
        disciplina4.adicionarAluno(aluno1, turma04);

        // Verificações e validações
        // 1. Aluno não pode se matricular em disciplinas que têm o mesmo horário
        Set<String> horariosAluno = new HashSet<>();
        for (Turma turma : aluno1.getTurmas()) {
            if (!horariosAluno.add(turma.getHorario())) {
                System.out.println("Erro: O aluno " + aluno1.getNome() + " já está matriculado em uma disciplina no mesmo horário: " + turma.getHorario());
                // Tratar o erro conforme necessário
            }
        }

        // 2. Professor não pode ter mais de uma disciplina no mesmo horário
        Set<String> horariosProfessor = new HashSet<>();
        for (Professor professor : List.of(professor1, professor2, professor3)) {
            for (Disciplina disciplina : professor.getDisciplinas()) {
                for (Turma turma : disciplina.getTurmas()) {
                    if (!horariosProfessor.add(turma.getHorario())) {
                        System.out.println("Erro: O professor " + professor.getNome() + " está associado a disciplinas no mesmo horário: " + turma.getHorario());
                        // Tratar o erro conforme necessário
                    }
                }
            }
        }

        // 3. Uma turma não pode ter disciplinas no mesmo horário
        for (Disciplina disciplina : List.of(disciplina1, disciplina2, disciplina3)) {
            Set<String> horariosTurma = new HashSet<>();
            for (Turma turma : disciplina.getTurmas()) {
                if (!horariosTurma.add(turma.getHorario())) {
                    System.out.println("Erro: A disciplina " + disciplina.getNome() + " possui turmas no mesmo horário: " + turma.getHorario());
                    // Tratar o erro conforme necessário
                }
            }
        }

        // Exibindo informações
        System.out.println("a. Disciplinas do Professor João:");
        for (Turma turma : professor1.getTurmas()) {
            if (turma.getDisciplina().equals(disciplina1)) {
                System.out.println(disciplina1.getNome());
            }
        }

        System.out.println("\nb. Horário da Disciplina de Matemática:");
        for (Turma turma : disciplina1.getTurmas()) {
            System.out.println(turma.getHorario());
        }

        System.out.println("\na. Disciplinas do Professor Maria:");
        for (Turma turma : professor2.getTurmas()) {
            if (turma.getDisciplina().equals(disciplina2)) {
                System.out.println(disciplina2.getNome());
            }
        }

        System.out.println("\nb. Horário da Disciplina de História:");
        for (Turma turma : disciplina2.getTurmas()) {
            System.out.println(turma.getHorario());
        }

        System.out.println("\na. Disciplinas do Professor Carlos:");
        for (Turma turma : professor3.getTurmas()) {
            if (turma.getDisciplina().equals(disciplina3)) {
                System.out.println(disciplina3.getNome());
            }
        }

        System.out.println("\nb. Horário da Disciplina de Física:");
        for (Turma turma : disciplina3.getTurmas()) {
            System.out.println(turma.getHorario());
        }

        System.out.println("\nc. Alunos da disciplina de Matemática:");
        for (Turma turma : disciplina1.getTurmas()) {
            for (Aluno aluno : ((TurmaAluno) turma).getAlunos()) {
                System.out.println(aluno.getNome());
            }
        }
        
        System.out.println("\nc. Alunos da disciplina de História:");
        for (Turma turma : disciplina2.getTurmas()) {
            for (Aluno aluno : ((TurmaAluno) turma).getAlunos()) {
                System.out.println(aluno.getNome());
            }
        }
        
        System.out.println("\nc. Alunos da disciplina de Física:");
        for (Turma turma : disciplina3.getTurmas()) {
            for (Aluno aluno : ((TurmaAluno) turma).getAlunos()) {
                System.out.println(aluno.getNome());
            }
        }

        System.out.println("\nd. Disciplinas do Aluno Ana:");
        for (Turma turma : aluno2.getTurmas()) {
            System.out.println(turma.getDisciplina().getNome());
        }

        System.out.println("\nd. Disciplinas do Aluno Pedro:");
        for (Turma turma : aluno1.getTurmas()) {
            System.out.println(turma.getDisciplina().getNome());
        }

        System.out.println("\nd. Disciplinas do Aluno Lucas:");
        for (Turma turma : aluno3.getTurmas()) {
            System.out.println(turma.getDisciplina().getNome());
        }

        System.out.println("\ne. Qual o horário do aluno " + aluno1.getNome() + ":");
        for (Turma turma : aluno1.getTurmas()) {
            System.out.println(turma.getHorario());
        }

        System.out.println("\ne. Qual o horário do aluno " + aluno2.getNome() + ":");
        for (Turma turma : aluno2.getTurmas()) {
            System.out.println(turma.getHorario());
        }

        System.out.println("\ne. Qual o horário do aluno " + aluno3.getNome() + ":");
        for (Turma turma : aluno3.getTurmas()) {
            System.out.println(turma.getHorario());
        }

        System.out.println("\nf. Número de alunos na disciplina de Matemática: " + disciplina1.getTotalAlunos());
        System.out.println("\nf. Número de alunos na disciplina de História: " + disciplina2.getTotalAlunos());
        System.out.println("\nf. Número de alunos na disciplina de Física: " + disciplina3.getTotalAlunos());
    }
}