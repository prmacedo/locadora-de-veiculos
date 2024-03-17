package InterfaceUsuario.GerenciaMenu;

import Gerenciadores.GerenciadorDeVeiculo;
import InterfaceUsuario.Menu;
import utils.Paginacao;
import veiculo.*;

import java.util.List;
import java.util.Scanner;

import static InterfaceUsuario.Menu.limpaTela;
import static utils.EntraValores.entradaStringNotEmpty;
import static utils.EntraValores.entradaTipoVeiculo;

public class MenuVeiculos {
    static Scanner scanner = new Scanner(System.in);

    public static void cadastraVeiculo() {
        String placa = entradaStringNotEmpty("Digite placa do veiculo: ");
        TipoVeiculo tipo = entradaTipoVeiculo("Escolha o tipo: ");

        Veiculo veiculo = GerenciadorDeVeiculo.criarVeiculo(placa, tipo);

        boolean veiculoCadastrado = GerenciadorDeVeiculo.cadastrarVeiculo(veiculo);

        System.out.println(veiculoCadastrado ? "Veículo cadastrado com sucesso!" : "Erro ao cadastrar veículo.");
    }

    public static void alteraVeiculo() {
        String placaAntiga = entradaStringNotEmpty("Placa antiga: ");
        String placaNova = entradaStringNotEmpty("Placa nova: ");
        TipoVeiculo tipoNovo = entradaTipoVeiculo("Novo tipo: ");

        Veiculo veiculoNovo = GerenciadorDeVeiculo.criarVeiculo(placaNova, tipoNovo);

        boolean veiculoAlterado = GerenciadorDeVeiculo.alterarVeiculo(placaAntiga, veiculoNovo);

        System.out.println(veiculoAlterado ? "Veículo alterado com sucesso!" : "Erro ao alterar veículo.");
    }

    public static void buscaVeiculo() {
        String termoDeBusca = entradaStringNotEmpty("Digite o termo para busca: ");

        Veiculo veiculoEncontrado = GerenciadorDeVeiculo.buscarVeiculoPorParteDaPlaca(termoDeBusca);

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
