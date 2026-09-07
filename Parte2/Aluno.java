public class Aluno {

    private String nome;

    // Construtor
    public Aluno(String nome) {
        this.nome = validarAluno(nome);
    }

    // Gets
    public String getNome() {
        return this.nome;
    }

    // Validacoes
    private String validarAluno(String aluno) {
        if (aluno == null || aluno.isBlank()) {
            throw new IllegalArgumentException("Aluno inválido");
        }

        return aluno;
    }
}
