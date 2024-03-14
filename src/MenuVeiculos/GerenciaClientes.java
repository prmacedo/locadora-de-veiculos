package MenuVeiculos;

import Gerenciadores.GerenciadorDePessoa;
import Gerenciadores.GerenciadorDeVeiculo;
import pessoa.Pessoa;
import veiculo.Veiculo;

import static utils.EntraValores.entradaString;

public class GerenciaClientes {

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
}
