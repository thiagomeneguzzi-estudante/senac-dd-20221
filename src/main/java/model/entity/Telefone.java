package model.entity;

public class Telefone {

    public static int TIPO_FIXO = 1;
    public static int TIPO_MOVEL = 2;

    private int id;
    private String numero;
    private String ddd;
    private String ddi;
    private int tipo;
    private boolean ativo;

    public Telefone() {
        super();
        this.tipo = TIPO_FIXO;
        this.ativo = false;
    }

    public Telefone(String numero, String ddd, String ddi, int tipo, boolean ativo) {
        super();
        this.numero = numero;
        this.ddd = ddd;
        this.ddi = ddi;
        this.tipo = tipo;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        this.ddi = ddi;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "{"+numero+" - ativo: "+ ativo+ "}";
    }
}
