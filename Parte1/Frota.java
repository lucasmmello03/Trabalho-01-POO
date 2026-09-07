import java.util.HashMap;
import java.util.Map;

public class Frota {

    private Map<String, Veiculo> veiculos = new HashMap<>();

    public void cadastrarVeiculo(Veiculo veiculo) {

        if (veiculo == null) {
            throw new IllegalArgumentException("Veículo inválido");
        }

        if (veiculos.containsKey(veiculo.getPlaca())) {
            throw new IllegalArgumentException("Já existe um veículo cadastrado com essa placa");
        }

        veiculos.put(veiculo.getPlaca(), veiculo);
    }

    public Veiculo buscarPorPlaca(String placa) {

        Veiculo veiculo = veiculos.get(placa);

        if (veiculo == null) {
            throw new IllegalArgumentException("Veículo não encontrado");
        }

        return veiculo;
    }

    public void imprimirRelatorio(String placa) {
        Veiculo veiculo = buscarPorPlaca(placa);

        System.out.println("Placa: " + veiculo.getPlaca());
        System.out.println("Modelo: " + veiculo.getModelo());
        System.out.println("KM atual: " + veiculo.getQuilometragemAtual());
        System.out.println("Precisa manutencao? " + (veiculo.precisaManutencao() ? "SIM" : "NAO"));
        System.out.println("Custo total de manutencao: R$ " + veiculo.custoTotal());
        System.out.println("Historico:");

        for (Manutencao m : veiculo.getHistoricoManutencoes()) {
            System.out.println("  " + m.getData() + " - " + m.getTipo() + " - R$ " + m.getCusto());
        }
    }
}