package InterfaceUsuario;

import InterfaceUsuario.GerenciaMenu.MenuVeiculos;

public enum MenuVeiculo implements OpcaoMenu {
    CADASTRAR_VEICULOS(MenuVeiculos::cadastraVeiculo),
    ALTERAR_VEICULO(MenuVeiculos::alteraVeiculo),
    BUSCAR_VEICULO(MenuVeiculos::buscaVeiculo),
    LISTAR_VEICULOS(MenuVeiculos::listaVeiculo);



    private final Runnable acao;

    MenuVeiculo(Runnable acao) {
        this.acao = acao;
    }

    public void executar() {
        acao.run();
    }
}
