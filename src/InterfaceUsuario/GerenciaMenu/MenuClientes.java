package InterfaceUsuario.GerenciaMenu;

import Gerenciadores.GerenciadorDePessoa;
import InterfaceUsuario.Menu;
import pessoa.Pessoa;
import pessoa.PessoaFisica;
import pessoa.PessoaJuridica;
import utils.Paginacao;

import java.util.List;

import static InterfaceUsuario.Menu.limpaTela;
import static utils.FormataString.manterApenasNumeros;

import static utils.EntraValores.entradaStringNotEmpty;

public class MenuClientes {
    public static void cadastraPessoa() {
        String nome = entradaStringNotEmpty("Digite o nome: ");
        String documento = entradaStringNotEmpty("Digite documento: ");
        documento = manterApenasNumeros(documento);

        Pessoa pessoaNova;
        if (documento.length() >= 12) {
            pessoaNova = new PessoaJuridica(nome, documento);
        } else {
            pessoaNova = new PessoaFisica(nome, documento);
        }

        boolean pessoaCadastrada = GerenciadorDePessoa.cadastrarPessoa(pessoaNova);

        System.out.println(pessoaCadastrada ? "Pessoa cadastrada com sucesso!" : "Não foi possível cadastrar pessoa.");
    }

    public static void buscaCliente() {
        Pessoa pessoaEncontrada = GerenciadorDePessoa.buscarPessoa(
                entradaStringNotEmpty("Digite o termo para busca: ")
        );
        if (pessoaEncontrada != null) {
            System.out.println("Cliente encontrado: \n" + pessoaEncontrada);
        } else {
            System.out.println("Nenhum cliente encontrado.");
        }
    }

    public static void listaPessoas(){
        List<Pessoa> pessoas = GerenciadorDePessoa.obterPessoas();

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

    public static void alteraCliente() {
        String documentoAntigo = entradaStringNotEmpty("Digite documento antigo: ");
        documentoAntigo = manterApenasNumeros(documentoAntigo);

        Pessoa pessoa = GerenciadorDePessoa.buscarPessoa(documentoAntigo);

        String documentoNovo = entradaStringNotEmpty("Digite documento novo: ");
        documentoNovo = manterApenasNumeros(documentoNovo);

        String nomeNovo = entradaStringNotEmpty("Digite novo nome: ");

        boolean pessoaAlterada;
        if (pessoa instanceof PessoaJuridica) {
            PessoaJuridica pessoaJuridica = new PessoaJuridica(nomeNovo, documentoNovo);
            pessoaAlterada = GerenciadorDePessoa.alterarPessoa(pessoa, pessoaJuridica);
        } else {
            PessoaFisica pessoaFisica = new PessoaFisica(nomeNovo, documentoNovo);
            pessoaAlterada = GerenciadorDePessoa.alterarPessoa(pessoa, pessoaFisica);
        }

        System.out.println(pessoaAlterada ? "Pessoa alterada com sucesso!" : "Não foi possível alterar a pessoa.");
    }
}
