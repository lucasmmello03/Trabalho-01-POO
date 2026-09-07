import java.util.LinkedHashMap;
import java.util.Map;

public class Turma {
    private String codigo;
    private int capacidadeMaximaVagas;
    private Map<String, Matricula> conjuntoDeMatriculas = new LinkedHashMap<>();

    // Construtor
    public Turma(String codigo, int capacidadeMaximaVagas) {

        this.codigo = validarCodigo(codigo);
        this.capacidadeMaximaVagas = validarCapacidadeMaximaVagas(capacidadeMaximaVagas);
    }

    // Gets
    public String getCodigo() {
        return codigo;
    }

    public int getCapacidadeMaximaVagas() {
        return capacidadeMaximaVagas;
    }

    // Metodos
    public void matricular(Aluno aluno) {

        if (aluno == null) {
            throw new IllegalArgumentException("Aluno inválido.");
        }

        if (conjuntoDeMatriculas.containsKey(aluno.getNome())) {
            throw new IllegalArgumentException("Aluno ja matriculado nesta turma.");
        }

        if (this.conjuntoDeMatriculas.size() >= capacidadeMaximaVagas) {
            throw new IllegalArgumentException("Turma cheia: " + this.codigo);
        }

        conjuntoDeMatriculas.put(aluno.getNome(), new Matricula(aluno));
    }

    public void lancarNota(Aluno aluno, double nota) {

        Matricula matricula = conjuntoDeMatriculas.get(aluno.getNome());

        if (matricula == null) {
            throw new IllegalArgumentException("Matricula não encontrada.");
        }

        matricula.lancarNota(nota);
    }

    public int quantidadeDeAprovados() {
        int aprovados = 0;

        for (Matricula m : conjuntoDeMatriculas.values()) {
            if (m.ehAprovado()) {
                aprovados++;
            }
        }
        return aprovados;
    }

    public void imprimirTurma() {
        System.out.println("Turma: " + this.codigo);
        for (Matricula m : conjuntoDeMatriculas.values()) {
            String situacao = m.getNota() == null ? "sem nota" : String.valueOf(m.getNota());
            System.out.println("  " + m.getAluno().getNome() + " - nota: " + situacao);
        }
        System.out.println("Aprovados: " + quantidadeDeAprovados());
    }

    // Validacoes
    private String validarCodigo(String codigo) {

        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Código inválido.");
        }

        return codigo;
    }

    private int validarCapacidadeMaximaVagas(int capacidadeMaximaVagas) {

        if (capacidadeMaximaVagas <= 0) {
            throw new IllegalArgumentException("Capacidade máxima de vagas inválida.");
        }

        return capacidadeMaximaVagas;
    }
}