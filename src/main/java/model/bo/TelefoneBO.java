package model.bo;

import model.dao.EnderecoDAO;
import model.dao.TelefoneDAO;
import model.entity.Telefone;

import java.util.ArrayList;

public class TelefoneBO {

    public ArrayList<Telefone> buscarTodos() {
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        return telefoneDAO.buscarTodos();
    }
}
