package model.entity;

import java.time.LocalDateTime;

public class LinhaTelefonica {

    private int id;
    private int idTelefone;
    private int idCliente;
    private LocalDateTime dataAtivacao;
    private LocalDateTime dataDesativacao;

    public LinhaTelefonica(int idTelefone, int idCliente) {
        this.idTelefone = idTelefone;
        this.idCliente = idCliente;
    }

    public LinhaTelefonica() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(int idTelefone) {
        this.idTelefone = idTelefone;
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

    @Override
    public String toString() {
        return "LinhaTelefonica{" +
                "id=" + id +
                ", idTelefone=" + idTelefone +
                ", idCliente=" + idCliente +
                ", dataAtivacao=" + dataAtivacao +
                ", dataDesativacao=" + dataDesativacao +
                '}';
    }
}
