package utils;

import InterfaceUsuario.Menu;
import pessoa.Pessoa;
import veiculo.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static InterfaceUsuario.Menu.limpaTela;

public class Paginacao {

    public static <T> void paginando(List<T> listaTipos, int porPagina){
        int resultadosPorPagina = porPagina;
        int paginaAtual = 1;
        Class<?> classe = listaTipos.get(0).getClass();

        int totalPaginas = (int) Math.ceil((double) listaTipos.size() / resultadosPorPagina);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            int startIndex = (paginaAtual - 1) * resultadosPorPagina;
            int endIndex = Math.min(startIndex + resultadosPorPagina, listaTipos.size());

            if(Veiculo.class.isAssignableFrom(classe)) {
                System.out.println("|         Placa        |          Tipo        |");
                System.out.println("| -------------------- | -------------------- |");
            }
            if(Pessoa.class.isAssignableFrom(classe)) {
                System.out.println("|       Documento      |          Nome        |");
                System.out.println("| -------------------- | -------------------- |");
            }


            for (int i = startIndex; i < endIndex; i++) {
                T tipo = listaTipos.get(i);
                if(Pessoa.class.isAssignableFrom(classe)) {
                    Pessoa pessoa = (Pessoa) tipo;
                    System.out.println("| " + String.format("%20s", pessoa.getDocumento()) + " | " + String.format("%20s", pessoa.getNome()) + " |");
                }

                if(Veiculo.class.isAssignableFrom(classe))
                {
                    Veiculo veiculo = (Veiculo) tipo;
                    System.out.println("| " + String.format("%20s", veiculo.getPlaca()) + " | " + String.format("%20s", veiculo.getTipo()) + " |");
                }

            }

            System.out.println("-----------------------------------------------");

            System.out.println("Pagina " + paginaAtual + " de " + totalPaginas);

            System.out.println("Enter proxima pagina ('s' para sair): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("s") && Pessoa.class.isAssignableFrom(classe)) {
                Menu.menuClientes();
            }
            if (input.equalsIgnoreCase("s") && Veiculo.class.isAssignableFrom(classe)) {
                Menu.menuVeiculos();
            }
            if (input.equalsIgnoreCase("s")) {
                Menu.menuPrincipal();
            }

            if (paginaAtual < totalPaginas) {
                paginaAtual++;
            } else {
                paginaAtual = 1;
            }
//            scanner.close();
            limpaTela();
        }
//
//        Paginacao.paginando(ArrayList<Pessoa> pessoas, int 5);
    }
}
