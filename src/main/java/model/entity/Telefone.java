package model.entity;

public class Telefone {

    public static int TIPO_FIXO = 1;
    public static int TIPO_MOVEL = 2;

    private int numero;
    private int ddd;
    private int ddi;
    private int tipo;
    private boolean ativo;

    public Telefone() {
        super();
        this.tipo = TIPO_FIXO;
        this.ativo = false;
    }

    public Telefone(int numero, int ddd, int ddi, int tipo, boolean ativo) {
        super();
        this.numero = numero;
        this.ddd = ddd;
        this.ddi = ddi;
        this.tipo = tipo;
        this.ativo = ativo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getDdi() {
        return ddi;
    }

    public void setDdi(int ddi) {
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
        return "Telefone{" +
                "numero=" + numero +
                ", ddd=" + ddd +
                ", ddi=" + ddi +
                ", tipo=" + tipo +
                ", ativo=" + ativo +
                '}';
    }
}
