package arquivosDB;

import pessoa.Pessoa;
import pessoa.PessoaFisica;
import pessoa.PessoaJuridica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArquivoClientes {

    private static final String CAMINHO_CLIENTESSBD = "./src/DB/clientesDB.txt";
    private static File pessoas;

    public ArquivoClientes(){
        verificarArquivo();
    }

    public static void carregarPessoas(List<Pessoa> pessoas) {
        verificarArquivo();
        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_CLIENTESSBD))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                String nome = dados[0];
                String documento = dados[1];
                String tipo = dados[2];
                if(dados[2].length() >= 12) pessoas.add(new PessoaJuridica(nome, documento));
                pessoas.add(new PessoaFisica(nome, documento));
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar clientes: " + e.getMessage());
        }
    }

    public static void salvarPessoa(List<Pessoa> pessoas) {
        verificarArquivo();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CAMINHO_CLIENTESSBD))) {
            for (Pessoa pessoa : pessoas) {
                bw.write(pessoa.getNome() + ";" + pessoa.getDocumento() + ";" + pessoa.getTipo() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar clientes: " + e.getMessage());
        }
    }

    public static void verificarArquivo() {
        pessoas = new File(CAMINHO_CLIENTESSBD);
        try {
            if (!pessoas.exists()) {
                pessoas.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Erro ao verificar o arquivo: " + e.getMessage());
        }
    }

}
