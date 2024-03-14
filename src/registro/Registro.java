package registro;
import veiculo.Veiculo;
import pessoa.*;
import java.time.LocalDateTime;

public abstract class Registro {
    private String local;

    private LocalDateTime dataHora;

    private Pessoa cliente;

    private Veiculo veiculo;

    public Registro(String local, LocalDateTime dataHora, Pessoa cliente, Veiculo veiculo) {
        this.local = local;
        this.dataHora = dataHora;
        this.cliente = cliente;
        this.veiculo = veiculo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }


}


