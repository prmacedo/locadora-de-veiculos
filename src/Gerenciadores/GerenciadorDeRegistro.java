package Gerenciadores;

import java.time.temporal.ChronoUnit;
import java.util.*;

import gerenciaDB.ArquivoRegistro;
import registro.*;
import pessoa.*;
import veiculo.*;

import static gerenciaDB.ArquivoRegistro.carregarRegistrosGerais;


public class GerenciadorDeRegistro {

    private static List<Registro> registros = ArquivoRegistro.carregarRegistrosGerais();
    private static List<Aluguel> alugueis = ArquivoRegistro.carregarAlugueis();

    public static boolean alugarVeiculo(Aluguel aluguel){
        if (estaAlugado(aluguel.getVeiculo())){
            return false;
        }
        alugueis.add(aluguel);
        registros.add(aluguel);
        ArquivoRegistro.salvarAluguel(alugueis);
        ArquivoRegistro.salvarRegistrosGerais(registros);

        return true;
    }

    public static boolean estaAlugado(Veiculo veiculo) {
        return buscarRegistros(veiculo).size()%2 != 0;
    }

    public static boolean devolverVeiculo(Devolucao devolucao){
            Aluguel aluguel = buscarAluguel(devolucao.getVeiculo(), devolucao.getCliente());
            if(aluguel == null){
                return false;
            }
            devolucao.setAlugado(false);
            registros.add(devolucao);
            ArquivoRegistro.removerAluguel(devolucao);
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

    private static List<Registro> buscarRegistros(Veiculo veiculo){
        List<Registro> registrosEncontrados = new ArrayList<>();
        for(Registro registro: registros){
            if (registro.getVeiculo().equals(veiculo)){
                registrosEncontrados.add(registro);
            }
        }
        return registrosEncontrados;
    }

    public static List<Registro> buscarRegistros(String placaVeiculo) {
        List<Registro> registrosEncontrados = new ArrayList<>();
        List<Registro> registros = carregarRegistrosGerais();

        for (Registro registro : registros) {
            if (registro.getVeiculo().getPlaca().equalsIgnoreCase(placaVeiculo)) {
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
