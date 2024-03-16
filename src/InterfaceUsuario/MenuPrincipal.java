package InterfaceUsuario;


public enum MenuPrincipal  {

    MENU_CLIENTES(Menu::menuClientes),
    MENU_VEICULOS(Menu::menuVeiculos),
    MENU_ALUGEL(Menu::menuAluguel),
    SAIR(Menu::sair);

    private final Runnable acao;

    MenuPrincipal(Runnable acao) {
        this.acao = acao;
    }

    public void executar() {
        acao.run();
    }
}