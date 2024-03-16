package Gerenciadores;

import InterfaceUsuario.Menu;
import utils.Paginacao;
import veiculo.TipoVeiculo;
import veiculo.Veiculo;

import java.util.ArrayList;
import java.util.List;

import static InterfaceUsuario.Menu.limpaTela;

public class GerenciadorDeVeiculo {
    private static List<Veiculo> veiculos = new ArrayList<>();

    public static boolean cadastrarVeiculo(Veiculo veiculo) {
        if (veiculoExiste(veiculo) != null) {
            return false;
        }

        veiculos.add(veiculo);
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

        return true;
    }

    public static Veiculo buscarVeiculo(String termoDeBusca) {
        return veiculos.stream()
                .filter(veiculo -> veiculo.getPlaca().contains(termoDeBusca.toUpperCase().trim()))
                .findFirst().orElse(null);
    }

    public static List<Veiculo> obterVeiculos() {
        return veiculos;
    }


    private static Veiculo veiculoExiste(Veiculo veiculoProcurado) {
        return veiculos.stream().filter(veiculo -> veiculo.equals(veiculoProcurado)).findFirst().orElse(null);
    }
}
