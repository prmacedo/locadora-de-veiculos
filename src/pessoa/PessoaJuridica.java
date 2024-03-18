package pessoa;

public class PessoaJuridica extends Pessoa {
    public PessoaJuridica(String nome, String documento) {
        super(nome, documento);
        this.tipo = "PJ";
    }

    @Override
    public String toString() {
        return "Pessoa Juridica: \n" +
                "Nome: " + nome + "\n" +
                "Documento: " + documento + "\n";
    }

    @Override
    public double obterDesconto(int numeroDeDiarias) {
        double desconto = 0;

        if (numeroDeDiarias >= 3) {
            desconto = 10 / 100d;
        }

        return desconto;
    }
}
