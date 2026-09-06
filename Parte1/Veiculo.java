import java.util.ArrayList;

public class Veiculo {

    private String placa;
    private String modelo;
    private Double quilometragemAtual;
    private Double intervaloManutencaoKm;
    private Double quilometragemUltimaPreventiva;
    private ArrayList<Manutencao> historicoManutencoes = new ArrayList<>();

    public Veiculo(String placa, String modelo, Double quilometragemAtual, Double intervaloManutencaoKm) {

        this.placa = validarPlaca(placa);
        this.modelo = validarModelo(modelo);
        this.quilometragemAtual = validarQuilometragemAtual(quilometragemAtual);
        this.intervaloManutencaoKm = validarIntervaloManutencaoKm(intervaloManutencaoKm);
        this.quilometragemUltimaPreventiva = this.quilometragemAtual;
    }

    // Gets
    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public Double getQuilometragemAtual() {
        return quilometragemAtual;
    }

    public Double getIntervaloManutencaoKm() {
        return intervaloManutencaoKm;
    }

    public Double getQuilometragemUltimaPreventiva() {
        return quilometragemUltimaPreventiva;
    }

    public ArrayList<Manutencao> getHistoricoManutencoes() {
        return historicoManutencoes;
    }

    public void atualizarQuilometragem(Double novaKm) {
        if (novaKm == null || novaKm < this.quilometragemAtual) {
            throw new IllegalArgumentException("Quilometragem inválida");
        }

        this.quilometragemAtual = novaKm;
    }

    public boolean precisaManutencao() {
        double diferenca = quilometragemAtual - quilometragemUltimaPreventiva;

        if (diferenca >= intervaloManutencaoKm) {
            return true;
        }

        return false;
    }

    public void registrarManutencao(Manutencao manutencao) {

        if (manutencao == null) {
            throw new IllegalArgumentException("Manutenção inválida");
        }

        this.historicoManutencoes.add(manutencao);

        if (manutencao.getTipo() == TipoManutencao.PREVENTIVA) {
            this.quilometragemUltimaPreventiva = this.quilometragemAtual;
        }
    }

    public Double custoTotal() {

        double total = 0.00;

        for (Manutencao m : historicoManutencoes) {
            total += m.getCusto();
        }
        return total;
    }

    // Validacoes
    private String validarPlaca(String placa) {

        if (placa == null || placa.isBlank() || placa.length() < 7 || placa.length() > 8) {
            throw new IllegalArgumentException("Placa inválida");
        }

        return placa;
    }

    private String validarModelo(String modelo) {

        if (modelo == null || modelo.isBlank()) {
            throw new IllegalArgumentException("Modelo inválido");
        }

        return modelo;
    }

    private Double validarQuilometragemAtual(Double quilometragemAtual) {

        if (quilometragemAtual == null || quilometragemAtual < 0) {
            throw new IllegalArgumentException("Quilometragem inválida");
        }

        return quilometragemAtual;
    }

    private Double validarIntervaloManutencaoKm(Double intervaloManutencaoKm) {

        if (intervaloManutencaoKm == null || intervaloManutencaoKm <= 0) {
            throw new IllegalArgumentException("Intervalo de manutenção inválido");
        }

        return intervaloManutencaoKm;
    }
}
