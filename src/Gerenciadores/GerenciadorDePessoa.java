package Gerenciadores;

import InterfaceUsuario.Menu;
import arquivosDB.ArquivoClientes;
import pessoa.Pessoa;
import pessoa.PessoaFisica;
import pessoa.PessoaJuridica;
import utils.Paginacao;

import java.util.ArrayList;
import java.util.List;

import static InterfaceUsuario.Menu.limpaTela;

public class GerenciadorDePessoa {
    private List<Pessoa> pessoas = new ArrayList<>();

    private int resultadosPorPagina = 5;
    private int paginaAtual = 1;

    public GerenciadorDePessoa(){
        ArquivoClientes.carregarPessoas(pessoas);
    }

    public void cadastrarPessoa(String nome, String documento) {
        if (this.pessoaExiste(documento) != null) {
            return;
        }
        documento = removerCaracteres(documento);
        if (documento.length() >= 12) {
            Pessoa pessoaNova = new PessoaJuridica(nome, documento);
            this.pessoas.add(pessoaNova);
        } else {
            Pessoa pessoaNova = new PessoaFisica(nome, documento);
            this.pessoas.add(pessoaNova);
        }
        ArquivoClientes.salvarPessoa(pessoas);
    }

    public void alterarPessoa(String documentoAntigo, String documentoNovo, String nomeNovo) {
        Pessoa documentoBuscado = this.pessoaExiste(documentoAntigo);
        if (documentoBuscado == null) {
            return;
        }
        documentoNovo = removerCaracteres(documentoNovo);
        if (documentoAntigo.equals(documentoNovo) && this.pessoaExiste(documentoNovo) != null) {
            return;
        }
        if (!documentoNovo.isEmpty()) {
            documentoBuscado.setDocumento(documentoNovo);
        }
        if (!nomeNovo.trim().isEmpty()) {
            documentoBuscado.setNome(nomeNovo);
        }
        System.out.println(documentoBuscado.toString());
        ArquivoClientes.salvarPessoa(pessoas);
    }

    public Pessoa buscarPessoa(String termoDeBusca) {
        return this.pessoas.stream()
                .filter(pessoa -> pessoa.getDocumento().contains(removerCaracteres(termoDeBusca)))
                .findFirst().orElse(null);
    }

    public void listarPessoas() {
        if (pessoas.size() <= 0) {
            System.out.println("Nenhum cliente cadastrado!");
            try {
                Thread.sleep(3000);
                limpaTela();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            Menu.menuClientes();
        }
        Paginacao.paginando(pessoas, 5);
    }

    private Pessoa pessoaExiste(String documento) {
        return this.pessoas.stream().filter(pessoa -> pessoa.getDocumento().equalsIgnoreCase(documento)).findFirst().orElse(null);
    }

    private String removerCaracteres(String documento) {
        return documento.trim().replaceAll("[^0-9]", "");
    }
}
