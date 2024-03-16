import Gerenciadores.GerenciadorDePessoa;
import Gerenciadores.GerenciadorDeVeiculo;
import InterfaceUsuario.Menu;
import veiculo.TipoVeiculo;

import java.util.Scanner;

public class Main extends Menu {
    public static void main(String[] args) throws InterruptedException {
        Mockup.init();

        while (true) {
            Menu.menuPrincipal();
        }
    }
}