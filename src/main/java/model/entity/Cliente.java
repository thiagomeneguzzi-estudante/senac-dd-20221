package model.entity;

import java.util.List;

public class Cliente {

    private int id;
    private String nome;
    private String cpf;
    private List<Telefone> telefones;
    private Endereco endereco;

    public Cliente(String nome, String cpf, List<Telefone> telefones, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefones = telefones;
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

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
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
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefones=" + telefones +
                ", endereco=" + endereco +
                '}';
    }
}
