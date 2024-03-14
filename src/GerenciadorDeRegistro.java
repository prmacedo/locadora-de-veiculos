import java.time.LocalDateTime;
import java.util.*;
import registro.*;
import pessoa.*;
import veiculo.*;


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
        this.registros.add(new Aluguel(local, dataHora, cliente, veiculo);
    }

    private boolean estaAlugado(Veiculo veiculo) {
        return buscarRegistros(veiculo).size()%2 != 0;
    }

    public void devolverVeiculo(String local, LocalDateTime dataHora, Pessoa cliente, Veiculo veiculo){
        if(!estaAlugado(veiculo)){
            System.out.println("Veículo não está alugado!");
            return;
        }
        this.registros.add(new Devolucao(local, dataHora, cliente, veiculo))
    }

    public List<Registro> buscarRegistros(Veiculo veiculo){
        List<Registro> registrosEncontrados = new ArrayList<>();
        for(Registro registro: this.registros){
            if (registro.getVeiculo().equals(veiculo)){
                registrosEncontrados.add(registro);
            }
        }
        return registrosEncontrados;
    }



}
