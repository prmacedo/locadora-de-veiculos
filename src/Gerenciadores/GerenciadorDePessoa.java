package Gerenciadores;

import gerenciaDB.ArquivoClientes;
import pessoa.Pessoa;

import java.util.List;

public class GerenciadorDePessoa {
    private static List<Pessoa> pessoas = ArquivoClientes.carregarPessoas();;

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

    public static Pessoa buscarPessoaPorTermo(String termoDeBusca) {
        return pessoas.stream()
                .filter(pessoa -> pessoa.getDocumento().contains(termoDeBusca))
                .findFirst().orElse(null);
    }

    public static Pessoa buscarPessoa(String documento) {
        return pessoas.stream()
                .filter(pessoa -> pessoa.getDocumento().equals(documento))
                .findFirst().orElse(null);
    }

    public static List<Pessoa> obterPessoas() {
        return pessoas;
    }

    private static Pessoa pessoaExiste(Pessoa pessoaProcurada) {
        return pessoas.stream().filter(pessoa -> pessoa.equals(pessoaProcurada)).findFirst().orElse(null);
    }
}
