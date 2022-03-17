package model.entity;

import java.util.List;

public class Cliente {

    private int id;
    private String nome;
    private String cpf;
    private List<LinhaTelefonica> linhas;
    private Endereco endereco;

    public Cliente(String nome, String cpf, List<LinhaTelefonica> linhas, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.linhas = linhas;
        this.endereco = endereco;
    }

    public Cliente() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<LinhaTelefonica> getLinhas() {
        return linhas;
    }

    public void setLinhas(List<LinhaTelefonica> linhas) {
        this.linhas = linhas;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", linhas=" + linhas +
                ", endereco=" + endereco +
                '}';
    }
}
