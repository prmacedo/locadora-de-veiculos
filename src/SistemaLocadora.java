import pessoa.Pessoa;
import registro.Registro;
import veiculo.Veiculo;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class SistemaLocadora {
    private List<Pessoa> clientes = new ArrayList<>();
    private List<Registro> historico = new ArrayList<>();
    private List<Veiculo> veiculos = new ArrayList<>();

    public <T extends Pessoa> void cadastrarCliente(String nome, String documento) {}

    public void alterarCliente(String documento, String nomeNovo) {}

    public void cadastrarVeiculo(String placa, String tipo) {}

    public void alterarVeiculo(String placa, String tipoNovo) {}

    public void buscarVeiculo(String termoDeBusca) {}

    public void listarVeiculos() {}

    public <T extends Registro> void cadastrarRegistro(String local, String hora, LocalDate data) {}
}
