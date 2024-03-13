package pessoa;

public class PessoaFisica extends Pessoa{
    public PessoaFisica(String nome, String documento) {
        super(nome, documento);
    }
    @Override
    public String toString() {
        return "Pessoa Física{" +
                "nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                '}';
    }
}
