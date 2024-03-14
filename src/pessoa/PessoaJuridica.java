package pessoa;

public class PessoaJuridica extends Pessoa{
    public PessoaJuridica(String nome, String documento) {
        super(nome, documento);
    }
    @Override
    public String toString() {
        return "Pessoa Física: " +
                "nome: " + nome + "\n" +
                "documento: " + documento + "\n";
    }
}
