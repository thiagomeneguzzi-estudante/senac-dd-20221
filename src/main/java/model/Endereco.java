package main.java.model;

public class Endereco {

    private int id;
    private String rua;
    private int cep;
    private String uf;
    private String cidade;
    private int numero;

    public Endereco() {
        super();
    }

    public Endereco(String rua, int cep, String uf, String cidade, int numero) {
        super();
        this.rua = rua;
        this.cep = cep;
        this.uf = uf;
        this.cidade = cidade;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                ", cep=" + cep +
                ", uf='" + uf + '\'' +
                ", cidade='" + cidade + '\'' +
                ", numero=" + numero +
                '}';
    }
}
