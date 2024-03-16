import Gerenciadores.GerenciadorDeVeiculo;
import veiculo.TipoVeiculo;
import veiculo.Veiculo;

public class Mockup {
    public static void init() {
        adicionarVeiculos();
    }

    private static void adicionarVeiculos() {
        GerenciadorDeVeiculo.cadastrarVeiculo(new Veiculo("POO2X24", TipoVeiculo.SUV));
        GerenciadorDeVeiculo.cadastrarVeiculo(new Veiculo("JAV4K12", TipoVeiculo.PEQUENO));
        GerenciadorDeVeiculo.cadastrarVeiculo(new Veiculo("SOL1D55", TipoVeiculo.MEDIO));
        GerenciadorDeVeiculo.cadastrarVeiculo(new Veiculo("ABC3D18", TipoVeiculo.PEQUENO));
        GerenciadorDeVeiculo.cadastrarVeiculo(new Veiculo("NLC4A45", TipoVeiculo.MEDIO));
        GerenciadorDeVeiculo.cadastrarVeiculo(new Veiculo("NPC4F09", TipoVeiculo.MEDIO));
        GerenciadorDeVeiculo.cadastrarVeiculo(new Veiculo("HGD5A77", TipoVeiculo.SUV));
    }
}
