package InterfaceUsuario;

import GerenciadorDePessoa;
import GerenciadorDeVeiculo;

public enum OpcaoMenu {
    CADASTRAR_VEICULOS(() -> GerenciadorDeVeiculo.cadastrarVeiculo()),
    ALTERAR_VEICULO(() -> GerenciadorDeVeiculo.alterarVeiculo()),
    BUSCAR_VEICULO(() -> GerenciadorDeVeiculo.buscarVeiculo()),
    LISTAR_VEICULOS(() -> GerenciadorDeVeiculo.listarVeiculos()),
    ALUGAR_VEICULO(() -> GerenciadorDeVeiculo.alugarVeiculo()),
    DEVOLVER_VEICULO(() -> GerenciadorDeVeiculo.devolverVeiculo()),
    CADASTRAR_CLIENTE(() -> GerenciadorDePessoa.cadastrarPessoa()),
    BUSCAR_CLIENTE(() -> GerenciadorDePessoa.buscarPessoa()),
    LISTAR_CLIENTES(() -> GerenciadorDePessoa.listarPessoas()),
    ALTERAR_CLIENTE(() -> GerenciadorDePessoa.alterarCliente()),
    SAIR(Menu::sair);

    private final Runnable acao;

    OpcaoMenu(Runnable acao) {
        this.acao = acao;
    }

    public void executar() {
        acao.run();
    }
}