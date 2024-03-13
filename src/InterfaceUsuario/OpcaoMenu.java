package InterfaceUsuario;

import pessoa.Pessoa;
import veiculo.Veiculo;

public enum OpcaoMenu {
    CADASTRAR_VEICULOS(Veiculo::cadastrarVeiculos),
    ALTERAR_VEICULO(Veiculo::alterarVeiculo),
    BUSCAR_VEICULO(Veiculo::buscarVeiculo),
    CADASTRAR_CLIENTE(Pessoa::cadastrarCliente),
    ALTERAR_CLIENTE(Pessoa::alterarCliente),
    ALUGAR_VEICULO(Veiculo::alugarVeiculo),
    DEVOLVER_VEICULO(Veiculo::devolverVeiculo),
    SAIR(Menu::sair);

    private final Runnable acao;

    OpcaoMenu(Runnable acao) {
        this.acao = acao;
    }

    public void executar() {
        acao.run();
    }
}
