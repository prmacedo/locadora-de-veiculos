package InterfaceUsuario.GerenciaMenu;

import Gerenciadores.GerenciadorDePessoa;
import Gerenciadores.GerenciadorDeRegistro;
import Gerenciadores.GerenciadorDeVeiculo;

import veiculo.Veiculo;

import static utils.EntraValores.entradaLocalDateTime;
import static utils.EntraValores.entradaString;
import static utils.EntraValores.entradaTipoVeiculo;

public class MenuRegistros {

    private static final GerenciadorDeRegistro registros = new GerenciadorDeRegistro();
    private static final GerenciadorDePessoa gerenciadorDePessoa = new GerenciadorDePessoa();
    private static final GerenciadorDeVeiculo gerenciadorDeVeiculo = new GerenciadorDeVeiculo();


    public static void alugaVeiculo() {
        registros.alugarVeiculo(
                entradaString("Digite o local: "),
                entradaLocalDateTime("Digite a data"),
                gerenciadorDePessoa.buscarPessoa(
                        entradaString("Digite o nome: ")
                ),
                new Veiculo(
                        entradaString("Digite placa do veiculo: "),
                        entradaTipoVeiculo("Escolha o tipo: ")
                )
        );
    }

    public static void devolveVeiculo() {
        registros.devolverVeiculo(
                entradaString("Digite o local: "),
                entradaLocalDateTime("Digite a data"),
                gerenciadorDePessoa.buscarPessoa(
                        entradaString("Digite o nome: ")
                ),
                new Veiculo(
                        entradaString("Digite placa do veiculo: "),
                        entradaTipoVeiculo("Escolha o tipo: ")
                )
        );
    }


    public static void buscaRegitro() {
        registros.buscarRegistros(
                gerenciadorDeVeiculo.buscarVeiculo(
                        entradaString("Digite a placa: ")
                )
        );
    }

    public static void calculaDiaria() {
    }
}
