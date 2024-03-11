package registro;

import java.time.LocalDate;

public class Aluguel extends Registro {
    public Aluguel(String local, int horasEmMinutos, LocalDate data) {
        super(local, horasEmMinutos, data);
    }
}
