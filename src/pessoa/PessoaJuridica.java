package pessoa;

public class PessoaJuridica extends Pessoa {
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

    @Override
    public double obterDesconto(int numeroDeDiarias) {
        double desconto = 0;

        if (numeroDeDiarias >= 5) {
            desconto = 10 / 100d;
        }

        return desconto;
    }
}
