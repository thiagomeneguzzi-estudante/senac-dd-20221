package selector;

import java.util.Locale;

public class PhoneSelector {

    private String ddd;
    private String ddi;
    private String estado;

    public PhoneSelector() {
        super();
    }

    public boolean temFiltro() {
        if ((this.getDdi() != null) && (this.getDdi().trim().length() > 0)) {
            return true;
        }
        if ((this.getDdd() != null) && (this.getDdd().trim().length() > 0)) {
            return true;
        }
        if ((this.getEstado() != null) && (this.getEstado().trim().length()  > 0)) {
            return true;
        }

        return false;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
