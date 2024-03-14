package InterfaceUsuario;

import MenuVeiculos.GerenciaVeiculos;

public enum MenuVeiculo implements OpcaoMenu {
    CADASTRAR_VEICULOS(GerenciaVeiculos::cadastraVeiculo),
    ALTERAR_VEICULO(GerenciaVeiculos::alteraVeiculo),
    BUSCAR_VEICULO(GerenciaVeiculos::buscaVeiculo),
    LISTAR_VEICULOS(GerenciaVeiculos::listaVeiculo);



    private final Runnable acao;

    MenuVeiculo(Runnable acao) {
        this.acao = acao;
    }

    public void executar() {
        acao.run();
    }
}
