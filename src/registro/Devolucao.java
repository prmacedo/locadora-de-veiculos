package registro;

import pessoa.Pessoa;

import java.time.LocalDateTime;

public class Devolucao extends Registro {
    public Devolucao(String local, LocalDateTime dataHora, Pessoa cliente) {
        super(local, dataHora, cliente);
    }
}
