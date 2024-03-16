package utils;

import veiculo.TipoVeiculo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EntraValores {
    static Scanner scanner = new Scanner(System.in);

    public static int entradaInt(String mensagem) {
        int valor;
        do {
            try {
                System.out.print(mensagem);
                valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida!\nPor favor, digite um numero valido.");
                scanner.nextLine();
            }
        } while (true);
    }

    public static String entradaString(String mensagem) {
        System.out.println(mensagem);
        return scanner.nextLine();
    }

    public static String entradaStringNotEmpty(String mensagem) {
        String value = "";

        while (value.isEmpty()) {
            System.out.print(mensagem);
            value = scanner.nextLine();
        }

        return value;
    }

    public static double entradaDouble(String mensagem) {
        double valor;
        do {
            try {
                System.out.print(mensagem);
                valor = scanner.nextDouble();
                scanner.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, digite um número decimal.");
                scanner.nextLine();
            }
        } while (true);
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

    public static LocalDateTime entradaLocalDateTime(String mensagem) {
        LocalDateTime dataHora;
        do {
            try {
                System.out.print(mensagem);
                String input = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                dataHora = LocalDateTime.parse(input, formatter);
                return dataHora;
            } catch (Exception e) {
                System.out.println("Entrada inválida! Por favor, digite a data e hora no formato correto (yyyy-MM-dd HH:mm:ss).");
            }
        } while (true);
    }
}
