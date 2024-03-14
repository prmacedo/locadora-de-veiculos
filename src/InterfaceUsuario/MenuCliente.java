package InterfaceUsuario;

import InterfaceUsuario.GerenciaMenu.MenuClientes;

public enum MenuCliente implements OpcaoMenu {

    CADASTRAR_CLIENTE(MenuClientes::cadastraPessoa),
    BUSCAR_CLIENTE(MenuClientes::buscaCliente),
    LISTAR_CLIENTES(MenuClientes::listaPessoas),
    ALTERAR_CLIENTE(MenuClientes::listaPessoas);

    private final Runnable acao;

    MenuCliente(Runnable acao) {
        this.acao = acao;
    }

    public void executar() {
        acao.run();
    }
}
