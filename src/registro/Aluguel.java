package registro;

import pessoa.Pessoa;

import java.time.LocalDateTime;

public class Aluguel extends Registro {
    public Aluguel(String local, LocalDateTime dataHora, Pessoa cliente) {
        super(local, dataHora, cliente);
    }
}
