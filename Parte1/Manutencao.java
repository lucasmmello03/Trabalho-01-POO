import java.time.LocalDate;

public class Manutencao {

    private LocalDate data;
    private TipoManutencao tipo;
    private Double custo;
    private Double quilometragemMomentoRegistro;

    public Manutencao(LocalDate data, TipoManutencao tipo, Double custo, Double quilometragemMomentoRegistro) {

        this.data = validarData(data);
        this.tipo = validarTipoManutencao(tipo);
        this.custo = validarCusto(custo);
        this.quilometragemMomentoRegistro = validarQuilometragemMomentoRegistro(quilometragemMomentoRegistro);
        
    }

    public LocalDate getData() {
        return data;
    }

    public TipoManutencao getTipo() {
        return tipo;
    }

    public Double getCusto() {
        return custo;
    }

    public Double getQuilometragemMomentoRegistro() {
        return quilometragemMomentoRegistro;
    }

    private LocalDate validarData(LocalDate data) {

        if (data == null || data.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data inválida");
        }

        return data;
    }

    private TipoManutencao validarTipoManutencao(TipoManutencao tipo) {

        if (tipo == null) {
            throw new IllegalArgumentException("Tipo de manutenção inválido");
        }

        return tipo;
    }

    private Double validarCusto(Double custo) {

        if (custo == null || custo <= 0) {
            throw new IllegalArgumentException("Custo inválido");
        }

        return custo;
    }

    private Double validarQuilometragemMomentoRegistro(Double km) {
        if (km == null || km < 0) {
            throw new IllegalArgumentException("Quilometragem no registro inválida");
        }
        return km;
    }
}