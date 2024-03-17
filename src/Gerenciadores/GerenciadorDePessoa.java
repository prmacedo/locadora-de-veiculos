package Gerenciadores;

import arquivosDB.ArquivoClientes;
import pessoa.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDePessoa {
    private static List<Pessoa> pessoas = new ArrayList<>();

    public GerenciadorDePessoa(){
        ArquivoClientes.carregarPessoas(pessoas);
    }

    public static  <T extends Pessoa> boolean cadastrarPessoa(T pessoa) {
        if (pessoaExiste(pessoa) != null) {
            return false;
        }

        pessoas.add(pessoa);
        ArquivoClientes.salvarPessoa(pessoas);

        return true;
    }

    public static <T extends Pessoa> boolean alterarPessoa(Pessoa pessoa, T pessoaNova) {
        Pessoa pessoaBuscada = pessoaExiste(pessoa);
        if (pessoaBuscada == null) {
            return false;
        }

        if (pessoaExiste(pessoaNova) != null) {
            return false;
        }

        pessoaBuscada.setNome(pessoaNova.getNome());
        pessoaBuscada.setDocumento(pessoaNova.getDocumento());

        ArquivoClientes.salvarPessoa(pessoas);

        return true;
    }

    public static Pessoa buscarPessoa(String termoDeBusca) {
        return pessoas.stream()
                .filter(pessoa -> pessoa.getDocumento().contains(termoDeBusca))
                .findFirst().orElse(null);
    }

    public static List<Pessoa> obterPessoas() {
        return pessoas;
    }

    private static Pessoa pessoaExiste(Pessoa pessoaProcurada) {
        return pessoas.stream().filter(pessoa -> pessoa.equals(pessoaProcurada)).findFirst().orElse(null);
    }
}
