package InterfaceUsuario.GerenciaMenu;

import Gerenciadores.GerenciadorDeVeiculo;
import InterfaceUsuario.Menu;
import utils.Paginacao;
import veiculo.TipoVeiculo;
import veiculo.Veiculo;

import java.util.List;
import java.util.Scanner;

import static InterfaceUsuario.Menu.limpaTela;
import static utils.EntraValores.entradaString;
import static utils.EntraValores.entradaStringNotEmpty;
import static utils.EntraValores.entradaTipoVeiculo;

public class MenuVeiculos {
    static Scanner scanner = new Scanner(System.in);

    public static void cadastraVeiculo() {
        String placa = entradaStringNotEmpty("Digite placa do veiculo: ");
        TipoVeiculo tipo = entradaTipoVeiculo("Escolha o tipo: ");

        boolean veiculoCadastrado = GerenciadorDeVeiculo.cadastrarVeiculo(placa, tipo);

        System.out.println(veiculoCadastrado ? "Veículo cadastrado com sucesso!" : "Erro ao cadastrar veículo.");
    }

    public static void alteraVeiculo() {
        String placaAntiga = entradaStringNotEmpty("Placa antiga: ");
        String placaNova = entradaString("Placa nova: ");
        TipoVeiculo tipoNovo = entradaTipoVeiculo("Novo tipo: ");

        boolean veiculoAlterado = GerenciadorDeVeiculo.alterarVeiculo(placaAntiga, placaNova, tipoNovo);

        System.out.println(veiculoAlterado ? "Veículo alterado com sucesso!" : "Erro ao alterar veículo.");
    }

    public static void buscaVeiculo() {
        String termoDeBusca = entradaStringNotEmpty("Digite o termo para busca: ");

        Veiculo veiculoEncontrado = GerenciadorDeVeiculo.buscarVeiculo(termoDeBusca);

        if (veiculoEncontrado != null) {
            System.out.println("Veículo encontrado: \n" + veiculoEncontrado);
        } else {
            System.out.println("Nenhum veículo encontrado.");
        }
    }

    public static void listaVeiculo() {
        List<Veiculo> veiculos = GerenciadorDeVeiculo.obterVeiculos();

        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veiculo cadastrado!");
            try {
                Thread.sleep(3000);
                limpaTela();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            Menu.menuVeiculos();
        }

        Paginacao.paginando(veiculos,5);
    }
}
