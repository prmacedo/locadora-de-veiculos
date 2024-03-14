package desconto;

public class DescontoPessoaFisica implements Desconto {
    @Override
    public double calcularDesconto(int numeroDeDiarias) {
        double desconto = 0;

        if (numeroDeDiarias >= 3) {
            desconto = 5 / 100d;
        }

        return desconto;
    }
}
