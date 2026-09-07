public class Main_Teste {
    public static void main(String[] args) {

        Turma turma = new Turma("POO-2026A", 3);

        Aluno ana = new Aluno("Ana");
        Aluno bruno = new Aluno("Bruno");
        Aluno carla = new Aluno("Carla");
        Aluno diego = new Aluno("Diego");

        // try catch colocados para permitir a execução após entrar na primeira
        // exceção, parecido com o original
        try {
            turma.matricular(ana);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            turma.matricular(bruno);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            turma.matricular(ana);
        } // deveria ser rejeitado: aluno ja matriculado
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            turma.lancarNota(ana, 8.5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            turma.lancarNota(bruno, 5.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            turma.matricular(carla);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            turma.matricular(diego);
        } // deveria ser rejeitado: turma cheia
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        turma.imprimirTurma();

    }
}