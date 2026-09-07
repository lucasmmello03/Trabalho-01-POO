public class Matricula {

    private Aluno aluno;
    private Double nota;

    // Construtor
    public Matricula(Aluno aluno) {
        this.aluno = aluno;
    }

    // Gets
    public Aluno getAluno() {
        return aluno;
    }

    public Double getNota() {
        return nota;
    }

    // Metodos
    public void lancarNota(Double nota) {

        if (nota < 0.0 || nota > 10.0) {
            throw new IllegalArgumentException("Nota inválida.");
        }

        this.nota = nota;
    }

    public boolean ehAprovado() {
        return this.nota != null && this.nota >= 6.0;
    }
}