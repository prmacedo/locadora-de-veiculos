package InterfaceUsuario.GerenciaMenu;

import Gerenciadores.GerenciadorDePessoa;
import Gerenciadores.GerenciadorDeRegistro;
import Gerenciadores.GerenciadorDeVeiculo;

import Gerenciadores.ProcessaPagamento;
import pessoa.Pessoa;
import registro.Aluguel;
import registro.Devolucao;
import registro.Registro;
import veiculo.Veiculo;

import java.time.LocalDateTime;
import java.util.List;

import static utils.EntraValores.*;

public class MenuRegistros {
    public static void alugaVeiculo() {
        String local = entradaStringNotEmpty("Digite o local: ");
        LocalDateTime dataHora = entradaLocalDateTime("Digite a data: ");

        String documentoCliente = entradaStringNotEmpty("Digite o documento do cliente: ");
        Pessoa cliente = GerenciadorDePessoa.buscarPessoa(documentoCliente);

        if (cliente == null) {
            System.out.println("Não foi possível alugar o veículo, pois este cliente não existe.");
            return;
        }

        String placaVeiculo = entradaStringNotEmpty("Digite placa do veiculo: ").trim().toUpperCase();
        Veiculo veiculo = GerenciadorDeVeiculo.buscarVeiculo(placaVeiculo);

        if (veiculo == null) {
            System.out.println("Não foi possível alugar o veículo, pois ele não existe.");
            return;
        }

        Aluguel aluguel = new Aluguel(local, dataHora, cliente, veiculo);

        boolean veiculoAlugado = GerenciadorDeRegistro.alugarVeiculo(aluguel);

        System.out.println(veiculoAlugado ? "Veículo alugado com sucesso!" : "Não foi possível alugar o veículo.");
    }

    public static void devolveVeiculo() {
        String local = entradaStringNotEmpty("Digite o local: ");
        LocalDateTime dataHora = entradaLocalDateTime("Digite a data: ");

        String documentoCliente = entradaStringNotEmpty("Digite o documento do cliente: ");
        Pessoa cliente = GerenciadorDePessoa.buscarPessoa(documentoCliente);

        if (cliente == null) {
            System.out.println("Não foi possível devolver o veículo, pois este cliente não existe.");
            return;
        }

        String placaVeiculo = entradaStringNotEmpty("Digite placa do veiculo: ").trim().toUpperCase();
        Veiculo veiculo = GerenciadorDeVeiculo.buscarVeiculo(placaVeiculo);

        if (veiculo == null) {
            System.out.println("Não foi possível devolver o veículo, pois ele não existe.");
            return;
        }

        Aluguel aluguel = GerenciadorDeRegistro.buscarAluguel(veiculo, cliente);
        if (aluguel == null) {
            System.out.println("Não foi possível devolver o veículo.");
            return;
        }

        Devolucao devolucao = new Devolucao(local, dataHora, cliente, veiculo);


        boolean devolucaoRealizada = GerenciadorDeRegistro.devolverVeiculo(devolucao, aluguel);

        if (devolucaoRealizada) {
            int diarias = GerenciadorDeRegistro.calcularDiarias(aluguel, devolucao);
            double pagamento = ProcessaPagamento.calcularPagamento(diarias, cliente, veiculo);

            System.out.println("O valor a ser pago pelo(s) " + diarias + " dias é R$ " + pagamento);
        } else {
            System.out.println("Não foi possível realizar a devolução do veículo.");
        }
    }


    public static void buscaRegitro() {
        String placaVeiculo = entradaStringNotEmpty("Digite placa do veiculo: ");
        Veiculo veiculo = GerenciadorDeVeiculo.buscarVeiculo(placaVeiculo);

        List<Registro> registros = GerenciadorDeRegistro.buscarRegistros(veiculo);

        if (registros.isEmpty()) {
            System.out.println("Não há nenhum registro de Aluguel ou devolução.");
        } else {
                System.out.println("Registro, Local, Data e Hora, Placa, Doc. Cliente");
            for (Registro registro : registros) {
                System.out.println(registro);
            }
        }
    }
}
