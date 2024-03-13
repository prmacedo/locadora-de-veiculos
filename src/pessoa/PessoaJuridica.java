package pessoa;

public class PessoaJuridica extends Pessoa{
    public PessoaJuridica(String nome, String documento) {
        super(nome, documento);
    }
    @Override
    public String toString() {
        return "Pessoa Jurídica{" +
                "nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                '}';
    }
}
