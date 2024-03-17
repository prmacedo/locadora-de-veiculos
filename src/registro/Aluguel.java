package registro;

import veiculo.Veiculo;
import pessoa.Pessoa;

import java.time.LocalDateTime;

public class Aluguel extends Registro {
    public Aluguel(String local, LocalDateTime dataHora, Pessoa cliente, Veiculo veiculo, boolean alugado) {
        super(local, dataHora, cliente, veiculo, alugado);
    }

    @Override
    public String toString() {
        return String.format("Aluguel, %s, %s, %s, %s ", local, dataHora, cliente.getDocumento(), veiculo.getPlaca());
    }
}
