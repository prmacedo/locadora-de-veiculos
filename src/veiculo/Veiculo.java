package veiculo;

import java.util.Objects;

public class Veiculo {
    private String placa;
    private String tipo; // Talvez seja mais interessante trabalhar com herança

    public Veiculo(String placa, String tipo) {
        this.placa = placa.toUpperCase();
        this.tipo = tipo.toUpperCase();
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa.toUpperCase();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo.toUpperCase();
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
