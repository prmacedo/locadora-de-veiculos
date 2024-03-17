package gerenciaDB.serializer;

import Gerenciadores.GerenciadorDeVeiculo;
import pessoa.Pessoa;
import pessoa.PessoaFisica;
import pessoa.PessoaJuridica;
import veiculo.TipoVeiculo;
import veiculo.Veiculo;

public class TratandoEntidadesParaArquivoAluguel {


    protected static String serializarPessoa(Pessoa pessoa) {
        return pessoa.getNome() + ";" + pessoa.getDocumento() + ";" +pessoa.getTipo()  ;
    }

    protected static Pessoa desserializarPessoa(String dadosPessoa) {
        String[] dados = dadosPessoa.split(";");

        String nome = dados[0];
        String documento = dados[1];
        String tipo = dados[2];

        if (tipo.equals("PF")) {
            return new PessoaFisica(nome, documento);
        } else  {
            return new PessoaJuridica(nome, documento);
        }
    }

    protected static String serializarVeiculo(Veiculo veiculo) {
        return veiculo.getPlaca() + ";" + veiculo.getTipo();
    }

    protected static Veiculo desserializarVeiculo(String dadosVeiculo) {
        String[] dados = dadosVeiculo.split(";");
        String placa = dados[0];
        TipoVeiculo tipo = TipoVeiculo.valueOf(dados[1]);

        return GerenciadorDeVeiculo.criarVeiculo(placa, tipo);
    }

}
