package InterfaceUsuario;

import MenuVeiculos.GerenciaClientes;

public enum MenuCliente implements OpcaoMenu {

    CADASTRAR_CLIENTE(GerenciaClientes::cadastraPessoa),
    BUSCAR_CLIENTE(GerenciaClientes::buscaCliente),
    LISTAR_CLIENTES(GerenciaClientes::listaPessoas),
    ALTERAR_CLIENTE(GerenciaClientes::listaPessoas);

    private final Runnable acao;

    MenuCliente(Runnable acao) {
        this.acao = acao;
    }

    public void executar() {
        acao.run();
    }
}
