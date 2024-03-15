package Gerenciadores;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

import InterfaceUsuario.Menu;
import registro.*;
import pessoa.*;
import veiculo.*;

import static InterfaceUsuario.Menu.limpaTela;

public class GerenciadorDeRegistro {

    List<Registro> registros;

    public GerenciadorDeRegistro(){
        this.registros = new ArrayList<>();
    }

    public void alugarVeiculo(String local, LocalDateTime dataHora, Pessoa cliente, Veiculo veiculo){
        if (estaAlugado(veiculo)){
            System.out.println("Veículo já está alugado");
            return;
        }
        this.registros.add(new Aluguel(local, dataHora, cliente, veiculo));
    }

    private boolean estaAlugado(Veiculo veiculo) {
        return buscarRegistros(veiculo).size()%2 != 0;
    }

    public void devolverVeiculo(String local, LocalDateTime dataHora, Pessoa cliente, Veiculo veiculo){
        if(!estaAlugado(veiculo)){
            System.out.println("Veículo não está alugado!");
            return;
        }
        this.registros.add(new Devolucao(local, dataHora, cliente, veiculo));
    }

    public List<Registro> buscarRegistros(Veiculo veiculo){
        List<Registro> registrosEncontrados = new ArrayList<>();
        for(Registro registro: this.registros){
            if (registro.getVeiculo().equals(veiculo)){
                registrosEncontrados.add(registro);
            }
        }
        if (registrosEncontrados.size() <= 0) {
            System.out.println("Nenhum registro encontrado!");
            try {
                Thread.sleep(3000);
                limpaTela();
                Menu.menuAluguel();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
            return registrosEncontrados;
    }
                           
    private int calcularDiarias(Aluguel aluguel, Devolucao devolucao) {
        long diferencaEmMinutos = aluguel.getDataHora().until(devolucao.getDataHora(), ChronoUnit.MINUTES);
        double diferencaEmDias = diferencaEmMinutos / 1440d;
        double diasArredondados = Math.ceil(diferencaEmDias);

        return (int) diasArredondados;
    }

}
