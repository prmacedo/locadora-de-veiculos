package veiculo;

public class VeiculoPequeno extends Veiculo {
    public VeiculoPequeno(String placa) {
        super(placa, TipoVeiculo.PEQUENO);
    }

    @Override
    public double obterTarifaDiaria() {
        return 100d;
    }
}
