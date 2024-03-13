import registro.Aluguel;
import registro.Devolucao;

import java.time.temporal.ChronoUnit;

public class GerenciadorDeRegistro {

    private int calcularDiarias(Aluguel aluguel, Devolucao devolucao) {
        long diferencaEmMinutos = aluguel.getDataHora().until(devolucao.getDataHora(), ChronoUnit.MINUTES);
        double diferencaEmDias = diferencaEmMinutos / 1440d;
        double diasArredondados = Math.ceil(diferencaEmDias);

        return (int) diasArredondados;
    }

}
