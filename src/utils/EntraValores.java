package utils;

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
}
