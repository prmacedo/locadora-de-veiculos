package InterfaceUsuario;

import MenuVeiculos.GerenciaVeiculos;

public enum MenuAluguel implements OpcaoMenu {

    ALUGAR_VEICULO(GerenciaVeiculos::listaVeiculo),
    DEVOLVER_VEICULO(GerenciaVeiculos::listaVeiculo);


    private final Runnable acao;

    MenuAluguel(Runnable acao) {
        this.acao = acao;
    }

    public void executar() {
        acao.run();
    }
}
