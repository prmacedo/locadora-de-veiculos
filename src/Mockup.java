import Gerenciadores.GerenciadorDeVeiculo;
import veiculo.*;

public class Mockup {
    public static void init() {
        adicionarVeiculos();
    }

    private static void adicionarVeiculos() {
        GerenciadorDeVeiculo.cadastrarVeiculo(new VeiculoSUV("POO2X24"));
        GerenciadorDeVeiculo.cadastrarVeiculo(new VeiculoPequeno("JAV4K12"));
        GerenciadorDeVeiculo.cadastrarVeiculo(new VeiculoMedio("SOL1D55"));
        GerenciadorDeVeiculo.cadastrarVeiculo(new VeiculoPequeno("ABC3D18"));
        GerenciadorDeVeiculo.cadastrarVeiculo(new VeiculoMedio("NLC4A45"));
        GerenciadorDeVeiculo.cadastrarVeiculo(new VeiculoMedio("NPC4F09"));
        GerenciadorDeVeiculo.cadastrarVeiculo(new VeiculoSUV("HGD5A77"));
    }
}
