package Gerenciadores;

import arquivosDB.ArquivoVeiculos;
import veiculo.*;

import java.util.List;

public class GerenciadorDeVeiculo {
    private static List<Veiculo> veiculos = ArquivoVeiculos.carregarVeiculos();

    public static boolean cadastrarVeiculo(Veiculo veiculo) {
        if (veiculoExiste(veiculo.getPlaca()) != null) {
           return false;
        }

        veiculos.add(veiculo);
        ArquivoVeiculos.salvarVeiculo(veiculos);

        return true;
    }

    public static boolean alterarVeiculo(String placaAntiga, Veiculo veiculoNovo) {
        Veiculo veiculoAAlterar = veiculoExiste(placaAntiga.trim().toUpperCase());

        if (veiculoAAlterar == null) {
            return false;
        }

        Veiculo veiculoComMesmaPlaca = veiculoExiste(veiculoNovo.getPlaca());

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

    public static Veiculo buscarVeiculo(String placa) {
        return veiculos.stream()
                .filter(veiculo -> veiculo.getPlaca().equals(placa.trim().toUpperCase()))
                .findFirst().orElse(null);
    }

    public static List<Veiculo> obterVeiculos() {
        return veiculos;
    }


    public static Veiculo criarVeiculo(String placa, TipoVeiculo tipo) {
        Veiculo veiculo;
        if (tipo.equals(TipoVeiculo.PEQUENO)) {
            veiculo = new VeiculoPequeno(placa);
        } else if (tipo.equals(TipoVeiculo.MEDIO)) {
            veiculo = new VeiculoMedio(placa);
        } else {
            veiculo = new VeiculoSUV(placa);
        }

        return veiculo;
    }

    private static Veiculo veiculoExiste(String placa) {
        return veiculos.stream().filter(veiculo -> veiculo.getPlaca().equals(placa)).findFirst().orElse(null);
    }
}
