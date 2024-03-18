package Gerenciadores;

import pessoa.Pessoa;
import registro.Aluguel;
import registro.Devolucao;
import veiculo.Veiculo;

import java.time.temporal.ChronoUnit;

public class ProcessaPagamento {
    public static double calcularPagamento(int diarias, Pessoa cliente, Veiculo veiculo) {
        double desconto = cliente.obterDesconto(diarias);

        double tarifaDiaria = veiculo.obterTarifaDiaria();

        return tarifaDiaria * diarias * (1 - desconto);
    }

    public static int calcularDiarias(Aluguel aluguel, Devolucao devolucao) {
        long diferencaEmMinutos = aluguel.getDataHora().until(devolucao.getDataHora(), ChronoUnit.MINUTES);
        double diferencaEmDias = diferencaEmMinutos / 1440d;
        double diasArredondados = Math.ceil(diferencaEmDias);

        return (int) diasArredondados;
    }

}
