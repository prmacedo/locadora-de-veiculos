package InterfaceUsuario;

import MenuVeiculos.GerenciaVeiculos;

public enum MenuCliente implements OpcaoMenu {

    CADASTRAR_CLIENTE(GerenciaVeiculos::listaVeiculo),
    BUSCAR_CLIENTE(GerenciaVeiculos::listaVeiculo),
    LISTAR_CLIENTES(GerenciaVeiculos::listaVeiculo),
    ALTERAR_CLIENTE(GerenciaVeiculos::listaVeiculo);

    private final Runnable acao;

    MenuCliente(Runnable acao) {
        this.acao = acao;
    }

    public void executar() {
        acao.run();
    }
}
