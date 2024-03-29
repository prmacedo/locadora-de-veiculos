package veiculo;

import tarifaDiaria.ObterTarifaDiaria;

import java.util.Objects;

public abstract class Veiculo implements ObterTarifaDiaria {
    private String placa;
    private TipoVeiculo tipo;

    public Veiculo(String placa) {
        this.placa = placa.toUpperCase().trim();
    }

    public Veiculo(String placa, TipoVeiculo tipo) {
        this(placa);
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa.toUpperCase().trim();
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
        return Objects.equals(placa, veiculo.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa);
    }

    @Override
    public String toString() {
        return "Placa: " + placa + "\n" +
                "Tipo: " + tipo + "\n";
    }
}
