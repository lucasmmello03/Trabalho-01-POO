public class Aluno {

    private String nome;


    public Aluno(String nome) {
        this.nome = validarAluno(nome);
    }

    public String getNome() {
        return this.nome;
    }

    private String validarAluno(String aluno) {
        if(aluno == null || aluno.isBlank()) {
            throw new IllegalArgumentException("Aluno inválido");
        }

        return aluno;
    }
    
}
