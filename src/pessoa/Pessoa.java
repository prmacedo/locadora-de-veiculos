package pessoa;

import desconto.ObterDesconto;

import java.util.Objects;

public abstract class Pessoa implements ObterDesconto {
    protected String nome;
    protected String documento;

    //protected String tipo; //Apenas para visualização nos arquivos de texto do BD

    public Pessoa(String documento) {
        this.documento = documento;
    }

    public Pessoa(String nome, String documento) {
        this(documento);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipo() {
        return this.getClass().getName().replaceAll("pessoa.","");
    }

//    public void setTipo(String tipo) {
//        this.tipo = tipo;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pessoa pessoa = (Pessoa) obj;
        return Objects.equals(documento, pessoa.documento);
    }

}
