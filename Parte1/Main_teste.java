import java.time.LocalDate;

public class Main_teste {
    public static void main(String[] args) {

        Frota frota = new Frota();

        Veiculo veiculo1 = new Veiculo("ABC1D23", "Fiorino 1.4", 45000.00, 10000.00);
        Veiculo veiculo2 = new Veiculo("XYZ9K88", "Sprinter 2.2", 120000.00, 15000.00);

        frota.cadastrarVeiculo(veiculo1);
        frota.cadastrarVeiculo(veiculo2);

        veiculo1.atualizarQuilometragem(48000.00);
        LocalDate dataPreventiva = LocalDate.of(2026, 1, 10);
        Manutencao manutencaoPreventiva = new Manutencao(dataPreventiva, TipoManutencao.PREVENTIVA, 850.00,
                veiculo1.getQuilometragemAtual());
        veiculo1.registrarManutencao(manutencaoPreventiva);

        veiculo1.atualizarQuilometragem(58500.00);
        LocalDate dataCorretiva = LocalDate.of(2026, 3, 2);
        Manutencao manutencaoCorretiva = new Manutencao(dataCorretiva, TipoManutencao.CORRETIVA, 1200.00,
                veiculo1.getQuilometragemAtual());
        veiculo1.registrarManutencao(manutencaoCorretiva);

        veiculo2.atualizarQuilometragem(134000.00);

        frota.imprimirRelatorio(veiculo1.getPlaca());
        System.out.println("----");
        frota.imprimirRelatorio(veiculo2.getPlaca());

        System.out.println("----");
        System.out.println("ABC1D23 precisa manutencao? " + veiculo1.precisaManutencao());
        System.out.println("XYZ9K88 precisa manutencao? " + veiculo2.precisaManutencao());
    }
}