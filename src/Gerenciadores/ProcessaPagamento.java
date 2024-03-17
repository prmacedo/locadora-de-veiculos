package Gerenciadores;

import pessoa.Pessoa;
import veiculo.Veiculo;

public class ProcessaPagamento {
    public static double calcularPagamento(int diarias, Pessoa cliente, Veiculo veiculo) {
        double desconto = cliente.obterDesconto(diarias);

        double tarifaDiaria = veiculo.obterTarifaDiaria();

        return tarifaDiaria * diarias * (1 - desconto);
    }
}
