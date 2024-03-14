package desconto;

public class DescontoPessoaJuridica implements Desconto {
    @Override
    public double calcularDesconto(int numeroDeDiarias) {
        double desconto = 0;

        if (numeroDeDiarias >= 5) {
            desconto = 10 / 100d;
        }

        return desconto;
    }
}
