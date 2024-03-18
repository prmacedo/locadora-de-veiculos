package pessoa;

public class PessoaFisica extends Pessoa {
    public PessoaFisica(String nome, String documento) {
        super(nome, documento);
        this.setTipo("PF");
    }
    @Override
    public String toString() {
        return "Pessoa Física: \n" +
                "Nome: " + nome + "\n" +
                "Documento: " + documento + "\n";
    }

    @Override
    public double obterDesconto(int numeroDeDiarias) {
        double desconto = 0;

        if (numeroDeDiarias >= 5) {
            desconto = 5 / 100d;
        }

        return desconto;
    }
}
