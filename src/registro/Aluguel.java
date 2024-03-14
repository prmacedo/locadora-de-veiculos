package registro;

import veiculo.Veiculo;
import pessoa.Pessoa;

import java.time.LocalDateTime;

public class Aluguel extends Registro {
    public Aluguel(String local, LocalDateTime dataHora, Pessoa cliente, Veiculo veiculo) {
        super(local, dataHora, cliente, veiculo);
    }
}
