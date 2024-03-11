package registro;

import java.time.LocalDate;

public class Devolucao extends Registro {
    public Devolucao(String local, int horasEmMinutos, LocalDate data) {
        super(local, horasEmMinutos, data);
    }
}
