package pessoa;

public class PessoaJuridica extends Pessoa{
    public PessoaJuridica(String nome, String documento) {
        super(nome, documento);
        this.setTipo("PJ");
    }

    @Override
    public String toString() {
        return "Pessoa Juridica: " +
                "nome: " + nome + "\n" +
                "documento: " + documento + "\n";
    }
}
