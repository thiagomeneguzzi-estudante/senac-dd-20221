package model.entity;

public class Endereco {

    private int id;
    private String rua;
    private String cep;
    private String uf;
    private String cidade;
    private int numero;

    public Endereco() {
        super();
    }

    public Endereco(String rua, String cep, String uf, String cidade, int numero) {
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
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
        return "Endereço: "+rua+", "+numero+", "+cidade+", "+uf+", "+cep;

    }
}
