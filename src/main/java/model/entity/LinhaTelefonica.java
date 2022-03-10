package model.entity;

import java.time.LocalDateTime;

public class LinhaTelefonica {

    private int id;
    private Telefone telefone;
    private int idCliente;
    private LocalDateTime dataAtivacao;
    private LocalDateTime dataDesativacao;

    public LinhaTelefonica(int id, Telefone telefone, int idCliente, LocalDateTime dataAtivacao, LocalDateTime dataDesativacao) {
        this.id = id;
        this.telefone = telefone;
        this.idCliente = idCliente;
        this.dataAtivacao = dataAtivacao;
        this.dataDesativacao = dataDesativacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getDataAtivacao() {
        return dataAtivacao;
    }

    public void setDataAtivacao(LocalDateTime dataAtivacao) {
        this.dataAtivacao = dataAtivacao;
    }

    public LocalDateTime getDataDesativacao() {
        return dataDesativacao;
    }

    public void setDataDesativacao(LocalDateTime dataDesativacao) {
        this.dataDesativacao = dataDesativacao;
    }
}
