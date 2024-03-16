package pessoa;

public class PessoaFisica extends Pessoa{
    public PessoaFisica(String nome, String documento) {
        super(nome, documento);
        this.setTipo("PF");
    }
    @Override
    public String toString() {
        return "Pessoa Física: " +
                "nome: " + nome + "\n" +
                "documento: " + documento + "\n";
    }
}
