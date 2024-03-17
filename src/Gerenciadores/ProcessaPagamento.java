package Gerenciadores;

import pessoa.Pessoa;
import veiculo.TipoVeiculo;
import veiculo.Veiculo;

public class ProcessaPagamento {
    public static double calcularPagamento(int diarias, Pessoa cliente, Veiculo veiculo) {
        double desconto = cliente.obterDesconto(diarias);

        double tarifaDiaria = 0;
        if (veiculo.getTipo().equals(TipoVeiculo.PEQUENO)) {
            tarifaDiaria = 100;
        } else if (veiculo.getTipo().equals(TipoVeiculo.MEDIO)) {
            tarifaDiaria = 150;
        } else if (veiculo.getTipo().equals(TipoVeiculo.SUV)) {
            tarifaDiaria = 200;
        }

        return tarifaDiaria * diarias * (1 - desconto);
    }
}
