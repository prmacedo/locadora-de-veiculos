import pessoa.Pessoa;
import pessoa.PessoaFisica;
import pessoa.PessoaJuridica;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDePessoa {
    private List<Pessoa> pessoas = new ArrayList<>();

    public void cadastrarPessoa(String nome, String documento) {
        if (this.pessoaExiste(documento) != null) {
            return;
        }
        // verificar o tipo de pessoa pelo documento informado:
        if (documento.length() > 12) {
            Pessoa pessoaNova = new PessoaJuridica(nome, documento);
            this.pessoas.add(pessoaNova);
        } else {
            Pessoa pessoaNova = new PessoaFisica(nome, documento);
            this.pessoas.add(pessoaNova);
        }
    }
    public Pessoa buscarPessoa(String termoDeBusca) {
        return this.pessoas.stream()
                .filter(pessoa -> pessoa.getDocumento().contains(termoDeBusca.toUpperCase()))
                .findFirst().orElse(null);
    }

    public void listarPessoas() {
        if (this.pessoas.isEmpty()) {
            System.out.println("Ainda não há pessoas cadastradas.");
            return;
        }

        System.out.println("|    Documento    |       Nome      ");
        System.out.println("| --------------- | --------------- ");

        for (Pessoa pessoa : this.pessoas) {
            System.out.println("| " + String.format("%15s", pessoa.getDocumento()) + " | " + String.format("%15s", pessoa.getNome()));
        }
    }

    private Pessoa pessoaExiste(String documento) {
        return this.pessoas.stream().filter(pessoa -> pessoa.getDocumento().equalsIgnoreCase(documento)).findFirst().orElse(null);
    }

}
