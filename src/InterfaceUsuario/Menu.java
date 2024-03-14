package InterfaceUsuario;

import veiculo.TipoVeiculo;
import veiculo.Veiculo;

import java.util.ArrayList;
import java.util.Arrays;

import static utils.EntraValores.entradaInt;

public class Menu {

    static int opcao;

    static ArrayList<String> opcoesMenu = new ArrayList<>(Arrays.asList(
            "CLIENTES",
            "VEICULOS",
            "ALUGUEL"));

    static ArrayList<String> opcoesMenuVeiculo = new ArrayList<>(Arrays.asList(
            "Cadastrar Veiculos",
            "Alterar Veiculo",
            "Buscar Veiculo",
            "Listar Veiculo"
    ));

    static ArrayList<String> opcoesMenuCliente = new ArrayList<>(Arrays.asList(
            "Cadastrar Cliente",
            "Buscar Cliente",
            "Listar Cliente",
            "Alterar Cliente"
    ));

    static ArrayList<String> opcoesMenuAluguel = new ArrayList<>(Arrays.asList(
            "Alugar Veiculo",
            "Devolver Veiculo"
    ));

    public static void menuPrincipal() {
        limpaTela();

        System.out.println("------------- MENU -------------");
        for (int i = 0; i < opcoesMenu.size(); i++) {

            System.out.println("|    " + (i + 1) + " - " + String.format("%-21s", opcoesMenu.get(i)) + " |");


        }
        System.out.println("|    " + "0" + " - " + String.format("%-21s", "SAIR") + " |");
        System.out.println("--------------------------------");
        opcao = entradaInt("Escolha a opcao: ");
        switch (opcao) {
            case 1:
                menuClientes();
                break;
            case 2:
                menuVeiculos();
                break;
            case 3:
                menuAluguel();
                break;
            case 0:
                sair();
                break;
            default:
                System.out.println("Opcao invalida!");
                try {
                    Thread.sleep(3000);
                    limpaTela();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                break;
        }
    }


    protected static void limpaTela() {
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
        System.out.println();
//        System.out.print("\n".repeat(50));
    }

    public static void sair() {
        System.out.println("Saindo do programa...");
        System.exit(0);
    }

    public static void menuClientes() {
        menuBase(MenuCliente.class, opcoesMenuCliente, "CLIENTE");
        menuClientes();

    }

    public static void menuVeiculos() {
        menuBase(MenuVeiculo.class, opcoesMenuVeiculo, "VEICULO");
        menuVeiculos();
    }

    public static void menuAluguel() {
        menuBase(MenuAluguel.class, opcoesMenuAluguel, "ALUGUEL");
        menuAluguel();
    }

    public static void menuTipoVeiculo() {
        TipoVeiculo[] tipos = TipoVeiculo.values();
        ArrayList<String> opcoes = new ArrayList<>();

        for (TipoVeiculo tipo : tipos) {
            opcoes.add(tipo.name());
        }

        menuBase(TipoVeiculo.class, opcoes, " TIPOS ");
    }

    public static <T extends Enum<T> & OpcaoMenu> void menuBase(Class<T> enumClass, ArrayList<String> opcoes, String titulo) {
        T[] values = enumClass.getEnumConstants();

        System.out.printf("------------ %s ------------%n" +
                "", titulo);
        for (int i = 0; i < values.length; i++) {
            System.out.println("|    " + (i + 1) + " - " + String.format("%-22s", opcoes.get(i)) + " |");
        }
        System.out.println("|    " + (values.length + 1) + " - " + String.format("%-22s", "Menu Principal") + " |");
        System.out.println("|    " + "0" + " - " + String.format("%-22s", "SAIR") + " |");
        System.out.println("---------------------------------");
        opcao = entradaInt("Escolha a opção: ");
        if (opcao == 0) sair();
        if (opcao == values.length + 1) {
            menuPrincipal();
            return;
        }
        if (opcao >= 1 && opcao <= values.length) {
            values[opcao - 1].executar();
        } else {
            System.out.println("Opção inválida!");
            try {
                Thread.sleep(3000);
                limpaTela();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

