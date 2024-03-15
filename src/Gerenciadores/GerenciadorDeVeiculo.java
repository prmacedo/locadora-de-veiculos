package Gerenciadores;

import InterfaceUsuario.Menu;
import utils.Paginacao;
import veiculo.TipoVeiculo;
import veiculo.Veiculo;

import java.util.ArrayList;
import java.util.List;

import static InterfaceUsuario.Menu.limpaTela;

public class GerenciadorDeVeiculo {
    private List<Veiculo> veiculos = new ArrayList<>();

    public void cadastrarVeiculo(String placa, TipoVeiculo tipo) {
        if (this.veiculoExiste(placa) != null) {
            return;
        }

        Veiculo veiculoNovo = new Veiculo(placa, tipo);
        this.veiculos.add(veiculoNovo);
    }

    public void alterarVeiculo(String placaAntiga, String placaNova, TipoVeiculo tipoNovo) {
        Veiculo veiculoAlterar = this.veiculoExiste(placaAntiga);

        if (veiculoAlterar == null) {
            return;
        }

        Veiculo veiculoComMesmaPlaca = this.veiculoExiste(placaNova);

        if (veiculoComMesmaPlaca != null) {
            System.out.println("Erro");
            return;
        }

        if (!placaNova.trim().isEmpty()) {
            veiculoAlterar.setPlaca(placaNova);
        }

        if (tipoNovo != null) {
            veiculoAlterar.setTipo(tipoNovo);
        }
    }

    public Veiculo buscarVeiculo(String termoDeBusca) {
        return this.veiculos.stream()
                .filter(veiculo -> veiculo.getPlaca().contains(termoDeBusca.toUpperCase()))
                .findFirst().orElse(null);
    }

    public void listarVeiculos() {
        if (this.veiculos.isEmpty()) {
            System.out.println("Nenhum veiculo cadastrado!");
            try {
                Thread.sleep(3000);
                limpaTela();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            Menu.menuVeiculos();
        }
        Paginacao.paginando(this.veiculos,5);
    }


private Veiculo veiculoExiste(String placa) {
    return this.veiculos.stream().filter(veiculo -> veiculo.getPlaca().equalsIgnoreCase(placa)).findFirst().orElse(null);
}
}
