package Gerenciadores;

import arquivosDB.ArquivoVeiculos;
import veiculo.Veiculo;

import java.util.List;

public class GerenciadorDeVeiculo {
    private static List<Veiculo> veiculos = ArquivoVeiculos.carregarVeiculos();

    public static boolean cadastrarVeiculo(Veiculo veiculo) {
        if (veiculoExiste(veiculo) != null) {
           return false;
        }

        veiculos.add(veiculo);
        ArquivoVeiculos.salvarVeiculo(veiculos);

        return true;
    }

    public static boolean alterarVeiculo(String placaAntiga, Veiculo veiculoNovo) {
        Veiculo veiculoAAlterar = veiculoExiste(new Veiculo(placaAntiga));

        if (veiculoAAlterar == null) {
            return false;
        }

        Veiculo veiculoComMesmaPlaca = veiculoExiste(veiculoNovo);

        if (veiculoComMesmaPlaca != null) {
            return false;
        }

        veiculoAAlterar.setPlaca(veiculoNovo.getPlaca());
        veiculoAAlterar.setTipo(veiculoNovo.getTipo());

        ArquivoVeiculos.salvarVeiculo(veiculos);

        return true;
    }

    public static Veiculo buscarVeiculoPorParteDaPlaca(String termoDeBusca) {
        return veiculos.stream()
                .filter(veiculo -> veiculo.getPlaca().contains(termoDeBusca.toUpperCase().trim()))
                .findFirst().orElse(null);
    }

    public static Veiculo buscarVeiculo(Veiculo veiculoBuscado) {
        return veiculos.stream()
                .filter(veiculo -> veiculo.equals(veiculoBuscado))
                .findFirst().orElse(null);
    }

    public static List<Veiculo> obterVeiculos() {
        return veiculos;
    }


    private static Veiculo veiculoExiste(Veiculo veiculoProcurado) {
        return veiculos.stream().filter(veiculo -> veiculo.equals(veiculoProcurado)).findFirst().orElse(null);
    }
}
