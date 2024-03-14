package utils;

import veiculo.TipoVeiculo;

import java.util.Scanner;

public class EntraValores {
    static Scanner scanner = new Scanner(System.in);

    public static int entradaInt(String mensagem) {
        System.out.print(mensagem);
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    public static String entradaString(String mensagem) {
        System.out.println(mensagem);
        return scanner.nextLine();
    }

    public static double entradaDouble(String mensagem) {
        System.out.print(mensagem);
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }

    public static TipoVeiculo entradaTipoVeiculo(String mensagem) {
        System.out.println(mensagem);
        TipoVeiculo[] tipos = TipoVeiculo.values();
            System.out.println("----- TIPO VEICULO -----");
        for (int i = 0; i < tipos.length; i++) {
            System.out.println((i + 1) + ". " + tipos[i]);
        }

        int opcao;
        do {
            System.out.print("Escolha o tipo: ");
            opcao = scanner.nextInt();
        } while (opcao < 1 || opcao > tipos.length);

        return tipos[opcao - 1];
    }
}
