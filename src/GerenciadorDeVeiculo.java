import veiculo.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeVeiculo {
    private List<Veiculo> veiculos = new ArrayList<>();

    public void cadastrarVeiculo(String placa, String tipo) {
        if (this.veiculoExiste(placa) != null) {
            return;
        }

        Veiculo veiculoNovo = new Veiculo(placa, tipo);
        this.veiculos.add(veiculoNovo);
    }

    public void alterarVeiculo(String placaAntiga, String placaNova, String tipoNovo) {
        Veiculo veiculoBuscado = this.veiculoExiste(placaAntiga);

        if (veiculoBuscado == null) {
            return;
        }

        if (!placaNova.trim().isEmpty()) {
            veiculoBuscado.setPlaca(placaNova);
        }

        if (!tipoNovo.trim().isEmpty()) {
            veiculoBuscado.setTipo(tipoNovo);
        }
    }

    public Veiculo buscarVeiculo(String termoDeBusca) {
        return this.veiculos.stream()
                .filter(veiculo -> veiculo.getPlaca().contains(termoDeBusca.toUpperCase()))
                .findFirst().orElse(null);
    }

    public void listarVeiculos() {
        if (this.veiculos.isEmpty()) {
            System.out.println("Ainda não há veículos cadastrados.");
            return;
        }

        System.out.println("|    PLACA    |   TIPO   |");
        System.out.println("| ----------- | -------- |");

        for (Veiculo veiculo : this.veiculos) {
            System.out.println("| " + String.format("%11s", veiculo.getPlaca()) + " | " + String.format("%8s", veiculo.getTipo()) + " |");
        }
    }

    private Veiculo veiculoExiste(String placa) {
        return this.veiculos.stream().filter(veiculo -> veiculo.getPlaca().equalsIgnoreCase(placa)).findFirst().orElse(null);
    }
}
