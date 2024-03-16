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

    public static boolean cadastrarVeiculo(String placa, TipoVeiculo tipo) {
        if (veiculoExiste(placa) != null) {
            return false;
        }

        Veiculo veiculoNovo = new Veiculo(placa, tipo);
        veiculos.add(veiculoNovo);
        return true;
    }

    public static boolean alterarVeiculo(String placaAntiga, String placaNova, TipoVeiculo tipoNovo) {
        Veiculo veiculoAlterar = veiculoExiste(placaAntiga);

        if (veiculoAlterar == null) {
            return false;
        }

        Veiculo veiculoComMesmaPlaca = veiculoExiste(placaNova);

        if (veiculoComMesmaPlaca != null) {
            return false;
        }

        if (!placaNova.trim().isEmpty()) {
            veiculoAlterar.setPlaca(placaNova);
        }

        if (tipoNovo != null) {
            veiculoAlterar.setTipo(tipoNovo);
        }

        return true;
    }

    public static Veiculo buscarVeiculo(String termoDeBusca) {
        return veiculos.stream()
                .filter(veiculo -> veiculo.getPlaca().contains(termoDeBusca.toUpperCase()))
                .findFirst().orElse(null);
    }

    public static List<Veiculo> obterVeiculos() {
        return veiculos;
    }


    private static Veiculo veiculoExiste(String placa) {
        return veiculos.stream().filter(veiculo -> veiculo.getPlaca().equalsIgnoreCase(placa)).findFirst().orElse(null);
    }
}
