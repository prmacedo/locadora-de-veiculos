package InterfaceUsuario;

import InterfaceUsuario.GerenciaMenu.MenuVeiculos;

public enum MenuAluguel implements OpcaoMenu {

    ALUGAR_VEICULO(MenuVeiculos::listaVeiculo),
    DEVOLVER_VEICULO(MenuVeiculos::listaVeiculo);


    private final Runnable acao;

    MenuAluguel(Runnable acao) {
        this.acao = acao;
    }

    public void executar() {
        acao.run();
    }
}
