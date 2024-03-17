package gerenciaDB;

import Gerenciadores.GerenciadorDeVeiculo;
import veiculo.TipoVeiculo;
import veiculo.Veiculo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArquivoVeiculos {

    private static final String CAMINHO_VEICULOSBD = "./src/DB/veiculosDB.txt";
    private static File veiculos;

public ArquivoVeiculos(){
    verificarArquivo();
}

    public static List<Veiculo>  carregarVeiculos() {
        verificarArquivo();

        List<Veiculo> veiculos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_VEICULOSBD))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                String placa = dados[0];
                TipoVeiculo tipo = TipoVeiculo.valueOf(dados[1]);
                veiculos.add(GerenciadorDeVeiculo.criarVeiculo(placa, tipo));
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar veículos: " + e.getMessage());
        }

        return veiculos;
    }

    public static void salvarVeiculo(List<Veiculo> veiculos) {
        verificarArquivo();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CAMINHO_VEICULOSBD))) {
            for (Veiculo veiculo : veiculos) {
                bw.write(veiculo.getPlaca() + ";" + veiculo.getTipo() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar veículos: " + e.getMessage());
        }
    }

    public static void verificarArquivo() {
        veiculos = new File(CAMINHO_VEICULOSBD);
        try {
            if (!veiculos.exists()) {
                veiculos.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Erro ao verificar o arquivo: " + e.getMessage());
        }
    }

}