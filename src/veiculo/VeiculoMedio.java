package veiculo;

public class VeiculoMedio extends Veiculo {
    public VeiculoMedio(String placa) {
        super(placa, TipoVeiculo.MEDIO);
    }

    @Override
    public double obterTarifaDiaria() {
        return 150d;
    }
}
