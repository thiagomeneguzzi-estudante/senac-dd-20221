package model.bo;

import model.dao.TelefoneDAO;
import model.entity.Telefone;
import selector.PhoneSelector;

import java.util.ArrayList;

public class TelefoneBO {

    public ArrayList<Telefone> buscarTodos() {
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        return telefoneDAO.buscarTodos();
    }

    public ArrayList<Telefone> buscarTodosComFiltro(PhoneSelector phoneSelector) {
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        return telefoneDAO.buscarTodosComFiltro(phoneSelector);
    }
}
