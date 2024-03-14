package InterfaceUsuario.GerenciaMenu;

import Gerenciadores.GerenciadorDeVeiculo;
import veiculo.Veiculo;

import java.util.Scanner;

import static utils.EntraValores.entradaString;
import static utils.EntraValores.entradaTipoVeiculo;

public class MenuVeiculos {
    private static final GerenciadorDeVeiculo gerenciadorDeVeiculo = new GerenciadorDeVeiculo();

    static Scanner scanner = new Scanner(System.in);

    public static void cadastraVeiculo() {
        gerenciadorDeVeiculo.cadastrarVeiculo(
                entradaString("Digite placa do veiculo: "),
                entradaTipoVeiculo("Escolha o tipo: ")
        );
    }

    public static void alteraVeiculo() {
        gerenciadorDeVeiculo.alterarVeiculo(
                entradaString("Placa antiga: "),
                entradaString("Placa nova: "),
                entradaTipoVeiculo("Novo tipo: ")
        );
    }

    public static void buscaVeiculo() {
        Veiculo veiculoEncontrado = gerenciadorDeVeiculo.buscarVeiculo(
                entradaString("Digite o termo para busca: ")
        );
        if (veiculoEncontrado != null) {
            System.out.println("Veículo encontrado: " + veiculoEncontrado);
        } else {
            System.out.println("Nenhum veículo encontrado.");
        }
    }

    public static void listaVeiculo() {
        gerenciadorDeVeiculo.listarVeiculos();
    }
}
