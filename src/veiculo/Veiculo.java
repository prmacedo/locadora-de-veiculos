package veiculo;

import java.util.Objects;

public class Veiculo {
    private String placa;
    private TipoVeiculo tipo;

    public Veiculo(String placa, TipoVeiculo tipo) {
        this.placa = placa.toUpperCase();
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa.toUpperCase();
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(placa, veiculo.placa.toUpperCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa);
    }

    @Override
    public String toString() {
        return "Veiculo: \n" +
                "placa: " + placa + "\n" +
                "tipo: '" + tipo + "\n";
    }
}
