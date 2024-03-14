package MenuVeiculos;

import Gerenciadores.GerenciadorDeVeiculo;
import veiculo.Veiculo;

import java.util.Scanner;

import static utils.EntraValores.entradaString;

public class GerenciaVeiculos {
    private static final GerenciadorDeVeiculo gerenciadorDeVeiculo = new GerenciadorDeVeiculo();

    static Scanner scanner = new Scanner(System.in);

    public static void cadastraVeiculo() {
        gerenciadorDeVeiculo.cadastrarVeiculo(
                entradaString("Digite placa do veiculo: "),
                entradaString("Digite o tipo do veiculo")
        );
    }

    public static void alteraVeiculo() {
        gerenciadorDeVeiculo.alterarVeiculo(
                entradaString("Placa antiga: "),
                entradaString("Placa nova: "),
                entradaString("Novo tipo: ")
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
