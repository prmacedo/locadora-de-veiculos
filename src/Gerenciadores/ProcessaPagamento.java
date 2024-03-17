package Gerenciadores;

import desconto.Desconto;
import desconto.DescontoPessoaFisica;
import desconto.DescontoPessoaJuridica;
import pessoa.Pessoa;
import pessoa.PessoaFisica;
import pessoa.PessoaJuridica;
import veiculo.TipoVeiculo;
import veiculo.Veiculo;

public class ProcessaPagamento {
    public static double calcularPagamento(int diarias, Pessoa cliente, Veiculo veiculo) {
        Desconto modalidadeDesconto;

        if (cliente instanceof PessoaFisica) {
            modalidadeDesconto = new DescontoPessoaFisica();
        } else {
            modalidadeDesconto = new DescontoPessoaJuridica();
        }

        double desconto = modalidadeDesconto.calcularDesconto(diarias);

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
