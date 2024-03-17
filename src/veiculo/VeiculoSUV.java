package veiculo;

public class VeiculoSUV extends Veiculo {
    public VeiculoSUV(String placa) {
        super(placa, TipoVeiculo.SUV);
    }

    @Override
    public double obterTarifaDiaria() {
        return 200d;
    }
}
