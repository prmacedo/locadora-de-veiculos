package registro;

import java.time.LocalDate;

public abstract class Registro {
    private String local;
    private int horasEmMinutos;
    private LocalDate data;

    public Registro(String local, int horasEmMinutos, LocalDate data) {
        this.local = local;
        this.horasEmMinutos = horasEmMinutos;
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getHorasEmMinutos() {
        return horasEmMinutos;
    }

    public void setHorasEmMinutos(int horasEmMinutos) {
        this.horasEmMinutos = horasEmMinutos;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
