package InterfaceUsuario;

import java.util.ArrayList;
import java.util.Arrays;

import static utils.EntraValores.entradaInt;

public class Menu {

    static int opcao;

    public static void mostraMenu() {
        limpaTela();
        ArrayList<String> opcoesMenu = new ArrayList<>(Arrays.asList(
                "Cadastrar Veiculos",
                "Alterar Veiculo",
                "Buscar Veiculo",
                "Cadastrar Cliente",
                "Alterar Cliente",
                "Alugar Veiculo",
                "Devolver Veiculo"
        ));
        System.out.println("------------- MENU -------------");
        for (int i = 0; i < opcoesMenu.size(); i++) {
            System.out.println("|    " + (i + 1) + " - " + String.format("%-21s", opcoesMenu.get(i)) + " |");
        }
        System.out.println("|    " + "0" + " - " + String.format("%-21s", "SAIR") + " |");
        System.out.println("--------------------------------");
        opcao = entradaInt("Escolha a opcao: ");
        if (opcao == 0) sair();
        if (opcao >= 0 && opcao <= opcoesMenu.size()) {
            OpcaoMenu.values()[opcao - 1].executar();
        } else {
            System.out.println("Opcao invalida!");
            try {
                Thread.sleep(3000);
                limpaTela();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }


    protected static void limpaTela() {
//        System.out.print("\u001b[H\u001b[2J");
//        System.out.flush();
        System.out.print("\n".repeat(50));
    }

    public static void sair() {
        System.out.println("Saindo do programa...");
        System.exit(0);
    }
}
