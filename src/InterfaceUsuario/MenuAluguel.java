package InterfaceUsuario;

import InterfaceUsuario.GerenciaMenu.MenuRegistros;

public enum MenuAluguel implements OpcaoMenu {

    ALUGAR_VEICULO(MenuRegistros::alugaVeiculo),
    DEVOLVER_VEICULO(MenuRegistros::devolveVeiculo),
    BUSCAR_REGISTROS(MenuRegistros::buscaRegitro);

    private final Runnable acao;

    MenuAluguel(Runnable acao) {
        this.acao = acao;
    }

    public void executar() {
        acao.run();
    }
}
