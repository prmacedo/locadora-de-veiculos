package InterfaceUsuario.GerenciaMenu;

import Gerenciadores.GerenciadorDePessoa;
import pessoa.Pessoa;

import static utils.EntraValores.entradaString;

public class MenuClientes {

    private static final GerenciadorDePessoa gerenciadorDePessoa = new GerenciadorDePessoa();

    public static void cadastraPessoa() {
        gerenciadorDePessoa.cadastrarPessoa(
                entradaString("Digite o nome: "),
                entradaString("Digite documento: ")
        );
    }

    public static void buscaCliente() {
        Pessoa pessoaEncontrada = gerenciadorDePessoa.buscarPessoa(
                entradaString("Digite o termo para busca: ")
        );
        if (pessoaEncontrada != null) {
            System.out.println("Cliente encontrado: \n" + pessoaEncontrada);
        } else {
            System.out.println("Nenhum cliente encontrado.");
        }
    }

    public static void listaPessoas(){
        gerenciadorDePessoa.listarPessoas();

    }

    public static void alteraCliente() {
                gerenciadorDePessoa.alterarPessoa(
                        entradaString("Digite documento antigo: "),
                        entradaString("Digite documento novo: "),
                        entradaString("Digite novo nome: ")
        );
    }
}
