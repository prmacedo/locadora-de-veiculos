package registro;

import veiculo.Veiculo;
import pessoa.Pessoa;

import java.time.LocalDateTime;

public class Devolucao extends Registro  {
    public Devolucao(String local, LocalDateTime dataHora, Pessoa cliente, Veiculo veiculo) {
        super(local, dataHora, cliente, veiculo);
    }

    @Override
    public String toString() {
        return String.format("Devolução, %s, %s, %s, %s ", local, dataHora, cliente.getDocumento(), veiculo.getPlaca());
    }
}
