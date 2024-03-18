import Gerenciadores.*;
import pessoa.*;
import veiculo.*;

public class Mockup {
    public static void init() {

        adicionarVeiculos();
        adicionarClientes();
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

    private static void adicionarClientes() {
        GerenciadorDePessoa.cadastrarPessoa(new PessoaFisica("Fulano", "12345678910"));
        GerenciadorDePessoa.cadastrarPessoa(new PessoaJuridica("Loja do Fulano", "66499961000109"));
        GerenciadorDePessoa.cadastrarPessoa(new PessoaJuridica("Loja do Cicrano", "16499961000109"));
        GerenciadorDePessoa.cadastrarPessoa(new PessoaJuridica("Loja do beltrano", "66499961002109"));
        GerenciadorDePessoa.cadastrarPessoa(new PessoaFisica("cicrano", "12345678911"));
        GerenciadorDePessoa.cadastrarPessoa(new PessoaJuridica("beltrano", "12345678918"));
    }
}
