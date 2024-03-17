package Gerenciadores;

import java.time.temporal.ChronoUnit;
import java.util.*;

import registro.*;
import pessoa.*;
import veiculo.*;


public class GerenciadorDeRegistro {

    private static List<Registro> registros = new ArrayList<>();

    public static boolean alugarVeiculo(Aluguel aluguel){
        if (estaAlugado(aluguel.getVeiculo())){
            return false;
        }
        registros.add(aluguel);
        return true;
    }

    private static boolean estaAlugado(Veiculo veiculo) {
        return buscarRegistros(veiculo).size()%2 != 0;
    }

    public static boolean devolverVeiculo(Devolucao devolucao, Aluguel aluguel){
        if(!estaAlugado(devolucao.getVeiculo()) && !devolucao.getCliente().equals(aluguel.getCliente())){
            return false;
        }
        registros.add(devolucao);
        return true;
    }

    public static Aluguel buscarAluguel(Veiculo veiculo, Pessoa cliente) {
        List<Registro> registrosInvertidos = new ArrayList<>(registros);
        Collections.reverse(registrosInvertidos);

        return (Aluguel) registrosInvertidos.stream().filter(
                registro -> (
                        registro instanceof Aluguel &&
                                registro.getCliente().equals(cliente) &&
                                registro.getVeiculo().equals(veiculo)))
                .findFirst().orElse(null);
    }

    public static List<Registro> buscarRegistros(Veiculo veiculo){
        List<Registro> registrosEncontrados = new ArrayList<>();
        for(Registro registro: registros){
            if (registro.getVeiculo().equals(veiculo)){
                registrosEncontrados.add(registro);
            }
        }
        return registrosEncontrados;
    }
                           
    public static int calcularDiarias(Aluguel aluguel, Devolucao devolucao) {
        long diferencaEmMinutos = aluguel.getDataHora().until(devolucao.getDataHora(), ChronoUnit.MINUTES);
        double diferencaEmDias = diferencaEmMinutos / 1440d;
        double diasArredondados = Math.ceil(diferencaEmDias);

        return (int) diasArredondados;
    }

}
