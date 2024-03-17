package gerenciaDB;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gerenciaDB.serializer.TratandoEntidadesParaArquivoAluguel;
import registro.Aluguel;
import registro.Devolucao;
import registro.Registro;
import veiculo.Veiculo;
import pessoa.Pessoa;


public class ArquivoRegistro extends TratandoEntidadesParaArquivoAluguel {
    private static final String CAMINHO_ALUGUEISBD = "./src/DB/alugueisDB.txt";
    private static final String CAMINHO_REGISTROSBD = "./src/DB/registrosDB.txt";

    private static File alugueis;
    private static File registros;

    public static List<Aluguel> carregarAlugueis() {
        verificarArquivoAlugueis();
        return carregarRegistros(CAMINHO_ALUGUEISBD);
    }

    public static List<Registro> carregarRegistrosGerais() {
        verificarArquivoRegistros();
        return carregarRegistros(CAMINHO_REGISTROSBD);
    }

    public static void salvarAluguel(List<Aluguel> alugueis) {
        String caminho = CAMINHO_ALUGUEISBD;
        verificarArquivoAlugueis();
        salvarRegistros(alugueis, caminho);
    }

    public static void salvarRegistrosGerais(List<Registro> registrosGerais) {
        String caminho = CAMINHO_REGISTROSBD;
        verificarArquivoRegistros();
        salvarRegistros(registrosGerais, caminho);
    }


    public static void removerAluguel(Devolucao devolucao) {
        List<Aluguel> alugueis = carregarAlugueis();
        List<Registro> registros = carregarRegistrosGerais();

        String documento = devolucao.getCliente().getDocumento();
        String placa = devolucao.getVeiculo().getPlaca();

        Aluguel aluguelToRemove = alugueis.stream()
                .filter(aluguel -> aluguel.getCliente().getDocumento().equals(documento) && aluguel.getVeiculo().getPlaca().equals(placa))
                .findFirst()
                .orElse(null);

        if (aluguelToRemove != null) {
            alugueis.remove(aluguelToRemove);
            salvarAluguel(alugueis);

            Registro novoRegistro = new Devolucao(devolucao.getLocal(), devolucao.getDataHora(), devolucao.getCliente(), devolucao.getVeiculo(), false);
            registros.add(novoRegistro);
            salvarRegistrosGerais(registros);
        }
    }

    public static <T> List<T> carregarRegistros(String caminho) {
        List<Registro> registros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                String local = dados[0];
                LocalDateTime dataHora = LocalDateTime.parse(dados[1]);
                Pessoa cliente = desserializarPessoa(dados[2] + ";" + dados[3] + ";" + dados[4]);
                Veiculo veiculo = desserializarVeiculo(dados[5] + ";" + dados[6]);
                boolean alugado = Boolean.parseBoolean(dados[7]);
                registros.add(new Aluguel(local, dataHora, cliente, veiculo, alugado));
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar registros: " + e.getMessage());
        }
        return (List<T>) registros;
    }

    public static void salvarRegistros(List<? extends Registro> registros, String caminho) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
            for (Registro registro : registros) {
                boolean alugado = registro instanceof Aluguel;
                String linha = registro.getLocal() + ";" +
                        registro.getDataHora() + ";" +
                        serializarPessoa(registro.getCliente()) + ";" +
                        serializarVeiculo(registro.getVeiculo()) + ";" + alugado;
                bw.write(linha + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar registros: " + e.getMessage());
        }
    }

    private static void verificarArquivoAlugueis() {
        alugueis = new File(CAMINHO_ALUGUEISBD);
        verificarArquivo(alugueis);
    }

    private static void verificarArquivoRegistros() {
        registros = new File(CAMINHO_REGISTROSBD);
        verificarArquivo(registros);
    }

    private static void verificarArquivo(File arquivo) {
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Erro ao verificar o arquivo: " + e.getMessage());
        }
    }
}
